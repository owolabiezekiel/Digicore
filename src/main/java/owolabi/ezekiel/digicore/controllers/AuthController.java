package owolabi.ezekiel.digicore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owolabi.ezekiel.digicore.config.jwt.JwtProvider;
import owolabi.ezekiel.digicore.dtos.request.UserLoginRequestDto;
import owolabi.ezekiel.digicore.dtos.request.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.dtos.response.FailedRequestResponse;
import owolabi.ezekiel.digicore.dtos.response.UserLoginResponse;
import owolabi.ezekiel.digicore.dtos.response.UserSignupResponse;
import owolabi.ezekiel.digicore.models.UserAccount;
import owolabi.ezekiel.digicore.services.implementation.AuthServiceImplementation;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {
  @Autowired
  private AuthServiceImplementation authService;
  @Autowired
  private JwtProvider jwtProvider;

  @PostMapping("/create_account")
  public ResponseEntity<Object> registerUser(@RequestBody UserSignUpRequestDto userSignUpDetails) {
    if(userSignUpDetails.getAccountPassword() == null || userSignUpDetails.getAccountName() == null || userSignUpDetails.getInitialDeposit() == null){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "Some required fields are missing"));
    }

    boolean userAccountExists = authService.accountExists(userSignUpDetails.getAccountName());
    if(userAccountExists){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "An account with this username already exists. Please sign in instead"));
    }

    if(userSignUpDetails.getInitialDeposit() < 500.0){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "Minimum initial balance required is 500"));
    }

    UserAccount userAccount = authService.signUp(userSignUpDetails);
    if(userAccount != null) {
      return ResponseEntity.status(HttpStatus.OK).body(new UserSignupResponse(HttpStatus.OK.value(), true, "User Account created successfully with acount number " + userAccount.getAccountNumber()));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "User could not be created"));
  }





  @PostMapping("/login")
  public ResponseEntity<Object> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
    UserAccount userAccount = authService.login(userLoginRequestDto.getAccountNumber(), userLoginRequestDto.getAccountPassword());
    if (userAccount != null) {
      String token = jwtProvider.generateToken(userLoginRequestDto.getAccountNumber());
      return ResponseEntity.status(HttpStatus.OK).body(new UserLoginResponse(true, token));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "User with account number " + userLoginRequestDto.getAccountNumber()
        + " not found"));
  }
}

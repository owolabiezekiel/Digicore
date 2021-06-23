package owolabi.ezekiel.digicore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owolabi.ezekiel.digicore.config.jwt.JwtFilter;
import owolabi.ezekiel.digicore.config.jwt.JwtProvider;
import owolabi.ezekiel.digicore.dtos.DepositRequestDTO;
import owolabi.ezekiel.digicore.dtos.DepositResponse;
import owolabi.ezekiel.digicore.dtos.FailedRequestResponse;
import owolabi.ezekiel.digicore.dtos.GetUserAccountResponse;
import owolabi.ezekiel.digicore.entities.UserAccount;
import owolabi.ezekiel.digicore.services.AccountService;
import owolabi.ezekiel.digicore.services.AuthService;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(path = "/account")
public class AccountController {
  @Autowired
  private AccountService accountService;

  @Autowired
  private AuthService authService;


  @Autowired
  private JwtFilter jwtFilter;
  @Autowired
  private JwtProvider jwtProvider;

  @GetMapping("/account_info/{accountNumber}")
  public ResponseEntity<Object> getAccount(HttpServletRequest request, @PathVariable("accountNumber") String accountNumber) {
    String token = jwtFilter.getTokenFromRequest(request);
    if(token == null){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new FailedRequestResponse(false, "Please provide token"));
    }

    boolean userAccountExists = authService.accountNumberExists(accountNumber);
    if(!userAccountExists){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FailedRequestResponse(false, "No account with this number exists."));
    }

    if (!jwtProvider.validateToken(token)){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "Invalid Token"));
    }

    String accountNumberFromToken = jwtProvider.getAccountNumberFromToken(token);
    if(!accountNumberFromToken.equalsIgnoreCase(accountNumber)){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new FailedRequestResponse(false, "Oops. You are not the owner of this account"));
    }

    UserAccount thisUser = authService.findByAccountNumber(accountNumber);
    return ResponseEntity.status(HttpStatus.OK).body(new GetUserAccountResponse(HttpStatus.OK.value(), true, "Welcome to your account", thisUser));
  }

  @PostMapping("/deposit")
  public ResponseEntity<Object> depositMoney (HttpServletRequest request, @RequestBody DepositRequestDTO depositRequestDTO){
    String token = jwtFilter.getTokenFromRequest(request);
    if(token == null){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new FailedRequestResponse(false, "Please provide token"));
    }


    if (!jwtProvider.validateToken(token)){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "Invalid Token"));
    }

    if(depositRequestDTO.getAmount() < 1.0 || depositRequestDTO.getAmount() > 1000000.0){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedRequestResponse(false, "Invalid amount. Amount must be greater than 1 and less than 1000001"));
    }
    String accountNumberFromToken = jwtProvider.getAccountNumberFromToken(token);

    if(accountNumberFromToken.equalsIgnoreCase(depositRequestDTO.getAccountNumber())){
      accountService.depositToSelf(accountNumberFromToken, depositRequestDTO.getAmount());
    }else{
      boolean creditUserAccountExists = authService.accountNumberExists(depositRequestDTO.getAccountNumber());
      if(!creditUserAccountExists){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FailedRequestResponse(false, "No account with this number exists. deposit cancelled"));
      }
      accountService.depositToOthers(depositRequestDTO.getAccountNumber(), accountNumberFromToken, depositRequestDTO.getAmount());
    }
    return ResponseEntity.status(HttpStatus.OK).body(new DepositResponse(HttpStatus.OK.value(), true, "Transaction created successfully"));
  }


}
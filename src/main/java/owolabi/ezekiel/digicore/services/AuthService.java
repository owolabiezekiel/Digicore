package owolabi.ezekiel.digicore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.dtos.UserLoginRequestDto;
import owolabi.ezekiel.digicore.dtos.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.entities.UserAccount;
import owolabi.ezekiel.digicore.repository.UserAccountRepository;

import java.util.ArrayList;

@Service
public class AuthService {
  @Autowired
  private UserAccountRepository userAccountRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserAccount signUp(UserSignUpRequestDto userSignUpDto){
    userSignUpDto.setAccountPassword(passwordEncoder.encode(userSignUpDto.getAccountPassword()));
    return userAccountRepository.saveUser(userSignUpDto);
  }

  public UserAccount login(UserLoginRequestDto userLoginRequestDto){
    UserAccount userAccount = findByAccountNumber(userLoginRequestDto.getAccountNumber());
    if(userAccount != null){
      if(passwordEncoder.matches(userLoginRequestDto.getAccountPassword(), userAccount.getAccountPassword())){
        return userAccount;
      }
    }
    return null;
  }

  public boolean accountExists(String accountNumber){
    return userAccountRepository.checkAccountExists(accountNumber);
  }

  public UserAccount findByAccountNumber(String accountNumber){
    return userAccountRepository.getUserByAccountNumber(accountNumber);
  }

  public ArrayList<UserAccount> getAllUserAccounts(){
    return userAccountRepository.getAllUserAccounts();
  }

  public int getNumberOfAccounts(){
    return userAccountRepository.accountCount();
  }

}

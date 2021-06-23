package owolabi.ezekiel.digicore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.dtos.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.entities.UserAccount;
import owolabi.ezekiel.digicore.repository.UserAccountRepository;


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

  public UserAccount login(String accountNumber, String password){
    UserAccount userAccount = findByAccountNumber(accountNumber);
    if(userAccount != null){
      if(passwordEncoder.matches(password, userAccount.getAccountPassword())){
        return userAccount;
      }
    }
    return null;
  }

  public boolean accountExists(String accountName){
    return userAccountRepository.checkAccountExists(accountName);
  }

  public boolean accountNumberExists(String accountNumber){
    return userAccountRepository.checkAccountNumberExists(accountNumber);
  }

  public UserAccount findByAccountNumber(String accountNumber){
    return userAccountRepository.getUserByAccountNumber(accountNumber);
  }
}

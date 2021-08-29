package owolabi.ezekiel.digicore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.dtos.request.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.models.UserAccount;
import owolabi.ezekiel.digicore.repository.UserAccountRepository;
import owolabi.ezekiel.digicore.services.interfaces.AuthService;


@Service
@CacheConfig(cacheNames = {"Auth"})
public class AuthServiceImplementation implements AuthService {
  @Autowired
  private UserAccountRepository userAccountRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserAccount signUp(UserSignUpRequestDto userSignUpDto){
    userSignUpDto.setAccountPassword(passwordEncoder.encode(userSignUpDto.getAccountPassword()));
    return userAccountRepository.saveUser(userSignUpDto);
  }



  @Cacheable(key = "#accountNumber")
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

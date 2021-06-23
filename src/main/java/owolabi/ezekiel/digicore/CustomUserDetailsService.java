package owolabi.ezekiel.digicore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import owolabi.ezekiel.digicore.config.CustomUserDetails;
import owolabi.ezekiel.digicore.entities.UserAccount;
import owolabi.ezekiel.digicore.services.AuthService;

@Component
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private AuthService authService;

  @Override
  public CustomUserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException {
    UserAccount userAccount = authService.findByAccountNumber(accountNumber);
    return CustomUserDetails.fromUserEntityToCustomUserDetails(userAccount);
  }
}

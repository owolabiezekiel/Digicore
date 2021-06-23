package owolabi.ezekiel.digicore.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import owolabi.ezekiel.digicore.entities.UserAccount;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
  private String accountNumber;
  private String password;
  private Double initialDeposit;

  public static CustomUserDetails fromUserEntityToCustomUserDetails(UserAccount userAccount){
    CustomUserDetails c = new CustomUserDetails();
    c.accountNumber = userAccount.getAccountNumber();
    c.password = userAccount.getAccountPassword();
    c.initialDeposit = userAccount.getInitialDeposit();
    return c;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return accountNumber;
  }

  public double getInitialDeposit() { return initialDeposit; }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

package owolabi.ezekiel.digicore.dtos;

public class UserLoginRequestDto {
  private String accountNumber;
  private String accountPassword;

  public UserLoginRequestDto(String accountNumber, String accountPassword) {
    this.accountNumber = accountNumber;
    this.accountPassword = accountPassword;
  }

  public String getAccountPassword() {
    return accountPassword;
  }

  public void setAccountPassword(String accountPassword) {
    this.accountPassword = accountPassword;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountPassword = accountNumber;
  }
}

package owolabi.ezekiel.digicore.dtos;

public class UserSignUpRequestDto {
  private String accountName;
  private String accountPassword;
  private Double initialDeposit;

  public UserSignUpRequestDto(String accountName, String accountPassword, Double initialDeposit) {
    this.accountName = accountName;
    this.accountPassword = accountPassword;
    this.initialDeposit = initialDeposit;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountPassword() {
    return accountPassword;
  }

  public void setAccountPassword(String accountPassword) {
    this.accountPassword = accountPassword;
  }

  public Double getInitialDeposit() {
    return initialDeposit;
  }

  public void setInitialDeposit(Double initialDeposit) {
    this.initialDeposit = initialDeposit;
  }
}







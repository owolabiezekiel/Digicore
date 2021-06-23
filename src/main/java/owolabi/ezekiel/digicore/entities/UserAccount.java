package owolabi.ezekiel.digicore.entities;

public class UserAccount {
  private String accountName;
  private String accountPassword;
  private String accountNumber;
  private Double initialDeposit;

  public UserAccount() {
  }

  public UserAccount(String accountName, String accountPassword, String accountNumber, Double initialDeposit) {
    this.accountName = accountName;
    this.accountPassword = accountPassword;
    this.accountNumber = accountNumber;
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

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Double getInitialDeposit() {
    return initialDeposit;
  }

  public void setInitialDeposit(Double initialDeposit) {
    this.initialDeposit = initialDeposit;
  }
}

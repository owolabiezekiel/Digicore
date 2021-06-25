package owolabi.ezekiel.digicore.models;

public class UserAccount {
  private String accountName;
  private String accountPassword;
  private String accountNumber;
  private Double balance;

  public UserAccount() {
  }

  public UserAccount(String accountName, String accountPassword, String accountNumber, Double balance) {
    this.accountName = accountName;
    this.accountPassword = accountPassword;
    this.accountNumber = accountNumber;
    this.balance = balance;
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

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }
}

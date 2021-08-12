package owolabi.ezekiel.digicore.models;

import io.swagger.annotations.ApiModelProperty;

public class UserAccount {
  @ApiModelProperty(value = "First name before last name")
  private String accountName;
  @ApiModelProperty(value = "Password has to be more than 5 characters in length")
  private String accountPassword;
  @ApiModelProperty(value = "This is auto-generated, no need to supply")
  private String accountNumber;
  @ApiModelProperty(value = "Starting balance must be greater than or equal to 500")
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

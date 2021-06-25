package owolabi.ezekiel.digicore.dtos.request;

public class WithdrawRequestDto {
  private String accountNumber;
  private String accountPassword;
  private double amount;

  public WithdrawRequestDto(String accountNumber, String accountPassword, double amount) {
    this.accountNumber = accountNumber;
    this.accountPassword = accountPassword;
    this.amount = amount;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountPassword() {
    return accountPassword;
  }

  public void setAccountPassword(String accountPassword) {
    this.accountPassword = accountPassword;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}

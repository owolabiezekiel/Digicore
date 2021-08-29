package owolabi.ezekiel.digicore.models;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
  private String accountNumber;
  private Date transactionDate;
  private TransactionType transactionType;
  private String narration;
  private Double amount;
  private Double transactionBalance;

  public Transaction(){}

  public Transaction(String accountNumber, Date transactionDate, TransactionType transactionType, String narration, Double amount, Double transactionBalance) {
    this.accountNumber = accountNumber;
    this.transactionDate = transactionDate;
    this.transactionType = transactionType;
    this.narration = narration;
    this.amount = amount;
    this.transactionBalance = transactionBalance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public String getNarration() {
    return narration;
  }

  public void setNarration(String narration) {
    this.narration = narration;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getTransactionBalance() {
    return transactionBalance;
  }

  public void setTransactionBalance(Double transactionBalance) {
    this.transactionBalance = transactionBalance;
  }
}

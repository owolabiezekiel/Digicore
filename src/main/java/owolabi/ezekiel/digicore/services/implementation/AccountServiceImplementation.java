package owolabi.ezekiel.digicore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.models.Transaction;
import owolabi.ezekiel.digicore.models.TransactionType;
import owolabi.ezekiel.digicore.repository.TransactionRepository;
import owolabi.ezekiel.digicore.repository.UserAccountRepository;
import owolabi.ezekiel.digicore.services.interfaces.AccountService;

import java.util.ArrayList;
import java.util.Date;


@Service
@CacheConfig(cacheNames = {"Account"})
public class AccountServiceImplementation implements AccountService {
  @Autowired
  private UserAccountRepository userAccountRepository;
  @Autowired
  private TransactionRepository transactionRepository;

  public Transaction depositToSelf(String accountNumber, double amount){
    double balance = userAccountRepository.creditMyAccount(accountNumber, amount);
    Transaction transaction = new Transaction();
    transaction.setAccountNumber(accountNumber);
    transaction.setTransactionType(TransactionType.DEPOSIT);
    transaction.setAmount(amount);
    transaction.setTransactionBalance(balance);
    transaction.setNarration("I deposited " + amount + " Naira on " + new Date().toString() + " to my account.");
    transaction.setTransactionDate(new Date());
    return transactionRepository.createTransaction(transaction);
  }





  public Transaction depositToOthers(String creditAccountNumber, String debitAccountNumber, double amount){
    double balance = userAccountRepository.creditAnotherAccount(creditAccountNumber, debitAccountNumber, amount);
    Transaction transaction = new Transaction();
    transaction.setAccountNumber(debitAccountNumber);
    transaction.setTransactionType(TransactionType.DEPOSIT);
    transaction.setAmount(amount);
    transaction.setTransactionBalance(balance);
    transaction.setNarration("I deposited " + amount + " Naira on " + new Date().toString() + " to " + creditAccountNumber);
    transaction.setTransactionDate(new Date());
    return transactionRepository.createTransaction(transaction);
  }





  public Transaction withdraw(String accountNumber, double amount){
    double balance = userAccountRepository.debitAccount(accountNumber, amount);
    Transaction transaction = new Transaction();
    transaction.setAccountNumber(accountNumber);
    transaction.setTransactionType(TransactionType.WITHDRAWAL);
    transaction.setAmount(amount);
    transaction.setTransactionBalance(balance);
    transaction.setNarration("I withdrew " + amount + " Naira on " + new Date().toString());
    transaction.setTransactionDate(new Date());
    return transactionRepository.createTransaction(transaction);
  }





  public ArrayList<Transaction> getAccountStatement(String accountNumber){
    return transactionRepository.getTransactionsForAccountNumber(accountNumber);
  }
}

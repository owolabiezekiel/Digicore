package owolabi.ezekiel.digicore.repository;

import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionRepository {
  public static ArrayList<Transaction> transactions = new ArrayList<>();

  public Transaction createTransaction(Transaction transaction){
    transactions.add(transaction);
    return transaction;
  }

  public ArrayList<Transaction> getTransactionsForAccountNumber(String accountNumber){
    ArrayList<Transaction> accountTransactions = new ArrayList<>();
    for(Transaction transaction: transactions){
      if(transaction.getAccountNumber().equalsIgnoreCase(accountNumber)){
        accountTransactions.add(transaction);
      }
    }
    return accountTransactions.size() > 0 ? accountTransactions : null;
  }
}

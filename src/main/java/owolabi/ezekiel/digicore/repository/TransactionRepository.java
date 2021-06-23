package owolabi.ezekiel.digicore.repository;

import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.entities.Transaction;

import java.util.ArrayList;

@Service
public class TransactionRepository {
  public static ArrayList<Transaction> transactions = new ArrayList<>();

  public Transaction createTransaction(Transaction transaction){
    transactions.add(transaction);
    return transaction;
  }
}

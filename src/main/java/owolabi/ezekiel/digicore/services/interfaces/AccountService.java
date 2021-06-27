package owolabi.ezekiel.digicore.services.interfaces;

import owolabi.ezekiel.digicore.models.Transaction;

import java.util.ArrayList;

public interface AccountService {
  Transaction depositToSelf(String accountNumber, double amount);
  Transaction depositToOthers(String creditAccountNumber, String debitAccountNumber, double amount);
  Transaction withdraw(String accountNumber, double amount);
  ArrayList<Transaction> getAccountStatement(String accountNumber);
}

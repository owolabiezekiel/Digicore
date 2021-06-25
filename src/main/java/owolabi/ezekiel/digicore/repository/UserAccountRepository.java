package owolabi.ezekiel.digicore.repository;

import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.dtos.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.entities.UserAccount;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAccountRepository {
  public static Map<String, UserAccount> userAccounts = new HashMap<>();

  public UserAccount saveUser(UserSignUpRequestDto signUpDetails){
    UserAccount userAccount = new UserAccount();
    userAccount.setAccountName(signUpDetails.getAccountName());
    userAccount.setAccountPassword(signUpDetails.getAccountPassword());
    userAccount.setBalance(signUpDetails.getInitialDeposit());
    userAccount.setAccountNumber("00000000" + (userAccounts.size() + 1));
    userAccounts.put(userAccount.getAccountNumber(), userAccount);
    return userAccount;
  }



  public UserAccount getUserByAccountNumber(String accountNumber){
    return userAccounts.getOrDefault(accountNumber, null);
  }




  public boolean checkAccountExists(String accountName){
    for(Map.Entry<String, UserAccount> account :
        userAccounts.entrySet()){
      if(account.getValue().getAccountName().equalsIgnoreCase(accountName)){
        return true;
      }
    }
    return false;
  }




  public boolean checkAccountNumberExists(String accountNumber){
    for(Map.Entry<String, UserAccount> account :
        userAccounts.entrySet()){
      if(account.getValue().getAccountNumber().equalsIgnoreCase(accountNumber)){
        return true;
      }
    }
    return false;
  }




  public double creditMyAccount(String accountNumber, double amount){
    UserAccount accountToCredit = userAccounts.get(accountNumber);
    accountToCredit.setBalance(accountToCredit.getBalance() + amount);
    double balance = accountToCredit.getBalance();
    userAccounts.put(accountNumber, accountToCredit);
    return balance;
  }




  public double debitAccount(String accountNumber, double amount){
    UserAccount accountToDebit = userAccounts.get(accountNumber);
    accountToDebit.setBalance(accountToDebit.getBalance() - amount);
    double balance = accountToDebit.getBalance();
    userAccounts.put(accountNumber, accountToDebit);
    return balance;
  }




  public double creditAnotherAccount(String accountNumberToCredit, String accountNumberToDebit, double amount){
    UserAccount accountToCredit = userAccounts.get(accountNumberToCredit);
    UserAccount accountToDebit = userAccounts.get(accountNumberToDebit);
    accountToCredit.setBalance(accountToCredit.getBalance() + amount);
    accountToDebit.setBalance(accountToDebit.getBalance() - amount);
    double balance = accountToDebit.getBalance();
    userAccounts.put(accountNumberToCredit, accountToCredit);
    userAccounts.put(accountNumberToDebit, accountToDebit);
    return balance;
  }



  public Map<String, UserAccount> getAllUserAccounts(){
    return userAccounts;
  }

  public int accountCount(){
    return userAccounts.size();
  }
}

package owolabi.ezekiel.digicore.repository;

import org.springframework.stereotype.Service;
import owolabi.ezekiel.digicore.dtos.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.entities.UserAccount;

import java.util.ArrayList;

@Service
public class UserAccountRepository {
  public static ArrayList<UserAccount> userAccounts = new ArrayList<>();

  public UserAccount saveUser(UserSignUpRequestDto signUpDetails){
    UserAccount userAccount = new UserAccount();
    userAccount.setAccountName(signUpDetails.getAccountName());
    userAccount.setAccountPassword(signUpDetails.getAccountPassword());
    userAccount.setBalance(signUpDetails.getInitialDeposit());
    userAccount.setAccountNumber("00000000" + (userAccounts.size() + 1));
    userAccounts.add(userAccount);
    return userAccount;
  }

  public UserAccount getUserByAccountNumber(String accountNumber){
    for(UserAccount userAccount: userAccounts){
      if(userAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
        return userAccount;
      }
    }
    return null;
  }

  public boolean checkAccountExists(String accountName){
    for(UserAccount userAccount: userAccounts){
      if(userAccount.getAccountName().equalsIgnoreCase(accountName)){
        return true;
      }
    }
    return false;
  }

  public boolean checkAccountNumberExists(String accountNumber){
    for(UserAccount userAccount: userAccounts){
      if(userAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
        return true;
      }
    }
    return false;
  }

  public ArrayList<UserAccount> getAllUserAccounts(){
    return userAccounts;
  }

  public int accountCount(){
    return userAccounts.size();
  }
}

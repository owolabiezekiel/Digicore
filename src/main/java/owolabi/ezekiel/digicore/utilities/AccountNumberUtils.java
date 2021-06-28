package owolabi.ezekiel.digicore.utilities;

public class AccountNumberUtils {
  public static String generateAccountNumber(int currentUserAccountsSize){
    String accountNumber = "";
    String accountsSizeString = currentUserAccountsSize +"";
    int accountsSizeStringLength = accountsSizeString.length();
    for(int i = 10; i > accountsSizeStringLength; i--){
      accountNumber += "0";
    }
    accountNumber += currentUserAccountsSize;
    return accountNumber;
  }
}

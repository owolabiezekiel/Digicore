package owolabi.ezekiel.digicore.services.interfaces;

import owolabi.ezekiel.digicore.dtos.request.UserSignUpRequestDto;
import owolabi.ezekiel.digicore.models.UserAccount;

public interface AuthService {
  boolean accountExists(String accountName);
  UserAccount signUp(UserSignUpRequestDto userSignUpDto);
  UserAccount login(String accountNumber, String password);
  boolean accountNumberExists(String accountNumber);
  UserAccount findByAccountNumber(String accountNumber);
}

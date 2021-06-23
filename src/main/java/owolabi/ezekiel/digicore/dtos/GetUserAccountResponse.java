package owolabi.ezekiel.digicore.dtos;

import owolabi.ezekiel.digicore.entities.UserAccount;

public class GetUserAccountResponse {
  private int responseCode;
  private boolean success;
  private String message;
  private UserAccount userAccount;

  public GetUserAccountResponse(int responseCode, boolean success, String message, UserAccount userAccount) {
    this.responseCode = responseCode;
    this.success = success;
    this.message = message;
    this.userAccount = userAccount;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(UserAccount userAccount) {
    this.userAccount = userAccount;
  }
}

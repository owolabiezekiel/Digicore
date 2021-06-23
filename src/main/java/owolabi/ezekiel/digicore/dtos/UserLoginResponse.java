package owolabi.ezekiel.digicore.dtos;

public class UserLoginResponse {
  private boolean success;
  private String accessToken;

  public UserLoginResponse(boolean success, String accessToken) {
    this.success = success;
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
}

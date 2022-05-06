import java.util.List;

public class UserDto {

  String userId;
  String userName;
  String orderId;
  String productId;
  String value;
  String date;

  public String getUserId() {
    return userId;
  }

  public void setUserId(final String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(final String userName) {
    this.userName = userName;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(final String orderId) {
    this.orderId = orderId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(final String productId) {
    this.productId = productId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public String getDate() {
    return date;
  }

  public void setDate(final String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "UserDto{" +
        "userId='" + userId + '\'' +
        ", userName='" + userName + '\'' +
        ", orderId='" + orderId + '\'' +
        ", productId='" + productId + '\'' +
        ", value='" + value + '\'' +
        ", date='" + date + '\'' +
        '}';
  }
}

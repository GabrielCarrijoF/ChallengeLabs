import java.util.List;

public class User {

  int userId;
  String userName;
  List<Order> orders;

  public int getUserId() {
    return userId;
  }

  public void setUserId(final int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(final String userName) {
    this.userName = userName;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(final List<Order> orders) {
    this.orders = orders;
  }
}

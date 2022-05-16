package entites;

import entites.Order;
import java.util.List;

public class User {

  String userId;
  String userName;
  List<Order> orders;

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

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(final List<Order> orders) {
    this.orders = orders;
  }
}

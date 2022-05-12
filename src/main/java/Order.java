import java.util.List;

public class Order {

  int userId;
  double total;
  int orderId;
  String data;
  List<Product> products;

  public Order(final int orderId, final int userId) {
    this.orderId = orderId;
    this.userId = userId;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(final int orderId) {
    this.orderId = orderId;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {

    this.total = total;
  }

  public String getData() {
    return data;
  }

  public void setData(final String data) {
    this.data = data;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(final List<Product> products) {
    this.products = products;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(final int userId) {
    this.userId = userId;
  }

}


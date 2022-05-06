import java.util.List;

public class Order {

  double total;
  int orderId;
  String data;
  List<Product> products;

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
}


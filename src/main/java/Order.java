import java.util.List;

public class Order {

  double total;
  int order_id;
  String data;
  List<Product> products;

  public int getOrder_id() {
    return order_id;
  }

  public void setOrder_id(final int order_id) {
    this.order_id = order_id;
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


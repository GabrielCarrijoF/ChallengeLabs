package entites;

import java.util.List;

public class Order {

  String orderId;
  String data;
  double total;
  List<Product> products;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(final String orderId) {
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


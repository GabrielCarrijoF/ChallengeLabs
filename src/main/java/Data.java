import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entites.Order;
import entites.Product;
import entites.Register;
import entites.User;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static java.lang.ClassLoader.getSystemResource;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.stripStart;

public class Data {

  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

  public static void main(String[] args) throws Exception {
    List<String> lines = loadFile();
    List<Register> records = lines.stream().map(Data::mapToRecord).collect(toList());

    var recordsByUserAndOrder = records.stream()
        .collect(groupingBy(Register::getUserId, groupingBy(Register::getOrderId)));

    final var result = recordsByUserAndOrder.values().stream()
            .map(Data::mapToUser)
            .collect(toList());

    String json = GSON.toJson(result);
    System.out.println(json);
  }

  private static List<String> loadFile() throws Exception {
    var path = Path.of(getSystemResource("./data.txt").toURI());
    return Files.readAllLines(path);
  }

  private static Register mapToRecord(String line) {
    var userId = line.substring(1, 10);
    var userName = line.substring(11, 55);
    var orderId = line.substring(56, 65);
    var productId = line.substring(66, 75);
    var value = line.substring(77, 87);
    var date = line.substring(87, 95);

    var record = new Register();
    record.setUserId(stripStart(userId, "0"));
    record.setUserName(userName.trim());
    record.setProductId(stripStart(productId, "0"));
    record.setOrderId(stripStart(orderId, "0"));
    record.setValue(Double.valueOf(value.trim()));
    record.setDate(LocalDate.parse(date, DATE_TIME_FORMATTER).toString());

    return record;
  }

  private static User mapToUser(Map<String, List<Register>> ordersByUser){
    var firstOrderOpt = ordersByUser.keySet().stream().findFirst();

    if (firstOrderOpt.isPresent()) {
      var items = ordersByUser.get(firstOrderOpt.get());
      var userDto = items.get(0);
      var user = new User();
      user.setUserId(userDto.getUserId());
      user.setUserName(userDto.getUserName());
      user.setOrders(ordersByUser.values().stream().map(Data::mapToOrder).collect(toList()));

      return user;
    }

    return null;
  }

  private static Order mapToOrder(List<Register> records){
    var userDto = records.get(0);

    var products = records.stream()
            .map(Data::mapToProduct)
            .collect(toList());

    var total = records.stream()
            .map(Register::getValue)
            .reduce(0.0, Double::sum);

    var order = new Order();
    order.setOrderId(userDto.getOrderId());
    order.setData(userDto.getDate());
    order.setProducts(products);
    order.setTotal(total);

    return order;
  }

  private static Product mapToProduct(Register record){
    var product = new Product();
    product.setProductId(record.getProductId());
    product.setValue(record.getValue());

    return product;
  }
}

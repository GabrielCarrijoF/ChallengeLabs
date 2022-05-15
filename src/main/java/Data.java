import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class Data {

  public static void main(String[] args) throws IOException {

    Path path = Paths.get(
        "/home/gabriel/Git/LuizaLabs/ChallengeLabs/src/main/java/filesTxt/data.txt");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    List<String> linhasArquivo = Files.readAllLines(path);
    List<UserDto> userDtos = new ArrayList<>();

    for (String linha : linhasArquivo) {

      String userId = linha.substring(1, 10);
      String userName = linha.substring(11, 55);
      String orderId = linha.substring(56, 65);
      String productId = linha.substring(66, 75);
      String value = linha.substring(77, 87);
      String date = linha.substring(87, 95);

      UserDto userDto = new UserDto();

      userDto.setUserId(StringUtils.stripStart(userId, "0"));
      userDto.setUserName(userName.trim());
      userDto.setProductId(StringUtils.stripStart(productId, "0"));
      userDto.setOrderId(StringUtils.stripStart(orderId, "0"));
      userDto.setValue(Double.valueOf(value.trim()));
      userDto.setDate(LocalDate.parse(date, formatter).toString());

      userDtos.add(userDto);
    }

    //Percorrer o mapa userMap para cada valor da lista de userDto.
    // Dentro do mapa montar uma lista de order depois dessa lista pronta agrupar as ordes em um mapa de orderId e List<order>
    // Percorrer o mapa orderMap e para cada valor da lista de order vou monstar a lista de produtos adicionar lista
    // de produtos na order e adicionar a lista de order no user

    Map<String, List<UserDto>> userMap = userDtos.stream()
        .collect(Collectors.groupingBy(UserDto::getUserId));

    Map<String, Map<String, List<UserDto>>> ordersMap = new HashMap<>();

    for (String userId : userMap.keySet()){
      var items = userMap.get(userId);
      var orders = items.stream().collect(Collectors.groupingBy(UserDto::getOrderId));
      ordersMap.put(userId, orders);
    }

    var recordsByUserAndOrder = ordersMap.values().stream().collect(Collectors.toList()).stream().map(Map::values).map(ArrayList::new).collect(Collectors.toList());

     String json = gson.toJson(map(recordsByUserAndOrder));
      System.out.println(json);
  }

  private static User map (List<List<UserDto>> userDtos){
    var userDto = userDtos.get(0).get(0);
    var user = new User(userDto.getUserId(), userDto.getUserName());
    user.setOrders(userDtos.stream().map(Data::mapToOrder).collect(Collectors.toList()));
    return user;
  }

  private static Order mapToOrder(List<UserDto> userDtos){
    var userDto = userDtos.get(0);
    var order = new Order();
    order.setOrderId(userDto.getOrderId());
    order.setUserId(userDto.getUserId());
    order.setData(userDto.getDate());
    order.setProducts(userDtos.stream().map(Data::mapToProduct).collect(Collectors.toList()));
    order.setTotal(userDtos.stream().map(UserDto :: getValue).reduce(0.0, Double::sum));
    return order;
  }

  private static Product mapToProduct(UserDto userDto){
    var product = new Product();
    product.setProductId(userDto.getProductId());
    product.setValue(userDto.getValue());

    return product;
  }
}

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
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
      userDto.setValue(value.trim());
      userDto.setDate(LocalDate.parse(date, formatter).toString());

      userDtos.add(userDto);
    }
    //   Chave       Valor
    Map<String, List<UserDto>> userMap =
        userDtos.stream().collect(Collectors.groupingBy(UserDto::getUserId));

    

    String json = gson.toJson(userMap);

    System.out.println(json);
  }
}

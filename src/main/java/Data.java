import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Data {

  public static void main(String[] args) throws IOException {

    Path path = Paths.get(
        "/home/gabriel/Git/LuizaLabs/ChallengeLabs/src/main/java/filesTxt/data.txt");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    List<String> linhasArquivo = Files.readAllLines(path);
    for (String linha : linhasArquivo) {

      String userId = linha.substring(1, 10);
      String userName = linha.substring(11, 55);
      String orderId = linha.substring(56, 65);
      String productId = linha.substring(66, 76);
      String value = linha.substring(77, 87);
      String date = linha.substring(87, 95);

      System.out.println(userId);
      System.out.println(userName.trim());
      System.out.println(orderId);
      System.out.println(productId);
      System.out.println(value);
      System.out.println(LocalDate.parse(date, formatter).toString());
    }
  }
}

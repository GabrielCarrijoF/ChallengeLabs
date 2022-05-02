package filesTxt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TesteData {

  public static void main(String[] args) throws IOException {

     Files.lines(
        Paths.get("/home/gabriel/Git/LuizaLabs/ChallengeLabs/src/main/java/filesTxt/data.txt"))
     .forEach(System.out::println);
  }
}

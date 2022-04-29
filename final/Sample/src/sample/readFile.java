package sample;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class readFile {
  

  public void readContents(String text) throws IOException {
    String content = Files.readString(Paths.get(text));
    System.out.println(content); 
  }
    
}

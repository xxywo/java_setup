package sample;

import org.junit.jupiter.api.Test;

public class readFileTest {
  readFile file = new readFile(); 

  @Test
  public void readfiletest() throws Exception{
    file.readContents("input.txt");

  }
    
}

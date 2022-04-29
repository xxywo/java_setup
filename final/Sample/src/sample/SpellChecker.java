package sample;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import java.io.BufferedReader;
import java.io.IOException;


public class SpellChecker implements WebService {
  public String getResponse(String target){
    var urlOfSpellChecker = "http://agilec.cs.uh.edu/spell?check=" + target;
    String resultOfSpellChecker = "";

    try {
      URL url = new URL(urlOfSpellChecker);

      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      resultOfSpellChecker = in.readLine();

      in.close();
    } catch(IOException e) {
      writeToLog("bal"); 
      //throw new RuntimeException("Network error", e);
      System.err.println( "JOrtho configuration file not found!" );
      e.printStackTrace();
    }

    return resultOfSpellChecker;
      
  }

  public Boolean parse(String yesOrNo) {
    return Objects.equals(yesOrNo, "true");
  }

  public Boolean isSpellingCorrect(String word){ 
    
    var responseFromURL = getResponse(word); 

    return parse(responseFromURL);
  }

  public String writeToLog(String word){
    //System.out.println("hello"); 
    return word; 
  }
}

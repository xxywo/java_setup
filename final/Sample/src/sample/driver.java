package sample;
import java.io.IOException;

import javax.management.RuntimeErrorException;



public class driver {
    public static void main(String[] args){
        readFile file = new readFile(); 
        try{
            file.readContents("input.txt");
        }
        catch(IOException e){
            throw new RuntimeException("can't open file", e);
        }
       
    }
  
    
}

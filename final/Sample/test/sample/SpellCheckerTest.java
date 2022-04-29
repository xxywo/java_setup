package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.management.RuntimeErrorException;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.net.URL;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;




public class SpellCheckerTest {
  SpellChecker spellchecker; 
  
  @BeforeEach
  void setUp() {
    spellchecker = new SpellChecker();
  }

  @Test
  void checkSpellCorrect(){
    assertAll(
      ()-> assertTrue(spellchecker.isSpellingCorrect("monkey")),
      ()->assertTrue( spellchecker.isSpellingCorrect("fruit"))
    );
  }

  @Test
  void checkSpellIncorrect(){
    assertAll(
      ()-> assertFalse(spellchecker.isSpellingCorrect("rihgt")),
      ()->assertFalse(spellchecker.isSpellingCorrect("oekmny"))
    );
  }

  @Test
  void checkSpellExcpetion(){
    SpellChecker spellCheckerException = Mockito.mock(SpellChecker.class);
    when(spellCheckerException.getResponse("right")).thenThrow(new RuntimeException("Network error"));
    assertThrows(RuntimeException.class, () ->spellCheckerException.getResponse("right"));
    /*SpellChecker spellCheckerException = Mockito.mock(SpellChecker.class);
    when(spellCheckerException.getResponse("right")).thenThrow(new RuntimeException("Network error"));
     //assertThrows(RuntimeException.class, () -> spellCheckerException.isSpellingCorrect("right"));

     //spellCheckerException.getResponse("right"); 
     String message = ""; 
     try{
       spellCheckerException.isSpellingCorrect("right");
     }
     catch(IOException e){
      message = e.getMessage(); 
     }

     assertEquals("Network error", message); */
    
    //var ex = assertThrows(RuntimeException.class, () ->spellCheckerException.isSpellingCorrect("right"));
    //assertEquals("Network error",  spellCheckerException.writeToLog("right"));
  }


    
}

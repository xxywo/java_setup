package sample;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SampleTest {
  @Test
  void Canary() {
    assertTrue(true);
  }

  Sample sample;

  @BeforeEach
  void setUp() {
     sample = new Sample();
  }

  @Test
  void verifySampleWork(){
    assertTrue(sample.test());
  }
}

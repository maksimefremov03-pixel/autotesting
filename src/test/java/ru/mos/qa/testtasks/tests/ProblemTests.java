package ru.mos.qa.testtasks.tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProblemTests {

  private final StringBuilder CONST = new StringBuilder("const");
  private final static String bd = "pui";

  @Test
  public void equalsOneToOne(){
    assertEquals("1", "1");
  }


  @Test
  public void assignValueToConstVar(){
    CONST.setLength(0);
    CONST.append("newValue");
    assertEquals("newValue", CONST.toString());
  }

  @Test
  public void equalsOneToOneDigit(){
    assertEquals(1, 1);
  }



  @Test
  public void stringsMustBeEqual(){
    String res = "a";

    if (bd.equals(new String("pui"))) {
      res = "asd";
    }

    assertEquals("asd", res);
  }

  @Test
  public void successfullyRemovingFirstElementFromList(){
    List<String> sourceData = new ArrayList<>(List.of("1", "viskas", "chupocabra"));
    if (!sourceData.isEmpty()){
      sourceData.remove(0);
    }
    assertFalse(sourceData.contains("1"));
  }


}
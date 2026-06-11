package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class FileTests {

  private final static String str = "Упорство";

  @Test
  public void testfile(){
    boolean flag = false;
    try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/TraineeCharacteristics.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.equals(str)) {
          flag = true;
          break;
        }
      }
    } 
    catch (IOException e) {
      fail("Файл не найден");
    }
  assertTrue(flag);
  }
  
}
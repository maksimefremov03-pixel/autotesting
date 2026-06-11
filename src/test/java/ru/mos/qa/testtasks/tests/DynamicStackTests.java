package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.DynamicStack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicStackTests {

  @Test
  public void negativeArraySizeCheck() {
    assertThrows(NegativeArraySizeException.class, () -> new DynamicStack(-1));
  }

  @Test
  public void notOutOfBoundsCheck() {
    DynamicStack stack = new DynamicStack(0);
    stack.addElement(1);
    assertEquals(1, stack.readTop());
  }

  @Test
  public void readTopFromEmptyCheck() {
    DynamicStack stack = new DynamicStack(1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.readTop());
  }

  @Test
  public void deleteFromEmptyCheck() {
    DynamicStack stack = new DynamicStack(1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.deleteElement());
  }

  @Test
  public void isEmptyCheck1() {
    DynamicStack stack = new DynamicStack(0);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void addCheck() {
    DynamicStack stack = new DynamicStack(2);
    stack.addElement(1);
    assertEquals(1, stack.readTop());
  }

  @Test
  public void dinamicAddCheck() {
    DynamicStack stack = new DynamicStack(2);
    stack.addElement(1);
    stack.addElement(2);
    stack.addElement(3);
    assertEquals(3, stack.readTop());
  }

  @Test
  public void deleteCheck() {
    DynamicStack stack = new DynamicStack(3);
    stack.addElement(1);
    stack.addElement(2);
    assertEquals(2, stack.deleteElement());
    assertEquals(1, stack.deleteElement());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void dinamicDeleteCheck() {
    DynamicStack stack = new DynamicStack(4);
    stack.addElement(1);
    stack.addElement(2);
    stack.deleteElement();
    stack.addElement(3);
    assertTrue(stack.isFull());
  }

  @Test
  public void isEmptyCheck2() {
    DynamicStack stack = new DynamicStack(1);
    stack.addElement(1);
    stack.deleteElement();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void isFullCheck() {
    DynamicStack stack = new DynamicStack(2);
    stack.addElement(5);
    stack.addElement(11);
    assertTrue(stack.isFull());
  }
}
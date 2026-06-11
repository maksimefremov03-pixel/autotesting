package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTests {

  @Test
  public void negativeArraySizeCheck() {
    assertThrows(NegativeArraySizeException.class, () -> new Stack(-1));
  }

  @Test
  public void outOfBoundsCheck1() {
    Stack stack = new Stack(0);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.addElement(1));
  }

  @Test
  public void outOfBoundsCheck2() {
    Stack stack = new Stack(1);
    stack.addElement(10);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.addElement(1));
  }

  @Test
  public void readTopFromEmptyCheck() {
    Stack stack = new Stack(1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.readTop());
  }

  @Test
  public void deleteFromEmptyCheck() {
    Stack stack = new Stack(1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.deleteElement());
  }

  @Test
  public void isEmptyCheck1() {
    Stack stack = new Stack(0);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void addCheck() {
    Stack stack = new Stack(2);
    stack.addElement(1);
    assertEquals(1, stack.readTop());
  }

  @Test
  public void deleteCheck() {
    Stack stack = new Stack(3);
    stack.addElement(1);
    stack.addElement(2);
    assertEquals(2, stack.deleteElement());
    assertEquals(1, stack.deleteElement());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void isEmptyCheck2() {
    Stack stack = new Stack(1);
    stack.addElement(1);
    stack.deleteElement();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void isFullCheck() {
    Stack stack = new Stack(2);
    stack.addElement(5);
    stack.addElement(11);
    assertTrue(stack.isFull());
  }
}
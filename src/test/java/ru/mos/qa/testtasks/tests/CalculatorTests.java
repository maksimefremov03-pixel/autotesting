package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {
  private final Calculator calculator = new Calculator();

  @Test
  public void sumCheck() {
    assertEquals(5, calculator.sum(2, 3));
    assertEquals(1, calculator.sum(-2, 3));
    assertEquals(-1, calculator.sum(2, -3));
    assertEquals(-5, calculator.sum(-2, -3));
    assertEquals(2, calculator.sum(0, 2));
    assertEquals(2, calculator.sum(2, 0));
    assertEquals(0, calculator.sum(5, -5));
    assertEquals(Integer.MAX_VALUE, calculator.sum(Integer.MAX_VALUE, 0));
    assertEquals(Integer.MIN_VALUE, calculator.sum(Integer.MIN_VALUE, 0));
    assertEquals(Integer.MIN_VALUE, calculator.sum(Integer.MAX_VALUE, 1));
  }

  @Test
  public void minusCheck() {
    assertEquals(-1, calculator.minus(2, 3));
    assertEquals(-5, calculator.minus(-2, 3));
    assertEquals(5, calculator.minus(2, -3));
    assertEquals(1, calculator.minus(-2, -3));
    assertEquals(-2, calculator.minus(0, 2));
    assertEquals(2, calculator.minus(2, 0));
    assertEquals(0, calculator.minus(5, 5));
    assertEquals(Integer.MAX_VALUE, calculator.minus(Integer.MAX_VALUE, 0));
    assertEquals(Integer.MIN_VALUE, calculator.minus(Integer.MIN_VALUE, 0));
    assertEquals(Integer.MAX_VALUE, calculator.minus(Integer.MIN_VALUE, 1));
  }

  @Test
  public void multiplyCheck() {
    assertEquals(6, calculator.multiply(2, 3));
    assertEquals(-6, calculator.multiply(-2, 3));
    assertEquals(-6, calculator.multiply(2, -3));
    assertEquals(6, calculator.multiply(-2, -3));
    assertEquals(0, calculator.multiply(0, 2));
    assertEquals(0, calculator.multiply(2, 0));
    assertEquals(Integer.MAX_VALUE, calculator.multiply(Integer.MAX_VALUE, 1));
    assertEquals(Integer.MIN_VALUE, calculator.multiply(Integer.MIN_VALUE, 1));
    assertEquals(1, calculator.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(0, calculator.multiply(Integer.MIN_VALUE, Integer.MIN_VALUE));
  }

  @Test
  public void divideCheck() {
    assertEquals(3, calculator.divide(6, 2));
    assertEquals(-3, calculator.divide(-6, 2));
    assertEquals(-3, calculator.divide(6, -2));
    assertEquals(3, calculator.divide(-6, -2));
    assertEquals(0, calculator.divide(0, 2));
    assertThrows(ArithmeticException.class, () -> calculator.divide(2, 0));
    assertEquals(0, calculator.divide(1, 2));
    assertEquals(Integer.MAX_VALUE, calculator.divide(Integer.MAX_VALUE, 1));
    assertEquals(Integer.MIN_VALUE, calculator.divide(Integer.MIN_VALUE, 1));
    assertEquals(1, calculator.divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(1, calculator.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
  }
}
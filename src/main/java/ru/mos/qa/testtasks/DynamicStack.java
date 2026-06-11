package ru.mos.qa.testtasks;

public class DynamicStack {
  private int mSize;
  private int[] stackArray;
  private int top;

  public DynamicStack(int m) {
    this.mSize = m;
    stackArray = new int[mSize];
    top = -1;
  }

  public void addElement(int element) {
    if (isFull()) {
      int newSize = mSize + 1;
      int tempArray[] = new int[newSize];

      for (int i = 0; i < mSize; i++) {
        tempArray[i] = stackArray[i];
      }

      stackArray = tempArray;
      mSize = newSize;
    }
    stackArray[++top] = element;
  }

  public int deleteElement() {
    if (top != 0 && mSize / 2 > top) {
      int newSize = mSize / 2;
      int tempArray[] = new int[newSize];

      for (int i = 0; i < newSize; i++) {
        tempArray[i] = stackArray[i];
      }

      stackArray = tempArray;
      mSize = newSize;
    }
    return stackArray[top--];
  }

  public int readTop() {
    return stackArray[top];

  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == mSize - 1);
  }
}

package me.dolia.ads.stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ArrayStackTest {

  private ArrayStack<Integer> arrayStack;

  @BeforeEach
  void setUp() {
    arrayStack = new ArrayStack<>();
  }

  @Test
  void shouldPushTheItem() {
    int item = 5;

    arrayStack.push(item);
    boolean empty = arrayStack.isEmpty();
    int size = arrayStack.size();

    assertThat(empty, is(false));
    assertThat(size, is(1));
  }


  @Test
  void shouldPopTheLastItem() {
    int firstItem = 5;
    int secondItem = 17;
    arrayStack.push(firstItem);
    arrayStack.push(secondItem);

    int result = arrayStack.pop();

    assertThat(result, is(secondItem));
  }

  @Test
  void shouldThrowExceptionOnPopEmptyStack() {
    Executable pop = () -> arrayStack.pop();

    assertThrows(NoSuchElementException.class, pop);
  }

  @Test
  void shouldReturnTrueWhenStackIsEmpty() {
    boolean empty = arrayStack.isEmpty();

    assertThat(empty, is(true));
  }

  @Test
  void shouldReturnFalseWhenStackIsNotEmpty() {
    arrayStack.push(1);

    boolean empty = arrayStack.isEmpty();

    assertThat(empty, is(false));
  }

  @Test
  void shouldBeOfSizeZeroOnCreation() {
    int size = arrayStack.size();

    assertThat(size, is(0));
  }

  @Test
  void shouldReturnCorrectSizeOfStack() {
    arrayStack.push(5);
    arrayStack.push(6);

    int size = arrayStack.size();

    assertThat(size, is(2));
  }

  @Test
  void shouldIterateOverAllElements() {
    int[] elements = {1, 2, 3, 4, 5};
    for (int e : elements) {
      arrayStack.push(e);
    }

    int i = elements.length - 1;
    int[] result = new int[elements.length];
    for (int e : arrayStack) {
      result[i--] = e;
    }

    assertThat(result, equalTo(elements));
  }
}
package me.dolia.ads.stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class LinkedStackTest {

  private LinkedStack<Integer> linkedStack;

  @BeforeEach
  void setUp() {
    linkedStack = new LinkedStack<>();
  }

  @Test
  void shouldPushTheItem() {
    int item = 523;

    linkedStack.push(item);
    boolean empty = linkedStack.isEmpty();
    int size = linkedStack.size();

    assertThat(empty, is(false));
    assertThat(size, is(1));
  }


  @Test
  void shouldPopTheLastItem() {
    int firstItem = 123;
    int secondItem = 17;
    linkedStack.push(firstItem);
    linkedStack.push(secondItem);

    int result = linkedStack.pop();

    assertThat(result, is(secondItem));
  }

  @Test
  void shouldThrowExceptionOnPopEmptyStack() {
    Executable pop = () -> linkedStack.pop();

    assertThrows(NoSuchElementException.class, pop);
  }

  @Test
  void shouldReturnTrueWhenStackIsEmpty() {
    boolean empty = linkedStack.isEmpty();

    assertThat(empty, is(true));
  }

  @Test
  void shouldReturnFalseWhenStackIsNotEmpty() {
    linkedStack.push(1);

    boolean empty = linkedStack.isEmpty();

    assertThat(empty, is(false));
  }

  @Test
  void shouldBeOfSizeZeroOnCreation() {
    int size = linkedStack.size();

    assertThat(size, is(0));
  }

  @Test
  void shouldReturnCorrectSizeOfStack() {
    linkedStack.push(5);
    linkedStack.push(6);

    int size = linkedStack.size();

    assertThat(size, is(2));
  }

  @Test
  void shouldIterateOverAllElements() {
    int[] elements = {6, 7, 8, 9, 10};
    for (int e : elements) {
      linkedStack.push(e);
    }

    int i = elements.length - 1;
    int[] result = new int[elements.length];
    for (int e : linkedStack) {
      result[i--] = e;
    }

    assertThat(result, equalTo(elements));
  }
}
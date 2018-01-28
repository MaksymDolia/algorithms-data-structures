package me.dolia.ads.queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class LinkedQueueTest {

  private LinkedQueue<Integer> linkedQueue;

  @BeforeEach
  void setUp() {
    linkedQueue = new LinkedQueue<>();
  }

  @Test
  void shouldEnqueueTheItem() {
    int item = 523;

    linkedQueue.enqueue(item);
    boolean empty = linkedQueue.isEmpty();
    int size = linkedQueue.size();

    assertThat(empty, is(false));
    assertThat(size, is(1));
  }


  @Test
  void shouldDequeueTheFirstItem() {
    int firstItem = 123;
    int secondItem = 17;
    linkedQueue.enqueue(firstItem);
    linkedQueue.enqueue(secondItem);

    int result = linkedQueue.dequeue();

    assertThat(result, is(firstItem));
  }

  @Test
  void shouldThrowExceptionOnDequeueEmptyQueue() {
    Executable dequeue = () -> linkedQueue.dequeue();

    assertThrows(NoSuchElementException.class, dequeue);
  }

  @Test
  void shouldReturnTrueWhenQueueIsEmpty() {
    boolean empty = linkedQueue.isEmpty();

    assertThat(empty, is(true));
  }

  @Test
  void shouldReturnFalseWhenQueueIsNotEmpty() {
    linkedQueue.enqueue(1);

    boolean empty = linkedQueue.isEmpty();

    assertThat(empty, is(false));
  }

  @Test
  void shouldBeOfSizeZeroOnCreation() {
    int size = linkedQueue.size();

    assertThat(size, is(0));
  }

  @Test
  void shouldReturnCorrectSizeOfQueue() {
    linkedQueue.enqueue(5);
    linkedQueue.enqueue(6);

    int size = linkedQueue.size();

    assertThat(size, is(2));
  }

  @Test
  void shouldIterateOverAllElements() {
    int[] elements = {6, 7, 8, 9, 10};
    for (int e : elements) {
      linkedQueue.enqueue(e);
    }

    int i = 0;
    int[] result = new int[elements.length];
    for (int e : linkedQueue) {
      result[i++] = e;
    }

    assertThat(result, equalTo(elements));
  }
}
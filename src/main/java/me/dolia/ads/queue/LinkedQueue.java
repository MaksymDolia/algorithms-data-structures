package me.dolia.ads.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

  /**
   * The first node of the queue.
   */
  private Node first;

  /**
   * The last node of the queue.
   */
  private Node last;

  /**
   * The number of elements stored in the queue.
   */
  private int n;

  @Override
  public void enqueue(T item) {
    Node node = new Node();
    node.item = item;
    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      last.next = node;
      last = node;
    }
    n++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    T item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    n--;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public int size() {
    return n;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedQueueIterator();
  }

  private class Node {

    T item;
    Node next;
  }

  private class LinkedQueueIterator implements Iterator<T> {

    private Node cursor = first;

    @Override
    public boolean hasNext() {
      return cursor != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      T item = cursor.item;
      cursor = cursor.next;
      return item;
    }
  }
}

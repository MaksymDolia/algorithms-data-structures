package me.dolia.ads.stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {

  /**
   * Link to the first node in stack
   */
  private Node first;

  /**
   * The number of stored elements
   */
  private int n;

  @Override
  public void push(T item) {
    Node node = new Node();
    node.item = item;
    node.next = first;
    first = node;
    n++;
  }

  @Override
  public T pop() {
    if (isNull(first)) {
      throw new NoSuchElementException("Stack is empty");
    }
    T item = first.item;
    first = first.next;
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
    return new LinkedStackIterator();
  }

  private class Node {

    T item;
    Node next;
  }

  private class LinkedStackIterator implements Iterator<T> {

    private Node cursor = first;

    @Override
    public boolean hasNext() {
      return nonNull(cursor);
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

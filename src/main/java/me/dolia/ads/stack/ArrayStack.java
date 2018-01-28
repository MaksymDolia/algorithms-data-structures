package me.dolia.ads.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

  private static final int DEFAULT_CAPACITY = 16;

  /**
   * Keeps the elements stored in stack.
   */
  private T[] elements;

  /**
   * The number of stored elements
   */
  private int n;

  @SuppressWarnings("unchecked")
  ArrayStack() {
    this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    this.n = 0;
  }

  @Override
  public void push(T item) {
    ensureCapacity();
    elements[n++] = item;
  }

  private void ensureCapacity() {
    if (n == elements.length) {
      resize(n * 2);
    }
  }

  @SuppressWarnings("unchecked")
  private void resize(int newCapacity) {
    T[] extendedElements = (T[]) new Object[newCapacity];
    System.arraycopy(elements, 0, extendedElements, 0, n);
    elements = extendedElements;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    shrink();
    T item = elements[n - 1];
    elements[n - 1] = null;
    n--;
    return item;
  }

  private void shrink() {
    if (n > DEFAULT_CAPACITY && n == elements.length / 4) {
      resize(n / 2);
    }
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return n;
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayStackIterator();
  }

  private class ArrayStackIterator implements Iterator<T> {

    private int cursor = n - 1;

    @Override
    public boolean hasNext() {
      return cursor >= 0;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return elements[cursor--];
    }
  }
}

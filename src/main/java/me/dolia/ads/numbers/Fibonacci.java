package me.dolia.ads.numbers;

import java.util.Arrays;

/**
 * Resolves the Fibonacci numbers in several ways.
 */
public class Fibonacci {

  /**
   * Simple recursive solution for Fibonacci numbers
   *
   * @param n the consecutive index
   * @return the n-th Fibonacci number
   */
  public int find(int n) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    return find(n - 1) + find(n - 2);
  }

  public int findWithMemoization(int n) {
    int[] cache = new int[n];
    Arrays.fill(cache, -1);
    return findWithMemoization(n, cache);
  }

  private int findWithMemoization(int n, int[] cache) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    cache[n - 1] = findWithMemoization(n - 1, cache) + findWithMemoization(n - 2, cache);

    return cache[n - 1];
  }
}

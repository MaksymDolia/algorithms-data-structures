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
  public int findRecursively(int n) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    return findRecursively(n - 1) + findRecursively(n - 2);
  }

  /**
   * Recursive solution with memoization for Fibonacci numbers
   *
   * @param n the consecutive index
   * @return the n-th Fibonacci number
   */
  public int findRecursivelyWithMemoization(int n) {
    int[] cache = new int[n];
    Arrays.fill(cache, -1);
    return findRecursivelyWithMemoization(n, cache);
  }

  private int findRecursivelyWithMemoization(int n, int[] cache) {
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    cache[n - 1] =
        findRecursivelyWithMemoization(n - 1, cache) + findRecursivelyWithMemoization(n - 2, cache);

    return cache[n - 1];
  }
}

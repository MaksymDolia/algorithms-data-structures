package me.dolia.ads.numbers;

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
}

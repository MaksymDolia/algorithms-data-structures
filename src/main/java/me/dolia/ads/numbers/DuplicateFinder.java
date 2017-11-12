package me.dolia.ads.numbers;

import static java.util.Arrays.binarySearch;
import static java.util.Objects.requireNonNull;

public class DuplicateFinder {

  /**
   * Counts the occurrences of target number in given sorted array. Due to use of Binary Search, the
   * result will be unpredictable in case the given array is not yet sorted.
   *
   * Complexity: O(logN), S(1)
   *
   * @param arr sorted array
   * @param k target number
   * @return number of occurrences
   */
  public int countOccurrencesSorted(int[] arr, int k) {
    requireNonNull(arr, "Array is null");
    int first = getFirst(arr, k);
    if (first < 0 || first >= arr.length) {
      return 0;
    }
    int last = getLast(arr, k);
    return (last - first) + 1;
  }

  private int getFirst(int[] arr, int k) {
    int tmp;
    int first = arr.length;
    while ((tmp = binarySearch(arr, 0, first, k)) > -1) {
      first = tmp;
    }
    return first;
  }

  private int getLast(int[] arr, int k) {
    int tmp;
    int last = -1;
    while ((tmp = binarySearch(arr, last + 1, arr.length, k)) > -1) {
      last = tmp;
    }
    return last;
  }
}

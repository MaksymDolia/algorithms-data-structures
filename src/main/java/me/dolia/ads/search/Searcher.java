package me.dolia.ads.search;

/**
 * Performs the search of number in array of integers.
 */
public class Searcher {

  /**
   * Implementation of binary search algorithm.
   *
   * @return the function to perform binary search
   * @see <a href="https://en.wikipedia.org/wiki/Binary_search_algorithm">Binary search
   * algorithm</a>
   */
  public Search binarySearch() {
    return (arr, key) -> {
      int low = 0;
      int high = arr.length - 1;

      while (low <= high) {
        int mid = (low + high) / 2;
        int midVal = arr[mid];

        if (midVal < key) {
          low = mid + 1;
        } else if (midVal > key) {
          high = mid - 1;
        } else {
          return mid;
        }
      }

      return -1;
    };
  }
}

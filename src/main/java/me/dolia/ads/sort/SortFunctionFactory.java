package me.dolia.ads.sort;

public class SortFunctionFactory {

  /**
   * Implementation of Insertion sort.
   *
   * @return the function which performs the Insertion sort
   * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion sort</a>
   */
  Sort insertionSort() {
    return numbers -> {
      for (int i = 1; i < numbers.length; i++) {
        int key = numbers[i];
        int j = i - 1;
        while (j >= 0 && numbers[j] > key) {
          numbers[j + 1] = numbers[j];
          j--;
        }
        numbers[j + 1] = key;
      }
    };
  }
}

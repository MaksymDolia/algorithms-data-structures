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

  /**
   * Implementation of Merge sort.
   *
   * @return the function which performs the Merge sort
   * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge sort</a>
   */
  Sort mergeSort() {
    return numbers -> mergeSort(numbers, 0, numbers.length - 1);
  }

  private void mergeSort(int[] array, int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(array, p, q);
      mergeSort(array, q + 1, r);
      merge(array, p, q, r);
    }
  }

  private void merge(int[] array, int p, int q, int r) {
    int[] left = new int[q - p + 1];
    System.arraycopy(array, p, left, 0, q - p + 1);
    int[] right = new int[r - q];
    System.arraycopy(array, q + 1, right, 0, r - q);

    int l = 0;
    int h = 0;
    int i = p;
    while (l < left.length && h < right.length) {
      if (left[l] < right[h]) {
        array[i] = left[l];
        l++;
      } else {
        array[i] = right[h];
        h++;
      }

      i++;
    }

    while (l < left.length) {
      array[i] = left[l];
      l++;
      i++;
    }
  }
}

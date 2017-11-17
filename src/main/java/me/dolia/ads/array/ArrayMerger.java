package me.dolia.ads.array;

public class ArrayMerger {

  /**
   * Merging elements of two different arrays alternatively in third array
   *
   * @param first the first array to merge
   * @param second the second array to merge
   * @return the merged array with alternatively located integers
   * @throws NullPointerException if one or both of the given arrays is null
   */
  public int[] mergeAlternatively(int[] first, int[] second) {
    int[] merged = new int[first.length + second.length];
    int firstCur = 0;
    int secondCur = 0;
    for (int i = 0; i < merged.length; i++) {
      if (i % 2 == 0) {
        merged[i] = firstCur < first.length ? first[firstCur++] : second[secondCur++];
      } else {
        merged[i] = secondCur < second.length ? second[secondCur++] : first[firstCur++];
      }
    }
    return merged;
  }
}

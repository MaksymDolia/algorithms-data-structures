package me.dolia.ads.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SortFunctionFactoryTest {

  private static final int[][] UNORDERED_NUMBERS = new int[][]{
      {1, 3, 5, 7, 9, 2, 4, 6, 0},
      {9, 7, 8, 5, 0, 2, 1, 3, 5},
      {-1, -5, 8, 0, 9, -3, 4, 7, -7},
      {},
      {-9},
      {5, -5}
  };

  private static final int[][] ORDERED_NUMBERS = new int[][]{
      {0, 1, 2, 3, 4, 5, 6, 7, 9},
      {0, 1, 2, 3, 5, 5, 7, 8, 9},
      {-7, -5, -3, -1, 0, 4, 7, 8, 9},
      {},
      {-9},
      {-5, 5}
  };

  private SortFunctionFactory sortFactory;

  @BeforeEach
  void setUp() {
    this.sortFactory = new SortFunctionFactory();
  }

  @TestFactory
  Stream<DynamicTest> testBubbleSort() {
    int testsQuantity = UNORDERED_NUMBERS.length;
    Sort bubbleSort = sortFactory.bubbleSort();
    return IntStream.range(0, testsQuantity)
        .mapToObj(i -> dynamicTest("Bubble sort: " + i, () -> {
              int[] unordered = UNORDERED_NUMBERS[i].clone();
              bubbleSort.accept(unordered);
              assertArrayEquals(ORDERED_NUMBERS[i], unordered);
            })
        );
  }

  @TestFactory
  Stream<DynamicTest> testInsertionSort() {
    int testsQuantity = UNORDERED_NUMBERS.length;
    Sort insertionSort = sortFactory.insertionSort();
    return IntStream.range(0, testsQuantity)
        .mapToObj(i -> dynamicTest("Insertion sort: " + i, () -> {
              int[] unordered = UNORDERED_NUMBERS[i].clone();
              insertionSort.accept(unordered);
              assertArrayEquals(ORDERED_NUMBERS[i], unordered);
            })
        );
  }

  @TestFactory
  Stream<DynamicTest> testMergeSort() {
    int testsQuantity = UNORDERED_NUMBERS.length;
    Sort mergeSort = sortFactory.mergeSort();
    return IntStream.range(0, testsQuantity)
        .mapToObj(i -> dynamicTest("Merge sort: " + i, () -> {
              int[] unordered = UNORDERED_NUMBERS[i].clone();
              mergeSort.accept(unordered);
              assertArrayEquals(ORDERED_NUMBERS[i], unordered);
            })
        );
  }
}

package me.dolia.ads.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SearcherTest {

  private static final int[][] SORTED_ARRAYS = {
      {0, 2, 10, 15, 21, 32, 32, 40, 41, 55, 55, 67, 67, 74, 77, 79, 80, 87, 91, 96},
      {2, 2, 6, 7, 13, 16, 21, 23, 24, 24, 25, 37, 45, 49, 50, 51, 62, 78, 83, 84},
      {6, 14, 16, 22, 27, 32, 32, 35, 37, 75, 79, 82, 86, 87, 91, 92, 92, 93, 96, 98}
  };

  private Searcher searcher;

  @BeforeEach
  void setUp() {
    searcher = new Searcher();
  }

  @TestFactory
  Stream<DynamicTest> testBinarySearch() {
    int[] keys = {87, 51, 33};
    int[] indexes = {17, 15, -1};
    return IntStream.range(0, SORTED_ARRAYS.length)
        .mapToObj(i -> DynamicTest.dynamicTest("Binary Search: " + i, () -> {
          final Integer result = searcher.binarySearch().applyAsInt(SORTED_ARRAYS[i], keys[i]);
          assertEquals(indexes[i], result.intValue());
        }));
  }
}

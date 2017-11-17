package me.dolia.ads.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayMergerTest {

  private ArrayMerger merger;

  @BeforeEach
  void setUp() {
    this.merger = new ArrayMerger();
  }

  @Test
  void shouldMergeAlternativelyEqualLengthArrays() {
    int[] first = {1, 2, 3, 4};
    int[] second = {5, 6, 7, 8};
    int[] expected = {1, 5, 2, 6, 3, 7, 4, 8};

    int[] result = merger.mergeAlternatively(first, second);

    assertArrayEquals(expected, result);
  }

  @Test
  void shouldMergeAlternativelyArraysWithNonEqualLength() {
    int[] first = {1, 2, 3, 4};
    int[] second = {5, 6, 7, 8, 9};
    int[] expected = {1, 5, 2, 6, 3, 7, 4, 8, 9};

    int[] result = merger.mergeAlternatively(first, second);

    assertArrayEquals(expected, result);
  }

  @Test
  void shouldMergeAlternativelyArraysWhenFirstArrayIsEmpty() {
    int[] first = {};
    int[] second = {5, 6, 7, 8, 9};

    int[] result = merger.mergeAlternatively(first, second);

    assertArrayEquals(second, result);
  }

  @Test
  void shouldMergeAlternativelyArraysWhenSecondArrayIsEmpty() {
    int[] first = {1, 2, 3, 4};
    int[] second = {};

    int[] result = merger.mergeAlternatively(first, second);

    assertArrayEquals(first, result);
  }

  @Test
  void shouldThrowExceptionOnMergeAlternativelyWhenOneOfArraysIsNull() {
    assertThrows(NullPointerException.class, () -> merger.mergeAlternatively(null, null));
  }
}

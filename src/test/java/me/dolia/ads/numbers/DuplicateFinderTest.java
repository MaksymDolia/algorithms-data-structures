package me.dolia.ads.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DuplicateFinderTest {

  private DuplicateFinder duplicateFinder;

  @BeforeEach
  void setUp() {
    duplicateFinder = new DuplicateFinder();
  }

  @Test
  void shouldCountOccurrencesSortedIfPresent() {
    int[] arr = {0, 1, 2, 3, 5, 5, 7, 8, 9};
    int k = 5;
    int expected = 2;

    int result = duplicateFinder.countOccurrencesSorted(arr, k);

    assertEquals(expected, result, "Wrong number of number occurrences in array");
  }

  @Test
  void shouldCountOccurrencesSortedIfNotPresent() {
    int[] arr = {0, 1, 2, 3, 5, 5, 7, 8, 9};
    int k = 4;
    int expected = 0;

    int result = duplicateFinder.countOccurrencesSorted(arr, k);

    assertEquals(expected, result, "Wrong number of number occurrences in array");
  }

  @Test
  void shouldCountOccurrencesSortedFirstElement() {
    int[] arr = {0, 1, 2, 3, 5, 5, 7, 8, 9};
    int k = 0;
    int expected = 1;

    int result = duplicateFinder.countOccurrencesSorted(arr, k);

    assertEquals(expected, result, "Wrong number of number occurrences in array");
  }

  @Test
  void shouldCountOccurrencesSortedLastElement() {
    int[] arr = {0, 1, 2, 3, 5, 5, 7, 8, 9};
    int k = 9;
    int expected = 1;

    int result = duplicateFinder.countOccurrencesSorted(arr, k);

    assertEquals(expected, result, "Wrong number of number occurrences in array");
  }

  @Test
  @DisplayName("Test countOccurrencesSorted() - should throw NPE if array is null")
  void shouldTrowExceptionOnCountOccurrencesSortedIfArrayIsNull() {
    int[] arr = null;
    int k = 5;

    Executable countOccurrencesSorted = () -> duplicateFinder.countOccurrencesSorted(arr, k);

    assertThrows(NullPointerException.class, countOccurrencesSorted, "Array is null");
  }

  @Test
  void shouldCountOccurrencesSortedOfArrayWithSingleFilledValue() {
    int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int k = 1;
    int expected = 14;

    int result = duplicateFinder.countOccurrencesSorted(arr, k);

    assertEquals(expected, result, "Wrong number of number occurrences in array");
  }
}

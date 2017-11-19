package me.dolia.ads.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class FibonacciTest {

  private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
  private int[] fibonacciNumbers = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};

  private Fibonacci fibonacci;

  @BeforeEach
  void setUp() {
    fibonacci = new Fibonacci();
  }

  @TestFactory
  Stream<DynamicTest> findRecursivelyFibonacciNumbers() {
    return IntStream.range(0, numbers.length)
        .mapToObj(i -> dynamicTest("Find Fibonacci number: " + i, () -> {
          int result = fibonacci.findRecursively(numbers[i]);
          assertEquals(fibonacciNumbers[i], result);
        }));
  }

  @TestFactory
  Stream<DynamicTest> findRecursivelyFibonacciNumbersWithMemoization() {
    return IntStream.range(0, numbers.length)
        .mapToObj(i -> dynamicTest("Find Fibonacci number: " + i, () -> {
          int result = fibonacci.findRecursivelyWithMemoization(numbers[i]);
          assertEquals(fibonacciNumbers[i], result);
        }));
  }
}

package me.dolia.ads.search;

import java.util.function.ToIntBiFunction;

/**
 * Represents the function to search a position of given number among the given array of integers.
 */
@FunctionalInterface
public interface Search extends ToIntBiFunction<int[], Integer> {

}

package com.justinuy.playground.util;

import com.justinuy.playground.testing.Test;
import com.justinuy.playground.testing.TestClass;
import com.justinuy.playground.util.Arrays;
import java.util.ArrayList;

public final class ArraysTest extends TestClass {
  private static Test[] tests = new Test[] {
    new Test("Binary Search", new Runnable[] {
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[] {});

        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, -5));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 0));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 4));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 15));
      },
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[] {1});

        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, -5));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 0));
        Test.assertExpectedInt(0, Arrays.binarySearch(sortedNums, 1));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 15));
      },
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[] {8, 15});

        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, -5));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 0));
        Test.assertExpectedInt(0, Arrays.binarySearch(sortedNums, 8));
        Test.assertExpectedInt(1, Arrays.binarySearch(sortedNums, 15));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 22));
      },
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[]{ 10, 20, 30 });

        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 25));
        Test.assertExpectedInt(2, Arrays.binarySearch(sortedNums, 30));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 35));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 5));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 15));
        Test.assertExpectedInt(0, Arrays.binarySearch(sortedNums, 10));
        Test.assertExpectedInt(1, Arrays.binarySearch(sortedNums, 20));
      },
      () -> {
        Integer[] sortedNums =
          Arrays.toIntegerArray(new int[]{ 1, 3, 5, 7, 9, 11, 13, 15, 17 });

        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, -50));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 2));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 4));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 6));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 8));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 10));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 12));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 14));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 16));
        Test.assertExpectedInt(-1, Arrays.binarySearch(sortedNums, 18));
        Test.assertExpectedInt(0, Arrays.binarySearch(sortedNums, 1));
        Test.assertExpectedInt(1, Arrays.binarySearch(sortedNums, 3));
        Test.assertExpectedInt(2, Arrays.binarySearch(sortedNums, 5));
        Test.assertExpectedInt(3, Arrays.binarySearch(sortedNums, 7));
        Test.assertExpectedInt(4, Arrays.binarySearch(sortedNums, 9));
        Test.assertExpectedInt(5, Arrays.binarySearch(sortedNums, 11));
        Test.assertExpectedInt(6, Arrays.binarySearch(sortedNums, 13));
        Test.assertExpectedInt(7, Arrays.binarySearch(sortedNums, 15));
        Test.assertExpectedInt(8, Arrays.binarySearch(sortedNums, 17));
      }
    }),
    new Test("Interleave Arrays", new Runnable[] {
      () -> {
        Test.assertExpectedArray(
          new String[] {},
          Arrays.interleaveArrays(
            new String[] {},
            new String[] {}
          )
        );
        Test.assertExpectedArray(
          new String[] {"1", "2", "3"},
          Arrays.interleaveArrays(
            new String[] {"1", "2", "3"},
            new String[] {}
          )
        );
        Test.assertExpectedArray(
          new String[] { "1", "a", "2", "b", "3", "c" },
          Arrays.interleaveArrays(
            new String[] {"1", "2", "3"},
            new String[] {"a", "b", "c"}
          )
        );
        Test.assertExpectedArray(
          new String[] { "1", "a", "2", "b", "3", "c", "4", "5", "6"},
          Arrays.interleaveArrays(
            new String[] {"1", "2", "3", "4", "5", "6"},
            new String[] {"a", "b", "c"}
          )
        );
      }
    }),
  };

  public ArraysTest() {
    super(ArraysTest.tests);
  }
}

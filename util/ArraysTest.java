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

        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, -5));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 0));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 4));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 15));
      },
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[] {1});

        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, -5));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 0));
        Test.assertExpectedInts(0, Arrays.binarySearch(sortedNums, 1));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 15));
      },
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[] {8, 15});

        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, -5));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 0));
        Test.assertExpectedInts(0, Arrays.binarySearch(sortedNums, 8));
        Test.assertExpectedInts(1, Arrays.binarySearch(sortedNums, 15));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 22));
      },
      () -> {
        Integer[] sortedNums = Arrays.toIntegerArray(new int[]{ 10, 20, 30 });

        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 25));
        Test.assertExpectedInts(2, Arrays.binarySearch(sortedNums, 30));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 35));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 5));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 15));
        Test.assertExpectedInts(0, Arrays.binarySearch(sortedNums, 10));
        Test.assertExpectedInts(1, Arrays.binarySearch(sortedNums, 20));
      },
      () -> {
        Integer[] sortedNums =
          Arrays.toIntegerArray(new int[]{ 1, 3, 5, 7, 9, 11, 13, 15, 17 });

        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, -50));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 2));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 4));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 6));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 8));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 10));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 12));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 14));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 16));
        Test.assertExpectedInts(-1, Arrays.binarySearch(sortedNums, 18));
        Test.assertExpectedInts(0, Arrays.binarySearch(sortedNums, 1));
        Test.assertExpectedInts(1, Arrays.binarySearch(sortedNums, 3));
        Test.assertExpectedInts(2, Arrays.binarySearch(sortedNums, 5));
        Test.assertExpectedInts(3, Arrays.binarySearch(sortedNums, 7));
        Test.assertExpectedInts(4, Arrays.binarySearch(sortedNums, 9));
        Test.assertExpectedInts(5, Arrays.binarySearch(sortedNums, 11));
        Test.assertExpectedInts(6, Arrays.binarySearch(sortedNums, 13));
        Test.assertExpectedInts(7, Arrays.binarySearch(sortedNums, 15));
        Test.assertExpectedInts(8, Arrays.binarySearch(sortedNums, 17));
      }
    }),
  };

  public ArraysTest() {
    super(ArraysTest.tests);
  }
}

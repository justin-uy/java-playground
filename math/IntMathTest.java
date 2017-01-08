package com.justinuy.playground.math;

import com.justinuy.playground.testing.Test;
import com.justinuy.playground.testing.TestClass;
import com.justinuy.playground.util.Arrays;
import java.util.ArrayList;

public final class IntMathTest extends TestClass {

  protected static Test[] tests = {
    new Test("Array Sum Iterative", new Runnable[] {
      () -> {
        int[] nums = {};
        Test.assertExpectedInts(0, IntMath.arraySumIterative(nums));
      },
      () -> {
        int[] nums = {1};
        Test.assertExpectedInts(1, IntMath.arraySumIterative(nums));
      },
      () -> {
        int[] nums = {10, 20};
        Test.assertExpectedInts(30, IntMath.arraySumIterative(nums));
      },
      () -> {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Test.assertExpectedInts(45, IntMath.arraySumIterative(nums));
      },
    }),
    new Test("Array Sum", new Runnable[] {
      () -> {
        int[] nums = {};
        Test.assertExpectedInts(0, IntMath.arraySum(nums));
      },
      () -> {
        int[] nums = {1};
        Test.assertExpectedInts(1, IntMath.arraySum(nums));
      },
      () -> {
        int[] nums = {10, 20};
        Test.assertExpectedInts(30, IntMath.arraySum(nums));
      },
      () -> {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Test.assertExpectedInts(45, IntMath.arraySum(nums));
      },
    }),
    new Test("Primes up to N", new Runnable[] {
      () -> {
        int[] primes = null;

        for (int i : new int[] {-100, 0, 1}) {
          try {
            primes = IntMath.primesUpTo(i);
          } catch (RuntimeException e) {
            Test.assertExpectedBooleans(e != null, true);
          }
        }

        Test.assertExpectedNull(primes);
      },
      () -> {
        Test.assertExpectedIntArray(
          IntMath.primesUpTo(2),
          new int[] {2}
        );

        Test.assertExpectedIntArray(
          IntMath.primesUpTo(5),
          new int[] {2, 3, 5}
        );

        Test.assertExpectedIntArray(
          IntMath.primesUpTo(101),
          new int[] {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
            61, 67, 71, 73, 79, 83, 89, 97, 101
          }
        );
      },
    }),
  };

  public IntMathTest() {
    super(IntMathTest.tests);
  }
}

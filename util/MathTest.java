package com.justinuy.playground.util;

import com.justinuy.playground.testing.Test;
import com.justinuy.playground.util.Arrays;
import java.util.ArrayList;

public final class MathTest {

  public static final Test[] tests = {
    new Test("Array Sum (uses for loop)", new Runnable[] {
      () -> {
        int[] nums = {};
        Test.assertExpectedInt(0, Math.arraySum(nums));
      },
      () -> {
        int[] nums = {1};
        Test.assertExpectedInt(1, Math.arraySum(nums));
      },
      () -> {
        int[] nums = {10, 20};
        Test.assertExpectedInt(30, Math.arraySum(nums));
      },
      () -> {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Test.assertExpectedInt(45, Math.arraySum(nums));
      },
    }),
    new Test("Array Sum with while loop", new Runnable[] {
      () -> {
        int[] nums = {};
        Test.assertExpectedInt(0, Math.arraySumWithWhile(nums));
      },
      () -> {
        int[] nums = {1};
        Test.assertExpectedInt(1, Math.arraySumWithWhile(nums));
      },
      () -> {
        int[] nums = {10, 20};
        Test.assertExpectedInt(30, Math.arraySumWithWhile(nums));
      },
      () -> {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Test.assertExpectedInt(45, Math.arraySumWithWhile(nums));
      },
    }),
    new Test("Array Sum Recursive", new Runnable[] {
      () -> {
        int[] nums = {};
        Test.assertExpectedInt(0, Math.arraySumRecursive(nums));
      },
      () -> {
        int[] nums = {1};
        Test.assertExpectedInt(1, Math.arraySumRecursive(nums));
      },
      () -> {
        int[] nums = {10, 20};
        Test.assertExpectedInt(30, Math.arraySumRecursive(nums));
      },
      () -> {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Test.assertExpectedInt(45, Math.arraySumRecursive(nums));
      },
    }),
    new Test("Array Sum Functional", new Runnable[] {
      () -> {
        int[] nums = {};
        Test.assertExpectedInt(0, Math.arraySumFunctional(nums));
      },
      () -> {
        int[] nums = {1};
        Test.assertExpectedInt(1, Math.arraySumFunctional(nums));
      },
      () -> {
        int[] nums = {10, 20};
        Test.assertExpectedInt(30, Math.arraySumFunctional(nums));
      },
      () -> {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Test.assertExpectedInt(45, Math.arraySumFunctional(nums));
      },
    }),
    new Test("Primes up to N", new Runnable[] {
      () -> {
        int[] primes = null;

        for (int i : new int[] {-100, 0, 1}) {
          try {
            primes = Math.primesUpTo(i);
          } catch (RuntimeException e) {
            Test.assertExpectedBoolean(e != null, true);
          }
        }

        Test.assertExpectedNull(primes);
      },
      () -> {
        Test.assertExpectedIntArray(
          Math.primesUpTo(2),
          new int[] {2}
        );

        Test.assertExpectedIntArray(
          Math.primesUpTo(5),
          new int[] {2, 3, 5}
        );

        Test.assertExpectedIntArray(
          Math.primesUpTo(101),
          new int[] {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
            61, 67, 71, 73, 79, 83, 89, 97, 101
          }
        );
      },
    }),
    new Test("First Fibs", new Runnable[] {
      () -> {
        Test.assertExpectedLongArray(
          Math.firstFibs(10),
          new long[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}
        );
      },
    }),
    new Test("Largest Combined Number", new Runnable[] {
      () -> {
        Test.assertExpected(
          Math.getLargestCombinedNumber(new int[] {
            1, 2, 3, 4, 5
          }),
          "54321"
        );
        Test.assertExpected(
          Math.getLargestCombinedNumber(new int[] {
            1, 2, 3, 4, 5, 50
          }),
          "5504321"
        );
        Test.assertExpected(
          Math.getLargestCombinedNumber(new int[] {
            9, 97, 987
          }),
          "998797"
        );
      }
    }),
  };
}

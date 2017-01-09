package com.justinuy.playground.util;

import com.justinuy.playground.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public final class Math {

  /**
   * Given an array of ints return the sum.
   * <p>
   * The sum is computed in an iterative fashion using a for loop
   * </p>
   *
   * @param nums is an array of ints with no constraints
   * @return int
   */
  public static int arraySum(int[] a) {
    int sum = 0;
    for (int v : a) {
      sum += v;
    }
    return sum;
  }

  /**
   * Given an array of ints return the sum.
   * <p>
   * The sum is computed in an iterative fashion using a while loop
   * </p>
   *
   * @param nums is an array of ints with no constraints
   * @return int
   */
  public static int arraySumWithWhile(int[] a) {
    int sum = 0;
    int i = 0;

    while (i < a.length) {
      sum += a[i];
      i++;
    }

    return sum;
  }

  /**
   * Given an array of ints return the sum.
   * <p>
   * The sum is computed recursively
   * </p>
   *
   * @param nums is an array of ints with no constraints
   * @return int
   */
  public static int arraySumRecursive(int[] a) {
    return arraySumRecursiveFrom(a, 0);
  }

  /**
   * Given an array of ints return the sum start with a given index.
   * <p>
   * The sum is computed recursively
   * </p>
   *
   * @param nums is an array of ints with no constraints
   * @return int
   */
  private static int arraySumRecursiveFrom(int[] a, int i) {
    if (i >= a.length) {
      return 0;
    }

    return a[i] + arraySumRecursiveFrom(a, i + 1);
  }

  /**
   * Given an array of ints return the sum.
   * <p>
   * The sum is computed in an functional fashion. In order to do this, we must first the array
   * into a stream of Integers. Once we do that, we can call reduce and accumulate the sum.
   * Finally, we unbox to get the int value
   * </p>
   *
   * @param nums is an array of ints with no constraints
   * @return int
   */
  public static int arraySumFunctional(int[] nums) {
    return IntStream.of(nums).boxed().reduce(0, (sum, n) -> sum + n).intValue();
  }

  /**
   * Returns the prime numbers up to and including the given value n.
   *
   * @param n must be a number greater than 1
   * @return array of int
   */
  public static int[] primesUpTo(int n) {
    if (n <= 1) {
      throw new IllegalArgumentException("N must be greater than 1");
    }

    Stack<Integer> primes = new Stack<>();
    if (n > 1) {
      primes.push(2);
    }

    for (int i = 3; i <= n; i += 2) {
      if (isPrime(i)){
        primes.push(i);
      }
    }

    return Arrays.toIntArray(primes);
  }

  /**
   * isPrime will return true if the given value is a prime number.
   * <p>
   * This method uses the lemma that a divisor of
   * </p>
   * @param n
   * @return true or false
   */
  public static boolean isPrime(int n) {
    if (n < 2 || (n > 2 && n % 2 == 0)) {
      return false;
    }

    int maxPotentialDivisor = (int)java.lang.Math.sqrt(n);

    // 2 is a prime and will not not execute the body of this for loop
    for (int i = 3; i <= maxPotentialDivisor; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * Given an integer, return an array of the first N longs in the
   * fibonacci sequence.
   *
   * @param n
   * @return long[] because it will allow for more number in the sequence
   * integer overflow (64 bits intead of 32 bits)
   */
  public static long[] firstFibs(int n) {
    long[] fibs = new long[n];

    if (n >= 1) {
      fibs[0] = 0;
    }

    if (n >= 2) {
      fibs[1] = 1;
    }

    if (n >= 3) {
      fibs[2] = 1;
    }

    if (n > 3) {
      for (int i = 2; i < fibs.length - 1; i++) {
        fibs[i + 1] = fibs[i] + fibs[i - 1];
      }
    }

    return fibs;
  }

  /**
   * Private class used to calculate the largest combined number given
   * int[] by encapsulating the value and also digits in a String[]
   */
  private static class NumberConfig {
    public int value;
    public String[] digitsArray;

    private NumberConfig(int value) {
      this.value = value;
      digitsArray = String.valueOf(value).split("");
    }
  }

  /**
   * Given an array of integers, concatenate the digits together to form the
   * largest possible number
   *
   * @param a int[] with elements of any size
   * @return String since more than 10 digits would result in integer overflow
   */
  public static String getLargestCombinedNumber(int[] a) {
    NumberConfig[] configs = new NumberConfig[a.length];

    for (int i = 0; i < a.length; i++) {
      configs[i] = new NumberConfig(a[i]);
    }

    java.util.Arrays.sort(configs, (NumberConfig c1, NumberConfig c2) -> {
      String[] da1 = c1.digitsArray;
      String[] da2 = c2.digitsArray;
      for (int i = 0; i < java.lang.Math.min(da1.length, da2.length); i++) {
        int compareVal = da1[i].compareTo(da2[i]);
        if (compareVal != 0) {
          return -1 * compareVal;
        }
      }

      // for all indexices that exist for both a and b, all values are equal
      // In that case choose the int with the fewest digits
      if (da1.length < da2.length) {
        return -1;
      } else if (da1.length > da2.length) {
        return 1;
      }

      // if they have the same length and all the same digits
      // they are equal
      return 0;
    });

    StringBuffer sb = new StringBuffer();

    for (NumberConfig config : configs) {
      sb.append(config.value);
    }

    return sb.toString();
  }
}

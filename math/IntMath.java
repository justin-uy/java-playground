package com.justinuy.playground.math;

import com.justinuy.playground.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public final class IntMath {

  /**
   * Given an array of ints return the sum.
   * <p>
   * The sum is computed in an iterative fashion using a for loop
   * </p>
   *
   * @param nums is an array of ints with no constraints
   * $return int
   */
  public static int arraySumIterative(int[] nums) {
    int sum = 0;
    for (int v : nums) {
      sum += v;
    }
    return sum;
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
   * $return int
   */
  public static int arraySum(int[] nums) {
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

    int maxPotentialDivisor = (int)Math.sqrt(n);

    // 2 is a prime and will not not execute the body of this for loop
    for (int i = 3; i <= maxPotentialDivisor; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}

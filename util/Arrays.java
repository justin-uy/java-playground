package com.justinuy.playground.util;

import java.lang.Comparable;
import java.lang.StringBuffer;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public final class Arrays {

  /**
   * A short utility function to simplify converting List<Integer> to int[].
   * @param list
   * @return int[] with same contents as input
   */
  public static int[] toIntArray(List<Integer> list) {
    return list.stream().mapToInt(i -> i).toArray();
  }

  /**
   * A short utility function to simplify converting int[] to Integer[].
   * @param int[]
   * @return Integer[] with same contents as input
   */
  public static Integer[] toIntegerArray(int[] a) {
    return IntStream.of(a).boxed().toArray(Integer[]::new);
  }

  /**
   * A short utility function to simplify converting int[] to List<Integer>.
   * @param int[]
   * @return List<Integer> with same contents as input
   */
  public static List<Integer> toIntegerList(int[] a) {
    return IntStream.of(a).boxed().collect(Collectors.toList());
  }

  /**
   * Return a nice readable string given an int[].
   * <p>
   * Array toString() default implementation returns the refererence. We want to provide a
   * convenient function that returns a readable/printable string that reflects the contents.
   * </p>
   * @param int[]
   * @return String
   */
  public static String toString(int[] arr) {
    StringBuffer buffer = new StringBuffer();
    buffer.append("[ ");

    for (int i = 0; i < arr.length; i++) {
      buffer.append(arr[i]);
      buffer.append(" ");
    }

    buffer.append("]");
    return buffer.toString();
  }

  /**
   * Given a sorted array and a comparable object, try to return the index of an element in the
   * array with the same value.
   *
   * @param array of elements
   * @param element that is sought
   * @return the index or -1 if the element is not found
   */
  public static <T extends Comparable<T>> int binarySearch(T[] a, T key) {
    return binarySearchOnRange(0, a.length -1, a, key);
  }

  /**
   * Given a sorted array, a range (min, max) to search on and a comparable object, try to return
   * the index of an element in the array with the same value.
   *
   * @param min the bottom of the index range
   * @param max the top of the index range
   * @param array of elements
   * @param element that is sought
   * @return the index or -1 if the element is not found
   */
  public static <T extends Comparable<T>> int binarySearchOnRange(int min, int max, T[] a, T key) {
    if (min > max) {
      return -1;
    }

    int median = (max - min / 2) + min;
    int compareValue = key.compareTo(a[median]);

    if (compareValue < 0) {
      return binarySearchOnRange(min, median - 1, a, key);
    } else if (compareValue > 0) {
      return binarySearchOnRange(median + 1, max, a, key);
    } else {
      return median;
    }
  }
}

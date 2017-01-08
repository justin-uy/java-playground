package com.justinuy.playground.testing;

import com.justinuy.playground.util.AbstractTask;
import java.util.Arrays;
import java.io.StringWriter;
import java.io.PrintWriter;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public final class Test extends AbstractTask {

  private long startTime;
  private Runnable[] testCases;
  private static int testCounter = 0;
  private static int assertionCounter = 0;
  private boolean silent;
  private boolean runSuccess;

  public Test(String name, Runnable[] testCases) {
    super(name, Test.testCounter + 1);
    this.testCases = testCases;
    Test.testCounter += 1;
  }

  @Override
  public final void onStart() {
    startTime = System.currentTimeMillis();
  }

  public final void setSilent(boolean silent) {
    this.silent = silent;
  }

  public final boolean getRunSuccess() {
    return this.runSuccess;
  }

  @Override
  public final void onSuccess() {
    this.runSuccess = true;
    if (silent) {
      return;
    }

    System.out.printf(
      "Test %d: %s - Success[%dms]\n",
      this.id,
      this.name,
      System.currentTimeMillis() - startTime
    );
  }

  @Override
  public final void onFail(RuntimeException e) {
    if (silent) {
      return;
    }
    StringWriter sw = new StringWriter();
    e.printStackTrace(new PrintWriter(sw));
    System.out.printf(
      "Test %d: %s - Fail\n%s\n",
      this.id,
      this.name,
      sw.toString()
    );
  }

  @Override
  public final void runTask() {
    for (Runnable testCase : this.testCases) {
      testCase.run();
    }
  }

  public static void assertExpectedIntArray(int[] result, int[] expected) {
    Test.assertionCounter++;
    if (!Arrays.equals(result, expected)) {
      throw new RuntimeException(
        String.format(
          "expected %s to equal %s",
          com.justinuy.playground.util.Arrays.toString(expected),
          com.justinuy.playground.util.Arrays.toString(result)
        )
      );
    }
  }

  public static void assertExpectedNull(Object result) {
    Test.assertionCounter++;
    if (result != null) {
      throw new RuntimeException(
        String.format("expected %s to equal null", result)
      );
    }
  }

  public static void assertExpectedInts(int result, int expected) {
    Test.assertExpected(new Integer(result), new Integer(expected));
  }

  public static void assertExpectedBooleans(boolean result, boolean expected) {
    Test.assertExpected(new Boolean(result), new Boolean(expected));
  }

  public static void assertExpected(Object result, Object expected) {
    Test.assertionCounter++;
    if (!expected.equals(result)) {
      throw new RuntimeException(
        String.format("expected %s to equal %s", expected, result)
      );
    }
  }

  public static int getTotalAssertions() {
    return Test.assertionCounter;
  }
}
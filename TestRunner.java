import com.justinuy.playground.util.MathTest;
import com.justinuy.playground.util.ArraysTest;;
import com.justinuy.playground.testing.Test;
import com.justinuy.playground.testing.TestClass;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.lang.Thread;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public class TestRunner {

  // Array of test classes to test
  private static TestClass[] testClasses = new TestClass[] {
    new MathTest(),
    new ArraysTest(),
  };

  // if you pass the flag -s (silent), nothing will be written to stdout
  public static void main(String[] args) {
    boolean success =
      TestRunner.runTests(args.length > 0 ? args[0].equals("-s") : false);

    if (success) {
      System.exit(0);
    } else {
      System.exit(1);
    }
  }

  // Runs all the test from the various test classes in parallel
  // Up to 8 concurrent threads
  private static boolean runTests(boolean silent) {
    ArrayList<Test> tests = getTests();
    int totalTests = tests.size();

    ExecutorService executor =
      Executors.newFixedThreadPool(Math.min(totalTests, 8));

    printfIf(!silent, "%d tests running\n", totalTests);

    long startTime = System.currentTimeMillis();
    for (Test test : tests) {
      test.setSilent(silent);
      executor.execute(test);
    }

    executor.shutdown();
    while (!executor.isTerminated()) {}

    printfIf(
      !silent,
      "\n%d tests completed. %d assertions [%dms]\n",
      totalTests,
      Test.getTotalAssertions(),
      System.currentTimeMillis() - startTime
    );

    for (Test test : tests) {
      if (!test.getRunSuccess()) {
        return false;
      }
    }

    return true;
  }

  // convenience function for making conditional println statements more terse
  private static void printfIf(boolean condition, String s, Object... args) {
    if (condition) {
      System.out.printf(s, args);
    }
  }

  // convenience function for making conditional printf statements more terse
  private static void printlnIf(boolean condition, String s) {
    if (condition) {
      System.out.println(s);
    }
  }

  private static ArrayList<Test> getTests() {
    ArrayList<Test> tests = new ArrayList<>();
    for (TestClass testClass : TestRunner.testClasses) {
      for (Test test : testClass.getTests()) {
        tests.add(test);
      }
    }

    return tests;
  }
}

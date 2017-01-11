import com.justinuy.playground.testing.Test;
import com.justinuy.playground.testing.TestClass;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.lang.reflect.Field;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public class TestRunner {

  private static class TestRunnerConfig {
    public boolean silent;
    public ArrayList<String> testClassNames;

    public TestRunnerConfig(String[] args) {
      testClassNames = new ArrayList<>(args.length);
      for (String s : args) {
        if (s == "-s") {
          silent = true;
        } else {
          testClassNames.add(s);
        }
      }
    }
  }

  // if you pass the flag -s (silent), nothing will be written to stdout
  // class names should be passed (as a string) with theif fully qualified name
  public static void main(String[] args) {
    TestRunnerConfig config = new TestRunnerConfig(args);

    boolean success = false;
    try {
      success = TestRunner.runTests(config.silent, config.testClassNames);
    } catch (Exception e) {
      // success is already initialized to false so we don't need to set it in here
      printfIf(
        !config.silent,
        "An exception was thrown trying to get tests from Test classes: %s\n",
        Test.getStackTraceString(e)
      );
    }

    if (success) {
      System.exit(0);
    } else {
      System.exit(1);
    }
  }

  // Runs all the test from the various test classes in parallel
  // Up to 8 concurrent threads
  private static boolean runTests(boolean silent, ArrayList<String> testClassNames) throws Exception {
    ArrayList<Test> tests = getTests(silent, testClassNames);
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

  private static ArrayList<Test> getTests(boolean silent, ArrayList<String> testClassNames) throws Exception {
    ArrayList<Test> tests = new ArrayList<>();

    for (String testClassName : testClassNames) {
      // If any of the reflection fails, all TestRunner should fail
      Field testField = Class.forName(testClassName).getField("tests");

      if (testField.getType().isArray()) {
        Class<?> fieldElement = testField.getType().getComponentType();

        if (fieldElement == Test.class) {
          for (Test test : (Test[])testField.get(null)) {
            tests.add(test);
          }
        } else {
          throw new RuntimeException("Tests field should be of type Tests[]");
        }
      } else {
        throw new RuntimeException("Tests field should be of type Tests[]");
      }
    }

    return tests;
  }
}

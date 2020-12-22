package hackerrank.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


/*
 * Problem statement is here: https://www.hackerrank.com/challenges/new-year-chaos/problem
 */

class NewYearChaosTest {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {
    int res = 0;
    for (int i = q.length - 1; i >= 0; i--) {
      if (q[i] - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Math.max(0, q[i] - 2); j < i; j++) {
        if (q[j] > q[i])
          res++;
      }
    }
    System.out.println(res);
  }

  @Test
  void testMinimumBribes() {
    class TestCase {
      public TestCase(int[] arr, String answer) {
        super();
        this.arr = arr;
        this.answer = answer;
      }

      public transient int[] arr;
      public transient String answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase(new int[] {2, 1, 5, 3, 4}, "3"));
    cases.add(new TestCase(new int[] {2, 5, 1, 3, 4}, "Too chaotic"));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);

      try (PrintStream old = System.out) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        minimumBribes(tc.arr);
        System.out.flush();
        System.setOut(old);
        String res = baos.toString().trim();
        assertEquals(tc.answer, res,
            String.format("#%d when input: arr=%s expected: \"%s\", got: \"%s\", result: %s\n", i,
                Arrays.toString(tc.arr), tc.answer, res, res.equals(tc.answer)));

      }
    }
  }
}

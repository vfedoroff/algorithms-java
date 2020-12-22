package hackerrank.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


/*
 * Problem statement is here: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
class LeftRotationTest {

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    int[] out = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      int j = (i + a.length - d) % a.length;
      out[j] = a[i];
    }
    return out;
  }

  @Test
  void testRotLeft() {
    class TestCase {
      public TestCase(int[] arr, int d, int[] answer) {
        super();
        this.arr = arr;
        this.d = d;
        this.answer = answer;
      }

      public transient int[] arr;
      public transient int d;
      public transient int[] answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();

    cases.add(new TestCase(new int[] {1, 2, 3, 4, 5}, 4, new int[] {5, 1, 2, 3, 4}));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      int[] res = rotLeft(tc.arr, tc.d);
      assertTrue(Arrays.equals(tc.answer, res),
          String.format("#%d when input: arr=%s expected: %s, got: %s, result: %s\n", i,
              Arrays.toString(tc.arr), Arrays.toString(tc.answer), Arrays.toString(res),
              Arrays.equals(tc.answer, res)));
    }
  }
}

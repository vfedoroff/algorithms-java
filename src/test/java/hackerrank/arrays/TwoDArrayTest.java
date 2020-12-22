package hackerrank.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


/*
 * Problem statement is here: https://www.hackerrank.com/challenges/2d-array/problem?
 */
class TwoDArrayTest {

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    if (arr.length < 3) {
      return -1;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].length < 3) {
        return -1;
      }
    }
    int sum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = 0; j < arr[i].length - 2; j++) {
        int tSum = (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]) + arr[i + 1][j + 1]
            + (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
        sum = Math.max(sum, tSum);
      }
    }
    return sum;
  }

  @Test
  void testHourglassSum() {
    class TestCase {
      public TestCase(int[][] arr, int answer) {
        super();
        this.arr = arr;
        this.answer = answer;
      }

      public transient int[][] arr;
      public transient int answer;
    }
    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase(new int[][] {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0},
        {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}}, 19));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      long res = hourglassSum(tc.arr);
      assertEquals(tc.answer, res,
          String.format("#%d when input: arr=%s expected: %d, got: %d, result: %s\n", i,
              Arrays.deepToString(tc.arr), tc.answer, res, res == tc.answer));
    }
  }
}

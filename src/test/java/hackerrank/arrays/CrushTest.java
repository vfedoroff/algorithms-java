package hackerrank.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

// Problem statement: https://www.hackerrank.com/challenges/crush/problem
class CrushTest {

  static long arrayManipulation(int n, int[][] queries) {
    long result = -1;
    long[] resultArray = new long[n];
    for (int i = 0; i < queries.length; i++) {
      for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
        resultArray[j] = resultArray[j] + queries[i][2];
        result = Math.max(result, resultArray[j]);
      }
    }
    return result;
  }

  @Test
  void testArrayManipulation() {
    class TestCase {
      public TestCase(int n, int[][] queries, long answer) {
        super();
        this.n = n;
        this.queries = queries;
        this.answer = answer;
      }

      public transient int n;
      public transient int[][] queries;
      public transient long answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();

    cases.add(new TestCase(5, new int[][] {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}, 200));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      long res = arrayManipulation(tc.n, tc.queries);
      assertEquals(tc.answer, res,
          String.format("#%d when input: n=%d,queries=%s expected: %d, got: %d, result: %s", i,
              tc.n, Arrays.deepToString(tc.queries), res, tc.answer, res == tc.answer));
    }
  }
}

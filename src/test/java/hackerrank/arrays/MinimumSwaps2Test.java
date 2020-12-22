package hackerrank.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

/*
 * Problem statement is here: https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
class MinimumSwaps2Test {
  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    int n = arr.length;
    TreeMap<Integer, Integer> sorted = new TreeMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      sorted.put(arr[i], i);
    }
    // To keep track of visited elements. Initialize
    // all elements as not visited or false.
    Boolean[] vis = new Boolean[n];
    Arrays.fill(vis, false);
    // Initialize result
    int result = 0;
    Object[] keys = sorted.values().toArray();
    // Traverse array elements
    for (int i = 0; i < n; i++) {
      // already swapped and corrected or
      // already present at correct pos
      if (vis[i] || (int) keys[i] == arr[i]) {
        continue;
      }

      // find out the number of node in
      // this cycle and add in ans
      int cycleSize = 0;
      int j = i;
      while (!vis[j]) {
        vis[j] = true;
        // move to next node
        j = (int) keys[j];
        cycleSize++;
      }

      // Update answer by adding current cycle.
      if (cycleSize > 0) {
        result += (cycleSize - 1);
      }
    }
    // Return result
    return result;
  }


  @Test
  public void testMinimumSwaps() {
    class TestCase {
      public TestCase(int[] arr, int answer) {
        super();
        this.arr = arr;
        this.answer = answer;
      }

      public int[] arr;
      public int answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();

    cases.add(new TestCase(new int[] {2, 3, 4, 1, 5}, 3));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      int res = minimumSwaps(tc.arr);
      assertEquals(tc.answer, res,
          String.format("#%d when input: arr=%s expected: %s, got: %d, result: %b\n", i,
              Arrays.toString(tc.arr), tc.answer, res, tc.answer == res));
    }
  }

}

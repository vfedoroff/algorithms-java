package hackerrank.greedyAlgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GreedyFloristTest {

  // Complete the getMinimumCost function below.
  static int getMinimumCost(int k, int[] c) {
    Arrays.sort(c);
    int total = 0;
    for (int i = c.length - 1; i >= 0; i--) {
      int timesBought = ((c.length - 1) - i) / k;
      int price = c[i] * (timesBought + 1);
      total += price;
    }
    return total;
  }

  @Test
  void testGetMinimumCost() {
    class TestCase {
      public TestCase(int k, int[] c, int answer) {
        super();
        this.k = k;
        this.c = c;
        this.answer = answer;
      }

      public transient int k;
      public transient int[] c;
      public transient int answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase(3, new int[] {2, 5, 6}, 13));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      int res = getMinimumCost(tc.k, tc.c);
      assertEquals(tc.answer, res);
    }
  }
}

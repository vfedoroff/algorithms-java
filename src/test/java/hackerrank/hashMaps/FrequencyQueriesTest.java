package hackerrank.hashMaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FrequencyQueriesTest {

  // Complete the freqQuery function below.
  static List<Integer> freqQuery(int[][] queries) {
    Map<Integer, Integer> frequency = new HashMap<>();
    Map<Integer, Integer> presents = new HashMap<>();
    List<Integer> result = new ArrayList<Integer>();
    for (int[] query : queries) {
      int operation = query[0];
      int value = query[1];
      Integer oldfreq;
      Integer newfreq;
      switch (operation) {
        case 1:
          oldfreq = frequency.getOrDefault(value, null);
          newfreq = (oldfreq != null) ? oldfreq + 1 : 1;
          frequency.put(value, newfreq);
          if (presents.merge(oldfreq, -1, Integer::sum) <= 0) {
            presents.remove(oldfreq);
          } ;
          presents.merge(newfreq, 1, Integer::sum);
          break;
        case 2:
          oldfreq = frequency.getOrDefault(value, null);
          newfreq = (oldfreq != null) ? oldfreq - 1 : 0;
          if (newfreq == 0) {
            frequency.remove(value);
          } else {
            frequency.put(value, newfreq);
          }
          if (presents.merge(oldfreq, -1, Integer::sum) <= 0) {
            presents.remove(oldfreq);
          } ;
          presents.merge(newfreq, 1, Integer::sum);
          break;
        case 3:
          result.add(presents.containsKey(value) ? 1 : 0);
          break;
      }
    }
    return result;
  }

  @Test
  void testFreqQuery() {
    class TestCase {
      public TestCase(int[][] queries, List<Integer> answer) {
        super();
        this.queries = queries;
        this.answer = answer;
      }

      public int[][] queries;
      public List<Integer> answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(
        new TestCase(new int[][] {{1, 5}, {1, 6}, {3, 2}, {1, 10}, {1, 10}, {1, 6}, {2, 5}, {3, 2}},
            new ArrayList<Integer>() {
              {
                add(0);
                add(1);
              }
            }));
    cases.add(new TestCase(new int[][] {{1, 3}, {2, 3}, {3, 2}, {1, 4}, {1, 5}, {1, 5}, {1, 4},
        {3, 2}, {2, 4}, {3, 2}}, new ArrayList<Integer>() {
          {
            add(0);
            add(1);
            add(1);
          }
        }));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      List<Integer> result = freqQuery(tc.queries);
      assertEquals(tc.answer, result,
          String.format("#%d when input: queries=%s expected: %s, got: %s, result: %s\n", i,
              Arrays.toString(tc.queries), Arrays.toString(tc.answer.toArray()),
              Arrays.toString(result.toArray()), tc.answer.equals(result)));
    }
  }
}

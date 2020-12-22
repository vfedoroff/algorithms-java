package hackerrank.hashMaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CountTripletsTest {
  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    Map<Long, List<Integer>> numberToIndices = new HashMap<>();
    for (int i = 0; i < arr.size(); i++) {
      Long key = arr.get(i);
      if (!numberToIndices.containsKey(key)) {
        numberToIndices.put(key, new ArrayList<>());
      }
      numberToIndices.get(key).add(i);
    }
    int result = 0;
    for (int i = 0; i < arr.size(); i++) {
      long currentElement = arr.get(i);
      if (currentElement % r != 0) {
        continue;
      }
      long beforeElement = currentElement / r;
      long afterElement = currentElement * r;
      if (afterElement > Integer.MAX_VALUE) {
        continue;
      }

      if (!numberToIndices.containsKey(beforeElement)) {
        continue;
      }
      if (!numberToIndices.containsKey(afterElement)) {
        continue;
      }
      Integer beforeIndex = i - 1;
      Integer afterIndex = i + 1;
      if (beforeIndex < 0) {
        continue;
      }
      if (afterIndex > arr.size()) {
        continue;
      }
      result = result
          + numberToIndices.get(beforeElement).size() * numberToIndices.get(afterElement).size();
    }
    return result;
  }

  @Test
  void testCountTriplets() {
    class TestCase {
      public TestCase(List<Long> arr, long r, long answer) {
        super();
        this.arr = arr;
        this.r = r;
        this.answer = answer;
      }

      public List<Long> arr;
      public long r;
      public long answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase(new ArrayList<Long>(Arrays.asList(1L, 2L, 2L, 4L)), 2, 2));
    cases.add(new TestCase(new ArrayList<Long>(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L)), 3, 6));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      long res = countTriplets(tc.arr, tc.r);
      assertEquals(tc.answer, res,
          String.format("#%d when input: arr=%s, r=%d expected: %d, got: %d, result: %s\n", i,
              Arrays.toString(tc.arr.toArray()), tc.r, tc.answer, res, res == tc.answer));
    }
  }
}

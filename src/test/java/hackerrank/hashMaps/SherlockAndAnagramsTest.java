package hackerrank.hashMaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SherlockAndAnagramsTest {
  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {
    Map<String, Integer> map = new HashMap<>();
    int len = s.length();
    int result = 0;
    for (int i = 0; i <= len; i++) {
      for (int j = 0; j <= len; j++) {
        if (i < j) {
          char[] arr = s.substring(i, j).toCharArray();
          Arrays.sort(arr);
          String string = String.valueOf(arr);
          map.merge(string, 1, Integer::sum);
        }
      }
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int n = entry.getValue();
      result = result + (n * (n - 1)) / 2;
    }
    return result;
  }

  @Test
  void testSherlockAndAnagrams() {
    class TestCase {
      public TestCase(String s, int answer) {
        super();
        this.s = s;
        this.answer = answer;
      }

      public String s;
      public int answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase("mom", 2));
    cases.add(new TestCase("abba", 4));
    cases.add(new TestCase("abcd", 0));
    cases.add(new TestCase("ifailuhkqq", 3));
    cases.add(new TestCase("kkkk", 10));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      int res = sherlockAndAnagrams(tc.s);
      assertEquals(tc.answer, res,
          String.format("#%d when input: s=%s expected: %d, got: %d, result: %s\n", i, tc.s,
              tc.answer, res, res == tc.answer));
    }
  }
}

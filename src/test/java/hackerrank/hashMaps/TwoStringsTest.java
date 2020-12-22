package hackerrank.hashMaps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class TwoStringsTest {
  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    Set<Character> s1Set =
        new HashSet<Character>(s1.chars().mapToObj(i -> (char) i).collect(Collectors.toList()));
    Set<Character> s2Set =
        new HashSet<Character>(s2.chars().mapToObj(i -> (char) i).collect(Collectors.toList()));
    s1Set.retainAll(s2Set);
    return (s1Set.size() > 0) ? "YES" : "NO";
  }

  @Test
  void testTwoStrings() {
    class TestCase {
      public TestCase(String s1, String s2, String answer) {
        super();
        this.s1 = s1;
        this.s2 = s2;
        this.answer = answer;
      }

      public transient String s1;
      public transient String s2;
      public transient String answer;
    }

    List<TestCase> cases = new ArrayList<TestCase>();

    cases.add(new TestCase("hello", "world", "YES"));
    cases.add(new TestCase("hi", "world", "NO"));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      String res = twoStrings(tc.s1, tc.s2);
      assertEquals(tc.answer, res,
          String.format("#%d when input: s1=%s, s2=%s expected: %s, got: %s, result: %s\n", i,
              tc.s1, tc.s2, tc.answer, res, res == tc.answer));
    }
  }
}

package hackerrank.hashMaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;



// Problem: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
class RansomNoteTest {
  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < magazine.length; i++) {
      map.merge(magazine[i], 1, Integer::sum);
    }
    for (int i = 0; i < note.length; i++) {
      String word = note[i];
      if (map.getOrDefault(word, 0) == 0) {
        System.out.println("No");
        return;
      } else {
        map.merge(word, -1, Integer::sum);
      }
    }
    System.out.println("Yes");
  }

  @Test
  void testCheckMagazine() {

    class TestCase {
      public TestCase(String[] magazine, String[] note, String answer) {
        super();
        this.magazine = magazine;
        this.note = note;
        this.answer = answer;
      }

      public String[] magazine;
      public String[] note;
      public String answer;
    }

    Function<String[], String[], String> func = (String[] magazine, String[] note) -> {
      // Create a stream to hold the output
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos);
      // IMPORTANT: Save the old System.out!
      PrintStream old = System.out;
      // Tell Java to use your special stream
      System.setOut(ps);
      checkMagazine(magazine, note);
      // Put things back
      System.out.flush();
      System.setOut(old);
      return baos.toString();
    };
    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase(new String[] {"give", "me", "one", "grand", "today", "night"},
        new String[] {"give", "one", "grand", "today"}, "Yes"));
    cases.add(new TestCase(new String[] {"two", "times", "three", "is", "not", "four"},
        new String[] {"two", "times", "two", "is", "four"}, "No"));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      String res = func.run(tc.magazine, tc.note);
      assertEquals(tc.answer, res.trim(),
          String.format("#%d when input: magazine=%s, note=%s expected: %s, got: %s, result: %s\n",
              i, Arrays.toString(tc.magazine), Arrays.toString(tc.note), tc.answer.trim(),
              res.trim(), res.trim().equals(tc.answer)));
    }
  }
}


@FunctionalInterface
interface Function<X, Y, R> {
  public R run(X magazine, Y note);
}

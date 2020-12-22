package hackerrank.flippingBits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FlippingBitsTest {

  // Problem: https://www.hackerrank.com/challenges/flipping-bits/problem
  // Complete the flippingBits function below.
  static long flippingBits(long n) {
    return n ^ ((long) Math.pow(2, 32) - 1);
  }


  @Test
  void testFlippingBits() {
    class TestCase {
      public TestCase(long input, long answer) {
        super();
        this.input = input;
        this.answer = answer;
      }

      public transient long input;
      public transient long answer;
    }
    List<TestCase> cases = new ArrayList<TestCase>();
    cases.add(new TestCase(2147483647, 2147483648L));
    cases.add(new TestCase(1, 4294967294L));
    cases.add(new TestCase(0, 4294967295L));
    for (int i = 0; i < cases.size(); i++) {
      TestCase tc = cases.get(i);
      long res = flippingBits(tc.input);
      assertEquals(tc.answer, res);
    }
  }
}

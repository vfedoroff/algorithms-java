package leecode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class RomanToIntegerTest {
  class Solution {

    private final Map<String, Integer> values = new HashMap<>();

    public Solution() {
      values.put("M", 1000);
      values.put("D", 500);
      values.put("C", 100);
      values.put("L", 50);
      values.put("X", 10);
      values.put("V", 5);
      values.put("I", 1);
    }

    public int romanToInt(String s) {
      String symbol = s.substring(s.length() - 1);
      int value = values.get(symbol);
      int total = value;
      int len = s.length();
      for (int i = len - 2; i >= 0; --i) {
        String currentSymbol = s.substring(i, i + 1);
        int currentValue = values.get(currentSymbol);
        if (currentValue < value) {
          total -= currentValue;
        } else {
          total += currentValue;
        }
        value = currentValue;
      }
      return total;
    }
  }

  @Test
  void testRomanToInt() {
    Solution solution = new Solution();
    assertEquals(1994, solution.romanToInt("MCMXCIV"));
    assertEquals(58, solution.romanToInt("LVIII"));
    assertEquals(9, solution.romanToInt("IX"));
  }

}

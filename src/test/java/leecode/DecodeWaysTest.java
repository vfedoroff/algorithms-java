package leecode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeWaysTest {

    class Solution {

        Map<Integer, Integer> memo = new HashMap<>(); // Cache to reduce a number of operations

        public int numDecodings(String s) {
            return numDecodings(0, s);
        }

        private int numDecodings(int index, String str) {
            System.out.println(str.substring(0, index));
            // Have we already seen this substring?
            if (memo.containsKey(index)) {
                return memo.get(index);
            }

            // If you reach the end of the string
            // Return 1 for success.
            if (index == str.length()) {
                return 1;
            }

            // If the string starts with a zero, it can't be decoded
            if (str.charAt(index) == '0') {
                return 0;
            }

            if (index == str.length() - 1) {
                return 1;
            }


            int ans = numDecodings(index + 1, str);
            if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
                ans += numDecodings(index + 2, str);
            }

            // Save for memoization
            memo.put(index, ans);

            return ans;
        }
    }

    @Test
    void numDecodings() {
        Solution solution = new Solution();
        int actual = solution.numDecodings("12");
        assertEquals(2, actual);
        actual = solution.numDecodings("226");
        assertEquals(3, actual);
    }
}

package leecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {
    class Solution {
        public int reverse(int x) {
            boolean isNegative = x < 0;
            int num = x;
            int n = 0;
            int p = 0;
            while (num != 0) {
                int remainder = num % 10;
                n = n * 10 + remainder;
                if ((n - remainder) / 10 != p) {
                    return 0;
                }
                p = n;
                num = num / 10;
            }
            return n;
        }
    }

    @Test
    void testReverse() {
        Solution solution = new Solution();
        int actual = solution.reverse(123);
        assertEquals(321, actual);
        actual = solution.reverse(-123);
        assertEquals(-321, actual);
    }
}

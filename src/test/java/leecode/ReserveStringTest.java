package leecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ReserveStringTest {
    class Solution {
        public void reverseString(char[] s) {
            exchange(0, s.length-1, s);
        }

        private void exchange(int l, int r, char[] s) {
           if (l >= r) {
               return;
           }
           char t = s[l];
           s[l] = s[r];
           s[r] = t;
           exchange(++l, --r, s);
        }
    }

    @Test
    void testReserveString() {
        Solution s = new Solution();
        char[] array = new char[]{'h','e','l','l','o'};
        s.reverseString(array);
        assertArrayEquals(new char[]{'o','l','l','e','h'}, array);
    }
}



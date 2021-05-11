package leecode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqCharTest {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> count = new HashMap<>();
            int len = s.length();
            for (int i=0; i < len; ++i) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            for (int i=0; i < len; ++i) {
                if (count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }

    @Test
    void testFirstUniqChar(){
        Solution solution = new Solution();
        int actual = solution.firstUniqChar("leetcode");
        assertEquals(0, actual);
    }
}

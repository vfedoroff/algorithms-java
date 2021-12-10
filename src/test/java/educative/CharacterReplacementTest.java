package educative;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterReplacementTest {
    public static int findLength(String str, int k) {
        int len = str.length();
        int left = 0;
        int count = 0;
        int maxLength = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int right=0; right < len; ++right) {
            Character c = str.charAt(right);
            freq.merge(c, 1, Integer::sum);
            count = Math.max(count, freq.get(c));
            if (right - left + 1 - count > k) {
                char leftChar = str.charAt(left);
                freq.merge(leftChar, -1, Integer::sum);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    @Test
    void testFindLength(){
        assertEquals(5, findLength("aabccbb",2));
        assertEquals(4, findLength("abbcb",1));
        assertEquals(3, findLength("abccde",1));
    }
}

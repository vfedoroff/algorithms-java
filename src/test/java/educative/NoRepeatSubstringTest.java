package educative;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoRepeatSubstringTest {
    public static int findLength(String str) {
        int len = str.length();
        int windowStart = 0;
        int maxLength = 0;
        Set<Character> freq = new HashSet<>();
        for (int windowEnd=0; windowEnd < len; ++windowEnd){
            char c = str.charAt(windowEnd);
            if (freq.contains(c)) {
                // Window ends;
                windowStart = windowEnd;
                freq.remove(c);
            }
            freq.add(c);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    @Test
    void testFindLength(){
        assertEquals(3, findLength("aabccbb"));
        assertEquals(2, findLength("abbbb"));
        assertEquals(3, findLength("abccde"));
    }
}

package educative;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringKDistinctTest {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0)
            throw new IllegalArgumentException();

        Set<Character> distinctCharacters = new HashSet<>();

        int windowStart = 0, maxLength = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char right = str.charAt(windowEnd);
            distinctCharacters.add(right);
            while (distinctCharacters.size() > k) {
                char left = str.charAt(windowStart);
                distinctCharacters.remove(left);
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    @Test
    void testFindLength(){
        assertEquals(4, findLength("araaci", 2));
        assertEquals(2, findLength("araaci", 1));
        assertEquals(5, findLength("cbbebi", 3));
        assertEquals(6, findLength("cbbebi", 10));
    }
}

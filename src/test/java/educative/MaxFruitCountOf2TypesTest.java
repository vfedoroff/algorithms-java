package educative;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxFruitCountOf2TypesTest {
    public static int findLength(char[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        Set<Character> distinctCharacters = new HashSet<>();

        int windowStart = 0, maxLength = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            char right = arr[windowEnd];
            distinctCharacters.add(right);
            while (distinctCharacters.size() > 2) {
                char left = arr[windowStart];
                distinctCharacters.remove(left);
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    @Test
    void testFindLength(){
        assertEquals(3, findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        assertEquals(5, findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}

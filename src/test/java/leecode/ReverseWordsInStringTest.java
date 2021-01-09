package leecode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInStringTest {
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] arr = s.split(" ");
            List<String> list = Arrays.stream(arr).map(x->x.trim()).filter(x->x.length() > 0).collect(Collectors.toList());
            Collections.reverse(list);
            return String.join(" ", list);
        }
    }

    @Test
    void testReverseWords(){
        Solution solution = new Solution();
        String actual = solution.reverseWords("the sky is blue");
        assertEquals("blue is sky the", actual);
        actual = solution.reverseWords("a good   example");
        assertEquals("example good a", actual);
    }
}

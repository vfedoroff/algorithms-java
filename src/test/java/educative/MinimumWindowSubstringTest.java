package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MinimumWindowSubstringTest {
    public static String findSubstring(String str, String pattern) {
        Map<Character,Integer> dic = new HashMap<>();
        // Big O = N
        for (char c :pattern.toCharArray()) {
            dic.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int minLength = str.length() + 1;
        int matched = 0;
        int subStrStart = 0;
        for (int right = 0; right < str.length(); ++right){
            char c = str.charAt(right);
            if (dic.containsKey(c)) {
                    dic.merge(c, -1, Integer::sum);
                if (dic.get(c) >= 0) {
                    ++matched;
                }
            }

           while (matched == pattern.length()) {
               if (minLength > right - left + 1) {
                   minLength = right - left + 1;
                   subStrStart = left;
               }
               char leftChar = str.charAt(++left);
               if (dic.containsKey(leftChar)) {
                   if (dic.get(leftChar) == 0)
                       matched--;
                   dic.merge(leftChar, 1, Integer::sum);
               }
           }
        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    @Test
    void testFindSubstring(){
        String actual = findSubstring("aabdec","abc");
        Assertions.assertEquals("abdec", actual);
    }
}

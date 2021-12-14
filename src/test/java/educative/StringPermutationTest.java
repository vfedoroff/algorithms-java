package educative;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringPermutationTest {
    public static boolean findPermutation(String str, String pattern) {
        int left = 0;
        char[] characters = pattern.toCharArray();
        Arrays.sort(characters);
        pattern = String.valueOf(characters);
        for (int right = 0; right < str.length(); ++right){
            if (right - left +1 == pattern.length()){
                str.getChars(left, right+1, characters, 0);
                Arrays.sort(characters);
                String subStr = String.valueOf(characters);
                if (subStr.equals(pattern)) {
                    return true;
                }
                ++left;
            }
        }
        return false;
    }

    @Test
    void testFindLength(){
        assertEquals(true, findPermutation("oidbcaf","abc"));
        assertEquals(false, findPermutation("odicf","dc"));
        assertEquals(true, findPermutation("bcdxabcdy","bcdyabcdx"));
        assertEquals(true, findPermutation("aaacb","abc"));
    }
}

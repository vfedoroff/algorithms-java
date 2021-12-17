package educative;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringAnagramsTest {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int len = str.length();
        int left = 0;
        char[] characters = pattern.toCharArray();
        Arrays.sort(characters);
        pattern = String.valueOf(characters);
        for (int right =0; right < len; ++right) {
            if (right - left +1 == pattern.length()){
                str.getChars(left, right+1, characters, 0);
                Arrays.sort(characters);
                String subStr = String.valueOf(characters);
                if (subStr.equals(pattern)) {
                    resultIndices.add(left);
                }
                ++left;
            }
        }
        return resultIndices;
    }

    @Test
    void testFindStringAnagrams(){
        List<Integer> actual = findStringAnagrams("ppqp", "pq");
        assertArrayEquals(new int[]{1, 2}, actual.stream().mapToInt(i->i).toArray());
        actual = findStringAnagrams("ppqp", "pq");
        assertArrayEquals(new int[]{1, 2}, actual.stream().mapToInt(i->i).toArray());
    }
}

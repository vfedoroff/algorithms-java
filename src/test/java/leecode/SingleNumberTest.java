package leecode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> freq = Arrays.stream(nums).boxed().collect(
                    Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
            Map.Entry<Integer, Integer> result =
                    freq.entrySet().stream().filter(m -> m.getValue().equals(1)).findAny().get();
            return result.getKey();
        }
    }

    @Test
    void testSingleNumber() {
        Solution solution = new Solution();
        int actual = solution.singleNumber(new int[] {2, 2, 1});
        assertEquals(1, actual);
        actual = solution.singleNumber(new int[] {4, 1, 2, 1, 2});
        assertEquals(4, actual);
        actual = solution.singleNumber(new int[] {1});
        assertEquals(1, actual);
    }
}

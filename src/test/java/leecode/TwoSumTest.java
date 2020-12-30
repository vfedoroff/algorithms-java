package leecode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> elements = new HashMap<>();
            for (int i=0; i < nums.length; i++) {
                int reminder = target - nums[i];
                if (elements.containsKey(reminder)) {
                    return new int[]{elements.get(reminder), i};
                }
                elements.put(nums[i], i);
            }
            return new int[]{};
        }
    }

    @Test
    void testTwoSum(){
        Solution solution = new Solution();
        int[] actual = solution.twoSum(new int[]{2,7,11,15},9);
        assertArrayEquals(new int[]{0,1},actual);
        actual = solution.twoSum(new int[]{3,2,4},6);
        assertArrayEquals(new int[]{1,2},actual);
        actual = solution.twoSum(new int[]{3,3},6);
        assertArrayEquals(new int[]{0,1},actual);
    }
}

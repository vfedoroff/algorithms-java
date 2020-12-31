package leecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {
    class Solution {
        public int maxSubArray(int[] nums) {
            int currentSum = nums[0];
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++ ){
                currentSum = Math.max(nums[i], currentSum + nums[i]);
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }
    }

    @Test
    void testMaxSubArray(){
        Solution solution = new Solution();
        int actual = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        assertEquals(6, actual);
    }
}

package leecode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MoveZerosTest {
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i=0; i < nums.length; ++i){
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    ++j;
                }
            }
            for (int i=j; i < nums.length; ++i){
                nums[i] = 0;
            }
        }
    }

    @Test
    void testMoveZeroes(){
        Solution s = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        int[] expected = new int[]{1,3,12,0,0};
        s.moveZeroes(nums);
        Assert.assertArrayEquals(expected, nums);
        nums = new int[]{0};
        expected = new int[]{0};
        s.moveZeroes(nums);
        Assert.assertArrayEquals(expected, nums);
    }
}

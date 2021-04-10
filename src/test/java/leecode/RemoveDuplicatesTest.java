package leecode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesTest {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }
            int i = 0;
            for(int j = 1; j < nums.length; ++j) {
                if (nums[i] != nums[j]) {
                    ++i;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }

    @Test
    void testRemoveDuplicates(){
        Solution solution = new Solution();
        int actual = solution.removeDuplicates(new int[]{1,1,2});
        assertEquals(2, actual);
    }
}

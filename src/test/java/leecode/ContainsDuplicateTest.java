package leecode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsDuplicateTest {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> dic = new HashSet<>();
            for (int i = 0; i < nums.length; i++){
                if (! dic.add(nums[i])) {
                    return true;
                }
            }
            return false;
        }
    }


    @Test
    void testContainsDuplicate(){
        Solution solution = new Solution();
        boolean actual = solution.containsDuplicate(new int[]{1,2,3,1});
        assertEquals(true, actual);
        actual = solution.containsDuplicate(new int[]{1,2,3,4});
        assertEquals(false, actual);
        actual = solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
        assertEquals(true, actual);
    }
}

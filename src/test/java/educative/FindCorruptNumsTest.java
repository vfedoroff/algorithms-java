package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindCorruptNumsTest {
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return new int[] { nums[i], i + 1 };
        return new int[] { -1, -1 };
    }

    private static void swap(int[] nums, int  i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    void testFindNumbers(){
       Assertions.assertArrayEquals(new int[]{2,4},findNumbers(new int[]{3, 1, 2, 5, 2}));;
    }
}

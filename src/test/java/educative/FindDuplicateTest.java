package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindDuplicateTest {
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if (nums[i] != i + 1) {
                int j = nums[i]-1;
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    @Test
    void testFindNumber(){
        Assertions.assertEquals(4, findNumber(new int[]{1, 4, 4, 3, 2}));
    }
}

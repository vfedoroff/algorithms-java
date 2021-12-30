package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MissingNumberTest {
    public static int findMissingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i < nums.length; ++i) {
            if (nums[i] != i ){
                return i;
            }
        }
        return -1;
    }

    @Test
    void testFindMissingNumber(){
        Assertions.assertEquals(2, findMissingNumber(new int[]{4, 0, 3, 1}));
        Assertions.assertEquals(7, findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}

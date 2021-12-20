package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairWithTargetSumTest {

    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair
            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }

    @Test
    void testSearch(){
        Assertions.assertArrayEquals(new int[]{1,3}, search(new int[]{1, 2, 3, 4, 6}, 6));
    }
}

package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TripletSumCloseToTargetTest {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int diff = targetSum - arr[i] - arr[left] - arr[right];
                if (diff == 0) //  we've found a triplet with an exact sum
                    return targetSum;
                smallestDifference = Math.min(Math.abs(diff), Math.abs(smallestDifference));
                if (diff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }
        }
        return targetSum-smallestDifference;
    }

    @Test
    void testSearchTriplet(){
        Assertions.assertEquals(3, searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}

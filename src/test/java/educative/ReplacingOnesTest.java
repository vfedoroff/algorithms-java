package educative;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Given an array containing 0s and 1s,
// if you are allowed to replace no more than ‘k’ 0s with 1s,
// find the length of the longest contiguous subarray having all 1s.
public class ReplacingOnesTest {
    public static int findLength(int[] arr, int k) {
        int left = 0;
        int maxOnesCount = 0;
        int maxLength = 0;
        for (int right=0; right < arr.length; right++) {
            if (arr[right] == 1) {
                ++maxOnesCount;
            }
            if (right - left + 1 + maxOnesCount > k) {
                if (arr[left] == 1) {
                    --maxOnesCount;
                }
                ++left;
            }
            maxLength = Math.max(maxLength, left - right +1 );
        }
        return maxLength;
    }


    @Test
    void testFindLength(){
        assertEquals(5, findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2));
        assertEquals(4, findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
    }
}

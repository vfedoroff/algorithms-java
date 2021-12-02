package educative;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinSizeSubArraySumTest {

    //Given an array of positive numbers and a positive number ‘S,’
    // find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
    // Return 0 if no such subarray exists.
    public static int findMinSubArray(int S, int[] arr) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd=0; windowEnd < arr.length; ++windowEnd) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                // let's shrink the sliding window
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    @Test
    void testFindMinSubArray(){
        int[] input = new int[] {2, 1, 5, 2, 3, 2};
        int s = 7;
        int expected = 2;
        int actual = findMinSubArray(s, input);
        assertEquals(expected, actual);
    }
}

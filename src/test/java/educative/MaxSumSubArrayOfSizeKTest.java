package educative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MaxSumSubArrayOfSizeKTest {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int maxSum = 0;
    int windowSum = 0;
    int windowStart = 0;
    for (int i=0; i < arr.length; i++) {
      windowSum += arr[i];
      if (i >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart]; // subtract the element going out
        windowStart++; // slide the window ahead
      }
    }
    return maxSum;
  }

  @Test
  void testFindMaxSumSubArray() {
    int[] arr = new int[] {2, 1, 5, 1, 3, 2};
    int k = 3;
    int actual = findMaxSumSubArray(k, arr);
    assertEquals(9, actual);
  }
}

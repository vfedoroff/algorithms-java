package educative;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FindSumTest {

  public static int[] findSum(int[] arr, int n) {
    Map<Integer, Integer> map = new HashMap<>();
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      int complement = n - arr[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), arr[i]};
      }
      map.put(arr[i], arr[i]);
    }
    // In case there is no solution, we'll just return null
    return new int[] {};
  }

  @Test
  void testFindSum() {
    int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
    int value = 27;
    int[] actual = findSum(arr, value);
    assertTrue(
        Arrays.equals(new int[] {21, 6}, actual) || Arrays.equals(new int[] {6, 21}, actual));
  }

}

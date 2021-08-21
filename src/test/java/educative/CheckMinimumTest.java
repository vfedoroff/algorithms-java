package educative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CheckMinimumTest {
  public static int findMinimum(int[] arr) {
    Arrays.sort(arr);
    return arr[0];
  }

  @Test
  void testFindMinimum() {
    int actual = findMinimum(new int[] {9, 2, 3, 6});
    int expected = 2;
    assertEquals(expected, actual);
  }
}

package educative;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class ProductArrayTest {
  public static int[] findProduct(int arr[]) {
    int length = arr.length;
    int[] l = new int[length];
    int[] r = new int[length];
    int[] result = new int[length];
    l[0] = 1;
    for (int i = 1; i < length; i++) {
      l[i] = arr[i - 1] * l[i - 1];
    }
    r[length - 1] = 1;
    for (int i = length - 2; i >= 0; i--) {
      r[i] = arr[i + 1] * r[i + 1];
    }
    for (int i = 0; i < length; i++) {
      result[i] = l[i] * r[i];
    }
    return result;
  }

  @Test
  void testFindProduct() {
    int[] expected = new int[] {24, 12, 8, 6};
    int[] actual = findProduct(new int[] {1, 2, 3, 4});
    assertArrayEquals(expected, actual);
  }
}

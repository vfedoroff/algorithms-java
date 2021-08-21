package educative;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class CheckMergeArrayTest {
  public static int[] mergeArrays(int[] arr1, int[] arr2) {
    int l1 = arr1.length;
    int l2 = arr2.length;
    int size = l1 + l2;
    int i = 0;
    int j = 0;
    int k = 0;
    int[] out = new int[size];
    while (i < l1 && j < l2) {
      int a = arr1[i];
      int b = arr2[j];
      if (a < b) {
        out[k++] = a;
        ++i;
      } else {
        out[k++] = b;
        ++j;
      }
    }
    while (i < l1)
      out[k++] = arr1[i++];
    // Store remaining elements of second array
    while (j < l2)
      out[k++] = arr2[j++];
    return out;
  }

  @Test
  void testMergeArrays() {
    int[] arr1 = new int[] {1, 3, 4, 5};
    int[] arr2 = new int[] {2, 6, 7, 8};
    int[] actual = mergeArrays(arr1, arr2);
    assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, actual);
  }
}

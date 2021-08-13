package educative;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.LinkedList;

public class CheckRemoveEvenTest {
  public static int[] removeEven(int[] arr) {
    List<Integer> output = new LinkedList<>();
    int len = arr.length;
    for (int i = 0; i < len; ++i) {
      if (arr[i] % 2 != 0) {
        output.add(arr[i]);
      }
    }
    int size = output.size();
    arr = new int[output.size()];
    for (int i = 0; i < size; ++i) {
      arr[i] = output.get(i);
    }
    return arr;
  }

  @Test
  void testRemoveEven() {
    int[] arr = new int[] {1, 2, 4, 5, 10, 6, 3};
    int[] actual = removeEven(arr);
    assertArrayEquals(new int[] {1, 5, 3}, actual);
  }
}

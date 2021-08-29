package educative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CheckFirstUniqueTest {

  public static int findFirstUnique(int[] arr) {
    Map<Integer, Integer> freq = new LinkedHashMap<Integer, Integer>();
    for (int i : arr) {
      freq.merge(i, 1, Integer::sum);
    }
    Set<Map.Entry<Integer, Integer>> set = freq.entrySet();
    for (Map.Entry<Integer, Integer> entry : set) {
      if (entry.getValue().equals(1)) {
        return entry.getKey();
      }
    }
    return -1;
  }

  @Test
  void testFindFirstUnique() {
    int[] arr = {9, 2, 3, 2, 6, 6};
    int actual = findFirstUnique(arr);
    assertEquals(9, actual);
  }

}

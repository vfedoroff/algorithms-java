package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTest {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    @Test
    void test(){
        List<List<Integer>> actual = findSubsets(new int[]{1,3});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(1,3));
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertArrayEquals(expected.get(0).toArray(Integer[]::new), actual.get(0).toArray(Integer[]::new));
        Assertions.assertArrayEquals(expected.get(1).toArray(Integer[]::new), actual.get(1).toArray(Integer[]::new));
    }
}

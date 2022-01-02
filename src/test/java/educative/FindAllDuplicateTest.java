package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateTest {

    public static List<Integer> findNumbers(int[] nums) {
        // Sort array
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> duplicateNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        }

        return duplicateNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    void testFindNumbers() {
        Assertions.assertArrayEquals(new int[]{4, 5}, findNumbers(new int[]{3, 4, 4, 5, 5}).stream().mapToInt(Integer::intValue).sorted().toArray());
    }
}

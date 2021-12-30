package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicSortTest {
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    void testSort(){
        int[] arr = new int[]{3, 1, 5, 4, 2};
        sort(arr);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}

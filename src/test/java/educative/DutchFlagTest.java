package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DutchFlagTest {
    public static void sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        for (int i = 0; i <= right;) {
            if (arr[i]==0) {
                swap(arr, i, left);
                i++;
                left++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, right);
                // decrement 'right' only, after the swap the number at index 'i' could be 0, 1 or 2
                right--;
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    void testSort(){
        int[] input = new int[]{1, 0, 2, 1, 0};
        sort(input);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2}, input);
    }

}

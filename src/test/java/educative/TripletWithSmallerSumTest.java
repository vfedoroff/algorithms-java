package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TripletWithSmallerSumTest {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        int left = 0;
        int right = arr.length-1;
        Arrays.sort(arr);
        //arr[i] + arr[j] + arr[k] < target
        for (int i = 0; i < arr.length-2; ++i){
            left = i + 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] < target) {
                    count += right - left;
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return count;
    }

    @Test
    void testSearchTriplets(){
        Assertions.assertEquals(2, searchTriplets(new int[]{-1, 0, 2, 3},3));
    }
}

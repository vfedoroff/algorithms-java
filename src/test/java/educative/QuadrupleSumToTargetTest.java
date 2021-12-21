package educative;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTargetTest {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++){
            // let find first
            if (i > 0 && arr[i] == arr[i+1]) {
                continue;
            }
            int first = i;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > 0 && arr[j] == arr[j-1]) {
                    continue;
                }
                int second = j;
                int left = second + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[first] + arr[second] + arr[left] + arr[right];
                    if (sum == target) { // found the quadruplet
                        quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1])
                            left++; // skip same element to avoid duplicate quadruplets
                        while (left < right && arr[right] == arr[right + 1])
                            right--; // skip same element to avoid duplicate quadruplets
                    } else if (sum < target)
                        left++; // we need a pair with a bigger sum
                    else
                        right--; // we need a pair with a smaller sum
                }
            }
        }
        return quadruplets;
    }

    @Test
    void testSearchQuadruplets(){
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3},1));
    }
}

package educative;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int left = 0;
        int product = 1;
        for (int right = 0; right < arr.length; right++){
            product *= arr[right];
            while (product >= target && left < arr.length){
                product /= arr[left++];
            }
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                subarrays.add(new ArrayList<>(tempList));
            }
        }
        return subarrays;
    }

    @Test
    void testFindSubarrays(){
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        //System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}

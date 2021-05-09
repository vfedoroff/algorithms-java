package leecode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> dic = new HashMap<>();
            int[] shortArray;
            int[] longArray;
            if (nums1.length < nums2.length) {
                shortArray = nums1;
                longArray = nums2;
            } else {
                shortArray = nums2;
                longArray = nums1;
            }
            for (int n : shortArray) {
                dic.put(n, dic.getOrDefault(n, 0) + 1);
            }
            ArrayList<Integer> output = new ArrayList<>();
            for (int n : longArray) {
                int cnt = dic.getOrDefault(n, 0);
                if (cnt > 0) {
                    output.add(n);
                    dic.put(n, cnt - 1);
                }
            }
            return output.stream().mapToInt(i -> i).toArray();
        }
    }

    @Test
    void testIntersect(){
        Solution solution = new Solution();
        int[] actual = solution.intersect(new int[]{1,2,2,1}, new int[]{2,2});
        int[] expected = new int[]{2,2};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assert.assertArrayEquals(expected, actual);
        expected = new int[]{9,4};
        Arrays.sort(expected);
        actual = solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        Arrays.sort(actual);
        Assert.assertArrayEquals(expected, actual);
        expected = new int[]{1};
        Arrays.sort(expected);
        actual = solution.intersect(new int[]{1,2}, new int[]{1,1});
        Arrays.sort(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}

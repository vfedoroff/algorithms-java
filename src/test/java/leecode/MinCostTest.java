package leecode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinCostTest {
    public int minCost(String colors, int[] neededTime) {
        int len = colors.length();
        if (len != neededTime.length) {
            return 0;
        }
        if (len == 1) {
            return neededTime[0];
        }
        int result = 0;
        for(int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i-1) == colors.charAt(i)) {
                int costLeft = neededTime[i-1];
                int costRight = neededTime[i];
                int min = Math.min(costLeft, costRight);
                int max = Math.max(costLeft, costRight);
                neededTime[i] = max;
                result = result + min;
            }
        }
        return result;
    }

    @Test
    void testMinCost(){
        Assertions.assertEquals(3, minCost("abaac", new int[]{1,2,3,4,5}));
        Assertions.assertEquals(0, minCost("abc", new int[]{1,2,3}));
        Assertions.assertEquals(2, minCost("aabaa", new int[]{1,2,3,4,1}));
        Assertions.assertEquals(26, minCost("aaabbbabbbb",new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }
}

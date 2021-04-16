package leecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockIITest {
    class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 1; i < prices.length; ++i) {
                result += Math.max(0, prices[i] - prices[i-1]);
            }
            return result;
        }
    }

    @Test
    void testMaxProfit(){
        Solution solution = new Solution();
        int actual = solution.maxProfit(new int[]{7,1,5,3,6,4});
        assertEquals(7, actual);
        actual = solution.maxProfit(new int[]{1,2,3,4,5});
        assertEquals(4, actual);
        actual = solution.maxProfit(new int[]{7,6,4,3,1});
        assertEquals(7, actual);
    }
}

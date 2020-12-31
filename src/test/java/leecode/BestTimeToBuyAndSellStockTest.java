package leecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {
    class Solution {
        public int maxProfit(int[] prices) {
            int valley = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i=0; i < prices.length; i++) {
                if (prices[i] < valley) {
                    valley = prices[i];
                }
                if (prices[i] - valley > maxProfit) {
                    maxProfit = prices[i] - valley;
                }
            }
            return maxProfit;
        }
    }

    @Test
    void testMaxProfit(){
        Solution solution = new Solution();
        int actual = solution.maxProfit(new int[]{7,1,5,3,6,4});
        assertEquals(5, actual);
        actual = solution.maxProfit(new int[]{7,6,4,3,1});
        assertEquals(0, actual);
    }
}

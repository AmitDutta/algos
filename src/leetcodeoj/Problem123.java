package leetcodeoj;

import org.junit.*;

public class Problem123 {
   public int maxProfitRange(int[] prices, int start, int end) {
      int profit = 0, buyIndex = start;
      for (int i = start + 1; i <= end; ++i) {
         if (prices[buyIndex] > prices[i]) {
            buyIndex = i;
         }else {
            profit = Math.max(prices[i] - prices[buyIndex], profit);
         }
      }
      return profit;
   }
   public int maxProfit(int[] prices) {
      if (prices.length == 0) return 0;
      int profit = 0;
      /*for (int k = 0; k < prices.length; k++) {
         profit = Math.max(profit, maxProfitRange(prices, 0, k) + 
               maxProfitRange (prices, k + 1, prices.length - 1));
      }*/
      int[] forward = new int[prices.length];
      int[] backward = new int[prices.length];
      forward[0] = 0;
      int buy = prices[0];
      for (int i = 1; i < prices.length; ++i) {
         buy = Math.min(buy, prices[i]);
         forward[i] = Math.max(forward[i - 1], prices[i] - buy);
      }
      backward[prices.length - 1] = 0;
      int sell = prices[prices.length - 1];
      for (int i = prices.length - 2; i >= 0; --i) {
         sell = Math.max(sell, prices[i]);
         backward[i] = Math.max(backward[i + 1], sell - prices[i]);
      }
      for (int i = 0; i < forward.length; ++i) {
         profit = Math.max(profit, forward[i] + backward[i]); 
      }
      return profit;
   }
   
   //@Test
   public void testMaxProfit1() {
      Assert.assertEquals(13, maxProfit(new int[] {1, 4, 5, 7, 6, 3, 2, 9}));
      //Assert.assertEquals(45, maxProfit(new int[] {5,10,15,20,25,35,45,50}));
   }
   @Test
   public void testMaxProfit2() {
      Assert.assertEquals(2, maxProfit(new int[] {2,1,2,0,1}));
      //Assert.assertEquals(45, maxProfit(new int[] {5,10,15,20,25,35,45,50}));
   }
   @Test
   public void maxProfitTest() {
      Assert.assertEquals(0, maxProfit(new int[] {2, 1}));
      Assert.assertEquals(13, maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
      Assert.assertEquals(17, maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0,9}));
   }
}

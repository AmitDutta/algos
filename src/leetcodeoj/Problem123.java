package leetcodeoj;

import org.junit.*;

public class Problem123 {
   // thinking this problem in terms of index is easier..
   public int maxProfit(int[] prices) {
      if (prices.length == 0) return 0;
      int[] forward = new int[prices.length];
      int[] backward = new int[prices.length];

      int buyIndex = 0;
      forward[0] = 0;
      for (int i = 1; i < prices.length; ++i) {
         if (prices[i] < prices[buyIndex]) {
            buyIndex = i;
         }//else {
            forward[i] = Math.max(forward[i - 1], prices[i] - prices[buyIndex]);
         //}
         
      }

      int sellIndex = prices.length - 1;
      backward[prices.length - 1] = 0;
      for (int i = prices.length - 2; i >= 0; --i) {
         if (prices[i] > prices[sellIndex]) {
            sellIndex = i;
         }//else {
            backward[i] = Math.max(backward[i +  1], prices[sellIndex] - prices[i]);
         //}
      }

      int profit = 0;
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
}

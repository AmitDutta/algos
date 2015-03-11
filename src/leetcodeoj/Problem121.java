package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem121 {
   // O(n^2) is TLE; This technique is cool :)
   public int maxProfit(int[] prices) {
      if (prices.length == 0) {
         return 0;
      }
      int maxProfit, lowestSoFar, highestSofar, tmp;
      tmp = maxProfit = Integer.MIN_VALUE;
      lowestSoFar = highestSofar = prices[0];
      for (int i = 1; i < prices.length; ++i) {
         if (prices[i] > highestSofar) {
            highestSofar = prices[i];
         }else  {
            tmp = highestSofar - lowestSoFar;
            if (tmp > maxProfit) {
               maxProfit = tmp;
            }
            lowestSoFar = highestSofar = prices[i];
         }
      }
      tmp = highestSofar - lowestSoFar;
      if (tmp > maxProfit) {
         maxProfit = tmp;
      }
      return maxProfit;
   }
   
   @Test
   public void maxProfitTest() {
      Problem121 p121 = new Problem121();
      Assert.assertEquals(17, p121.maxProfit(new int[] {
            5,3,10,15,20
      }));
   }
}

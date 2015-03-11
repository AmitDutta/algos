package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem122 {
   public int maxProfit(int[] prices) {
      if (prices.length == 0) {
         return 0;
      }
      int maxProfit, lowestSoFar, highestSofar, tmp;
      tmp = maxProfit = 0;
      lowestSoFar = highestSofar = prices[0];
      for (int i = 1; i < prices.length; ++i) {
         if (prices[i] > highestSofar) {
            highestSofar = prices[i];
         }else if (prices[i] < lowestSoFar) {
            tmp = highestSofar - lowestSoFar;
            maxProfit += tmp;
            lowestSoFar = highestSofar = prices[i];
         }else if (prices[i] >= lowestSoFar &&  prices[i] <= highestSofar) {
            tmp = highestSofar - lowestSoFar;
            maxProfit += tmp;
            lowestSoFar = highestSofar = prices[i];
         }
         // the last block we can do it only with else
      }
      tmp = highestSofar - lowestSoFar;
      maxProfit += tmp;
      return maxProfit;
   }
   
   @Test
   public void maxProfitTest() {
      Problem122 p122 = new Problem122();
      Assert.assertEquals(7, p122.maxProfit(new int[] {
            6,1,3,2,4,7
      }));
   }
}

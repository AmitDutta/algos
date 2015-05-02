package dp;

import org.junit.Assert;
import org.junit.Test;

public class CuttingStick {
   int[] cache;
   public CuttingStick() {
      cache = new int[20];
      for (int i = 0; i < 20; ++i) {
         cache[i] = Integer.MIN_VALUE;
      }
   }
   
   // simple memoized .. top down
   public int cost(int[] profit, int len) {
      if (cache[len] != Integer.MIN_VALUE) {
         return cache[len];
      }
      if (len == 0) {
         cache[len] = 0;
      }
      int cur = 0;
      for (int k = 1; k <= len; ++k) {
         cur = profit[k] + cost(profit, len - k);
         if (cur > cache[len]) {
            cache[len] = cur;
         }
      }
      return cache[len];
   }
   
   // bottom up
   public int cost_botton_up(int[] profit, int len) {
      int[] dp = new int[len + 1];
      boolean[] parts = new boolean[len + 1];
      dp[0] = 0;
      for (int i = 1; i <= len; ++i) {
         dp[i] = profit[i];
      }
      for (int i = 1; i <= len; ++i) {
         for (int k = 1; k <= i; ++k) {
            int other = i - k <= 0 ? 0 : dp[i - k];
            int cost = dp[k] + other;
            if (cost > dp[i]) {
               dp[i] = cost;
               parts[k] = true;
            }
         }
      }
      
      System.out.println("Parts taken:");
      int lastPart = 0;
      for (int i = 0; i < parts.length; ++i) {
         if (parts[i]) {
            System.out.println(i + " ");
            lastPart += i;
         }
      }
      System.out.println(len - lastPart);

      return dp[len];
   }
   
   @Test
   public void costTest1() {
      CuttingStick cs = new CuttingStick();
      int[] revenue = {-1,1,5,8,9,10,17,17,20,24,30};
      Assert.assertEquals(10, cs.cost(revenue, 4));
      Assert.assertEquals(18, cs.cost(revenue, 7));
      Assert.assertEquals(30, cs.cost(revenue, 10));
   }
   
   @Test
   public void costTest2() {
      CuttingStick cs = new CuttingStick();
      int[] revenue = {-1,1,5,8,9,10,17,17,20,24,30};
      Assert.assertEquals(10, cs.cost_botton_up(revenue, 4));
      Assert.assertEquals(18, cs.cost_botton_up(revenue, 7));
      Assert.assertEquals(30, cs.cost_botton_up(revenue, 10));
   }
}

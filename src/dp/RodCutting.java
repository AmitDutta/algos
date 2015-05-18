package dp;
import org.junit.*;

public class RodCutting {
   public int revenue(int[] cost, int n) {
      if (n == 0) {
         return 0;
      }
      int profit = 0;
      for (int i = 1; i <= n; ++i ) {
         profit = Math.max(profit, cost[i - 1] + revenue(cost, n - i));
      }
      return profit;
   }
   public int revenueMemoInt(int[] cost, int[] cache, int n) {
      if (n == 0) {
         cost[n] = 0;
      }
      if (cache[n] != Integer.MIN_VALUE) {
         return cache[n];
      }
      for (int i = 1; i <= n; ++i ) {
         cache[n] = Math.max(cache[n], cost[i - 1] + revenue(cost, n - i));
      }
      return cache[n];
   }
   public int revenueMemo(int[] cost, int n) {
      int[] cache = new int[n + 1];
      for (int i = 0; i <= n; ++i) {
         cache[i] = Integer.MIN_VALUE;
      }
      revenueMemoInt(cost, cache, n);
      return cache[n];
   }
   public int revenueDP(int[] cost, int n) {
      int[] cache = new int[n + 1];
      int[] parts = new int[n + 1];
      for (int i = 1; i <= n; ++i) {
         cache[i] = Integer.MIN_VALUE;
         for (int j = 1; j <= i; ++j) {
            int val = cost[j - 1] + cache[i - j];
            if (val > cache[i]) {
               cache[i] = val;
               parts[i] = j;
            }
            //cache[i] = Math.max(cache[i], cache[j] + cache[i - j]);
         }
      }
      int p = n;
      while (p > 0) {
         System.out.print(parts[p] + " ");
         p = p - parts[p];
      }
      System.out.println();
      return cache[n];
   }
   @Test
   public void revenue1() {
      int[] revenue = {1,5,8,9,10,17,17,20,24,30};
      Assert.assertEquals(10, revenue(revenue, 4));
      Assert.assertEquals(18, revenue(revenue, 7));
      Assert.assertEquals(30, revenue(revenue, 10));
   }
   @Test
   public void revenueMemo1() {
      int[] revenue = {1,5,8,9,10,17,17,20,24,30};
      Assert.assertEquals(10, revenueMemo(revenue, 4));
      Assert.assertEquals(18, revenueMemo(revenue, 7));
      Assert.assertEquals(30, revenueMemo(revenue, 10));
   }
   @Test
   public void revenueMemo2() {
      int[] revenue = {1,5,8,9,10,17,17,20,24,30};
      //Assert.assertEquals(10, revenueDP(revenue, 4));
      Assert.assertEquals(18, revenueDP(revenue, 7));
      //Assert.assertEquals(30, revenueDP(revenue, 10));
   }
}

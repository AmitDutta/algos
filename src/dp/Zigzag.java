package dp;

import org.junit.*;

public class Zigzag {
   private boolean opposite(int a, int b) {
      if (a > 0) return b < 0;
      return b > 0;
   }
   public int zigzag(int[] a) {
      int[] cost = new int[a.length];
      int[] diff = new int[a.length];
      diff[0] = a[0];
      for (int i = 1; i < a.length; ++i) {
         diff[i] = a[i - 1] - a[i];
      }
      for (int i = 0; i < a.length; ++i) {
         cost[i] = 1;
      }
      int max = cost[0];
      for (int i = 1; i < a.length; ++i) {
         for (int k = 0; k < i; ++k) {
            if (opposite(diff[i], diff[k])) {
               cost[i] = Math.max(cost[i], 1 + cost[k]);
            }
         }
         max = Math.max(cost[i], max);
      }
      /*int max = cost[0];
      for (int i = 1; i < cost.length; ++i) {
         max = Math.max(max, cost[i]);
      }*/
      return max;
   }
   
   @Test
   public void test1() {
      Assert.assertEquals(6, zigzag(new int[] {1, 7, 4, 9, 2, 5}));
      Assert.assertEquals(7, zigzag(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
      Assert.assertEquals(1, zigzag(new int[] {44}));
      Assert.assertEquals(2, zigzag(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
      Assert.assertEquals(8, zigzag(new int[] {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}));
   }
}

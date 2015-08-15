package dp;

import org.junit.*;

public class ProductCutting {
/*
 * Problem: Given a rope with length n, how to cut the rope into m parts with 
 * length n[0], n[1], ..., n[m-1], in order to get the maximal product 
 * of n[0]*n[1]* ... *n[m-1]? We have to cut once at least. Additionally, 
 * the length of the whole length of the rope, as well as the length of each 
 * part, are in integer value.

 * For example, if the length of the rope is 8, the maximal product of the part 
 * lengths is 18. In order to get the maximal product, the rope is cut into 
 * three parts with lengths 2, 3, and 3 respectively
 *
 * */
   public int maxCut(int n) {
      if (n == 0) return 1;
      int max = Integer.MIN_VALUE;
      for (int i = 2; i <= n; ++i) {
         int other = i * maxCut(n - i);
         max = Math.max(max, other);
      }
      return max;
   }
   // the base cases are tricky..but the relation is trivial..
   // i.. j.. k
   public int maxCutDP(int n) {
      int[] cost = new int[n + 1];
      cost[0] = 0;
      cost[1] = 1;
      cost[2] = 2;
      cost[3] = 3;
      for (int i = 3; i <= n; ++i) {
         for (int j = 1; j < i; ++j) {
            cost[i] = Math.max(cost[i], cost[j] * cost[i - j]);
         }
      }
      return cost[n];
   }
   @Test
   public void test1() {
      Assert.assertEquals(18, maxCut(8));
      Assert.assertEquals(18, maxCutDP(8));
   }
}

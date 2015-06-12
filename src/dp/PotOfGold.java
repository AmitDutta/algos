package dp;

import org.junit.*;

// http://www.quora.com/Dynamic-Programming-DP/How-do-you-solve-the-pots-of-gold-game
// https://www.youtube.com/watch?v=WxpIHvsu1RI&index=29&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
public class PotOfGold {
   class Pair {
      private int first, second;
      Pair (int first, int second) {
         this.first = first;
         this.second = second;
      }
      public String toString() {
         return "(" + first + "," + second + ")";
      }
   }
   public int profit(int[] items) {
      Pair[][] cost = new Pair[items.length][items.length];
      for (int i = 0; i < items.length; ++i) {
         cost[i][i] = new Pair(items[i], 0);
         if (i < items.length - 1) {
            cost[i][i + 1] = new Pair(Math.max(items[i], items[i + 1]),
                                      Math.min(items[i], items[i + 1]));
         }
      }
      for (int len = 2; len < items.length; ++len) {
         for (int i = 0; i < items.length; ++i) {
            int j = i + len;
            if (j < items.length) {
               int p1 = Math.max(items[i] + cost[i + 1][j].second, 
                                 items[j] + cost[i][j - 1].second);
               int p2 = Math.min(cost[i + 1][j].first, cost[i][j - 1].first);
               cost[i][j] = new Pair(p1, p2);
            }
         }
      }
      return cost[0][items.length - 1].first;
   }
   @Test
   public void test1() {
      Assert.assertEquals(11, profit(new int[]{3,9,1,2}));
   }
}

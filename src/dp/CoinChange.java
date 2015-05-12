package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class CoinChange {
   public List<Integer> getOptimalNumberOfCoins(int sum, int[] coins) {
      int[] cost = new int[sum + 1];
      cost[0] = 0;
      for (int i = 1; i <= sum; ++i) {
         cost[i] = Integer.MAX_VALUE;
         for (int j = 0; j < coins.length; ++j) {
            if (coins[j] <= i) {
               cost[i] = Math.min(cost[i], 1 + cost[i - coins[j]]);
            }
         }
      }
      List<Integer> lst = new ArrayList<Integer>();
      int cur = sum;
      while (cur > 0) {
         int min = 0;
         for (int i = 1; i < coins.length; ++i) {
            if (cost[cur - coins[i]] < cost[cur - coins[min]]) {
               min = i;
            }
         }
         lst.add(coins[min]);
         cur = cur - coins[min];
      }
      return lst;
   }
   @Test
   public void test1() {
      int[] coins = new int[] {1,3,5};
      List<Integer> result = getOptimalNumberOfCoins(7, coins);
      List<Integer> expected = Arrays.asList(1,1,5);
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
   @Test
   public void test2() {
      int[] coins = new int[] {1,3,5};
      List<Integer> result = getOptimalNumberOfCoins(11, coins);
      List<Integer> expected = Arrays.asList(1,5,5);
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
}

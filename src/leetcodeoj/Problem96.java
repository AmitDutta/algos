package leetcodeoj;

import org.junit.*;

public class Problem96 {
   public int numTrees(int n) {
      int[] cost = new int[n + 1];
      cost[0] = cost[1] = 1;
      for (int i = 1; i <= n; ++i) {
         int sum = 0;
         for (int j = 1; j <= i; ++j) {
            sum += cost[j - 1] * cost[i - j];
         }
         cost[i] = sum;
      }
      return cost[n];
   }
   @Test
   public void test1() {
      System.out.println(numTrees(4));
   }
}

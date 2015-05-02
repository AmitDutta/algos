package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem64 {
   public int minPathSum(int[][] grid) {
      int m = grid.length;
      if (m == 0) return 0;
      int n = grid[0].length;
      int[][] cost = new int[m][n];
      cost[0][0] = grid[0][0];
      for (int i = 1; i < m; ++i) {
         cost[i][0] = cost[i - 1][0] + grid[i][0];
      }
      for (int i = 1; i < n; ++i) {
         cost[0][i] = cost[0][i - 1] + grid[0][i];
      }
      for (int i = 1; i < m; ++i) {
         for (int j = 1; j < n; ++j) {
            cost[i][j] = grid[i][j] + Math.min(cost[i - 1][j], cost[i][j- 1]); 
         }
      }
      return cost[m - 1][n - 1];
   }
   
   @Test
   public void minPathSumTest() {
      int[][] arr= {{1,2},{3,4}};
      Assert.assertEquals(7, minPathSum(arr));
   }
}

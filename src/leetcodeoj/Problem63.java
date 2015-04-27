package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;
// And problem 62
// Doing dfs here gave TLE, also a poor idea ..
public class Problem63 {
   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int m = obstacleGrid.length;
      if (m == 0) return 0;
      int n = obstacleGrid[0].length;
      int[][] cost = new int[m][n];
      cost[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
      for (int i = 1; i < m; ++i) {
         cost[i][0] = obstacleGrid[i][0] == 0 ? cost[i - 1][0] : 0;
      }
      for (int i = 1; i < n; ++i) {
         cost[0][i] = obstacleGrid[0][i] == 0 ? cost[0][i - 1] : 0;
      }
      for (int i = 1; i < m; ++i) {
         for (int j = 1; j < n; ++j) {
            cost[i][j] = obstacleGrid[i][j] == 0 ?
                         cost[i - 1][j] + cost[i][j - 1] : 0;
         }
      }
      return cost[m - 1][n - 1];
   }

   public int uniquePaths(int m, int n) {
      int[][] mat = new int[m][n];
      return uniquePathsWithObstacles(mat);
   }

   @Test
   public void uniquePathsTest1() {
      Assert.assertEquals(2, uniquePaths(2,2));
      Assert.assertEquals(6, uniquePaths(3,3));
   }

   @Test
   public void uniquePathsWithObstaclesTest1() {
      Assert.assertEquals(0, uniquePathsWithObstacles(new int[][]{}));
      Assert.assertEquals(0, uniquePathsWithObstacles(new int[][]{{1}}));
      Assert.assertEquals(0, uniquePathsWithObstacles(new int[][]{{1,0}}));
      Assert.assertEquals(0, uniquePathsWithObstacles(new int[][]{{0,1}}));
   }
   
   @Test
   public void uniquePathsWithObstaclesTest2() {
      Assert.assertEquals(2, uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
      Assert.assertEquals(7, uniquePathsWithObstacles(new int[][]{
            {0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}}));
   }
}

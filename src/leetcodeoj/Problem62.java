package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;

// This was tle, see problem 63.java
public class Problem62 {
   private int m, n;
   private boolean[][] visited;
   private int[][] grid;
   private int paths;
   private class Pair {
      int x,y;
      public Pair(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   private boolean isInRange(int i, int j) {
      boolean inRange = true;
      if (i < 0 || i >= m) inRange = false;
      if (j < 0 || j >= n) inRange = false;
      return inRange;
   }
   private List<Pair> getNeighbours(int i, int j) {
      List<Pair> neighbour = new ArrayList<Pair>();
      if (isInRange(i, j + 1)) neighbour.add(new Pair(i, j + 1));
      if (isInRange(i + 1, j)) neighbour.add(new Pair(i + 1, j));
      return neighbour;
   }
   private void dfs(int i, int j) {
      if (grid[i][j] == 1) {
         return;
      }
      if (i == m - 1 && j == n - 1) {
         paths++;
         return;
      }
      visited[i][j] = true;
      List<Pair> children = getNeighbours(i, j);
      for (Pair child : children) {
         if (grid[child.x][child.y] != 1 && !visited[child.x][child.y]) {
            dfs(child.x, child.y);
         }
      }
      visited[i][j] = false;
   }
   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      grid = obstacleGrid;
      m = obstacleGrid.length;
      if (m == 0) return 0;
      n = obstacleGrid[0].length;
      if (obstacleGrid[m - 1][n - 1] == 1) {
         return 0; // early return
      }
      visited = new boolean[m][n];
      paths = 0;
      dfs(0, 0);
      return paths;
   }
   
   public int uniquePaths(int m, int n) {
      int[][] grid  = new int[m][n];
      return uniquePathsWithObstacles(grid);
   }

   @Test
   public void uniquePathsWithObstaclesTest1() {
      int[][] grid = {{0,0,0},
                      {0,1,0},
                      {0,0,0}};
      Assert.assertEquals(2, uniquePathsWithObstacles(grid));
   }
   
   @Test
   public void uniquePathsWithObstaclesTest2() {
      int[][] grid = {};
      Assert.assertEquals(0, uniquePathsWithObstacles(grid));
   }

   @Test
   public void uniquePathsWithObstaclesTest3() {
      int[][] grid = {{1}};
      Assert.assertEquals(0, uniquePathsWithObstacles(grid));
      Assert.assertEquals(0, uniquePathsWithObstacles(new int[][] {{1, 0}}));
   }
   
   @Test
   public void uniquePathsWithObstaclesTest4() {
      int[][] grid = {{0,0,0},
                      {0,1,0},
                      {0,0,1}};
      Assert.assertEquals(0, uniquePathsWithObstacles(grid));
   }

   @Test
   public void uniquePathsWithObstaclesTest5() {
      int[][] grid = {{0,0,0,0},
                      {0,1,0,0},
                      {0,0,0,0},
                      {0,0,1,0},
                      {0,0,0,0}};
      Assert.assertEquals(7, uniquePathsWithObstacles(grid));
   }
}

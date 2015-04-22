package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Problem200 {
   private boolean visited[][];
   private char[][] graph;
   private int connected = 0, m, n;
   private class Pair {
      int x;
      int y;
      public Pair (int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   
   private boolean isInRange(int x, int y) {
      if (x < 0 || x >= m) return false;
      if (y < 0 || y >= n) return false;
      return true;
   }
   
   private List<Pair> getNeighbours(int x, int y) {
      List<Pair> neighbours = new ArrayList<Pair>();
      if (isInRange(x - 1, y)) neighbours.add(new Pair(x -1, y));
      if (isInRange(x, y + 1)) neighbours.add(new Pair(x, y + 1));
      if (isInRange(x + 1, y)) neighbours.add(new Pair(x + 1, y));
      if (isInRange(x, y - 1)) neighbours.add(new Pair(x, y - 1));
      return neighbours;
   }

   private void dfs(int x, int y) {
      visited[x][y] = true;
      for (Pair neighbour : getNeighbours(x, y)) {
         if (graph[neighbour.x][neighbour.y] == '1' && !visited[neighbour.x][neighbour.y]) {
            dfs(neighbour.x, neighbour.y);
         }
      }
   }

   public int numIslands(char[][] grid) {
     if (grid.length == 0) return connected;
     m = grid.length;
     n = grid[0].length;
     visited = new boolean[m][n];
     graph = grid;
     for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
           if (grid[i][j] == '1' && !visited[i][j]) {
              connected++;
              dfs(i, j);
           }
        }
     }
     return connected;
  }

  @Test
   public void numIslandsTest1() {
      Problem200 p200 = new Problem200();
      char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
      Assert.assertEquals(1, p200.numIslands(grid1));
   }
   
   @Test
   public void numIslandsTest2() {
      Problem200 p200 = new Problem200();
      char[][] grid1 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
      Assert.assertEquals(3, p200.numIslands(grid1));
   }
   
   @Test
   public void numIslandsTes3() {
      Problem200 p200 = new Problem200();
      char[][] grid1 = {};
      Assert.assertEquals(0, p200.numIslands(grid1));
   }
}

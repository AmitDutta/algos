package dp;

import org.junit.*;

// http://karmaandcoding.blogspot.com/2012/02/house-coloring-with-red-blue-and-green.html
public class HouseColoring {
   public int colorcost(int[][] cost) {
      int[][] mat = new int[cost.length][cost[0].length];
      for (int i = 0; i < cost[0].length; ++i) {
         mat[0][i] = cost[0][i];
      }
      for (int i = 1; i < cost.length; ++i) {
         for (int j = 0; j < cost[0].length; ++j) {
            int val = Integer.MAX_VALUE;
            for (int k = 0; k < cost[0].length; ++k) {
               if (k != j) {
                  val = Math.min(val, mat[i - 1][k]);
               }
            }
            mat[i][j] = cost[i][j] + val;
         }
      }
      int result = mat[cost.length - 1][0];
      for (int k = 1; k < cost[0].length; ++k) {
         result = Math.min(result, mat[cost.length - 1][k]);
      }
      return result;
   }
   @Test
   public void test1() {
      int[][] colors = {{7,5,10},{3,6,1},{8,7,4},{6,2,9},{1,4,7},{2,3,6}};
      Assert.assertEquals(18, colorcost(colors));
   }
}

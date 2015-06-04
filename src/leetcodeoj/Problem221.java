package leetcodeoj;
import org.junit.*;

public class Problem221 {
   public int maximalSquare(char[][] matrix) {
      // https://www.youtube.com/watch?v=_Lf1looyJMU
      if(matrix.length == 0) return 0;
      int[][] cost = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; ++i) {
         cost[i][0] = matrix[i][0] - '0';
      }
      for (int i = 0; i < matrix[0].length; ++i) {
         cost[0][i] = matrix[0][i] - '0';
      }
      for (int i = 1; i < matrix.length; ++i) {
          for (int j = 1; j < matrix[0].length; ++j) {
              if (matrix[i][j] == '0') {
                  cost[i][j] = 0;
              } else {
                  cost[i][j] = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1])) + 1;
              }
          }
      }
      int max = 0;
      for (int i = 0; i < cost.length; ++i) {
          for (int j = 0; j < cost[0].length; ++j) {
              max = Math.max(max, cost[i][j]);
          }
      }
      return max * max;
   }
   @Test
   public void test1() {
      char[][] a = {{'1','1'}, {'1','1'}};
      Assert.assertEquals(4, maximalSquare(a));
   }
   
}

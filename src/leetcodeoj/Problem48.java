package leetcodeoj;

import org.junit.Test;
public class Problem48 {
   public void rotate(int[][] matrix) {
      // can be done in 2 for loop. but transpose and reverting rows looked easy to me
      // http://yucoding.blogspot.com/2013/05/leetcode-question-88-rotate-image.html
      int n = matrix.length - 1;
      for (int i = 0; i <= n; ++i) {
         for (int j = i + 1; j <= n; ++j) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = tmp;
         }
      }
      for (int i = 0; i <= n; ++i) {
         for (int j = 0; j <= n; ++j) {
            if (j <= n/2) {
               int tmp = matrix[i][n - j];
               matrix[i][n - j] = matrix[i][j];
               matrix[i][j] = tmp;
            }
         }
      }
   }
   @Test
   public void rotateTest() {
      int[][] arr = {{1,2},
                     {4,5}};
      rotate(arr);
      for (int i = 0; i < arr.length; ++i) {
         for (int j = 0; j < arr.length; ++j) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }
}

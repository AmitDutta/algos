package leetcodeoj;

import org.junit.Test;

public class Problem59 {
   public int[][] generateMatrix(int n) {
      int mat[][] = new int[n][n];
      int m = n;
      int total = m * n;
      int current = 1;
      int row_start = 0, col_start = 0, row_end = m - 1, col_end = n - 1; 
      while (current <= total) {
         for (int i = col_start; i <= col_end; ++i) {
            mat[row_start][i] = current;
            current++;
         }
         for (int i = row_start +  1; i <= row_end; ++i) {
            mat[i][col_end] = current;
            current++;
         }
         // this check is required so that we do not consider same row again
         if (row_end > row_start) {
            for (int i = col_end - 1; i >= col_start; --i) {
               mat[row_end][i] = current;
               current++;
            }
         }
         if (col_end > col_start) {
            for (int i = row_end - 1; i > row_start; --i) {
               mat[i][col_start] = current;
               current++;
            }
         }
         row_start++;
         col_start++;
         row_end--;
         col_end--;
      }
      return mat;
   }
   
   @Test
   public void generateMatrixTest() {
      int n = 2;
      int[][] mat = generateMatrix(n);
      for (int i = 0; i < n; ++i) {
         for (int j = 0; j < n; ++j) {
            System.out.print(mat[i][j] + " ");
         }
         System.out.println();
      }
   }
}

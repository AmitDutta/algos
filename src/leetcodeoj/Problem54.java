package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;


public class Problem54 {
   public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> lst = new ArrayList<Integer>();
      if (matrix.length == 0) return lst;
      int m = matrix.length;
      int n = matrix[0].length;
      int total = m * n;
      int current = 0;
      int row_start = 0, col_start = 0, row_end = m - 1, col_end = n - 1; 
      while (current < total) {
         for (int i = col_start; i <= col_end; ++i) {
            lst.add(matrix[row_start][i]);
            current++;
         }
         for (int i = row_start +  1; i <= row_end; ++i) {
            lst.add(matrix[i][col_end]);
            current++;
         }
         // this check is required so that we do not consider same row again
         if (row_end > row_start) {
            for (int i = col_end - 1; i >= col_start; --i) {
               lst.add(matrix[row_end][i]);
               current++;
            }
         }
         if (col_end > col_start) {
            for (int i = row_end - 1; i > row_start; --i) {
               lst.add(matrix[i][col_start]);
               current++;
            }
         }
         row_start++;
         col_start++;
         row_end--;
         col_end--;
      }
      return lst;
   }
   
   @Test
   public void spiralOrderTest1() {
      int[][] arr = {{1},{2}};
      List<Integer> lst = spiralOrder(arr);
      for (int i : lst) {
         System.out.print(i + " ");
      }
      System.out.println();
   }
   @Test
   public void spiralOrderTest2() {
      int[][] arr = {{1,2,3},{3,4,5}};
      List<Integer> lst = spiralOrder(arr);
      for (int i : lst) {
         System.out.print(i + " ");
      }
      System.out.println();
   }
   @Test
   public void spiralOrderTest3() {
      int[][] arr = {{1, 2, 3,4 },{5, 6, 7, 8 },{1, 2, 3, 4},{5, 6, 7, 8 }, {1,2,3,4}};
      List<Integer> lst = spiralOrder(arr);
      for (int i : lst) {
         System.out.print(i + " ");
      }
      System.out.println();
   }
}

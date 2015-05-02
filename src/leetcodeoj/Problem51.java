package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

// This is a classic and differen type of backtracking
// row-row, col-col diagonal test
public class Problem51 {
   private List<String[]> result;
   private int[] x;
   private int n;
   private int total;
   private boolean canplace(int row, int col) {
      for (int i = 0; i < row ; ++i) {
         if (x[i] == col) return false;
         // row-row, col-col
         if (Math.abs(row - i) == Math.abs(col - x[i])) {
            return false;
         }
      }
      return true;
    }
   private void appendResult() {
      String[] item = new String[n];
      for (int i = 0, k = 0; i < n; ++i, ++k) {
         char[] row = new char[n];
         for (int j = 0; j < n; ++j) row[j] = '.';
         row[x[i]] = 'Q';
         item[k] = new String(row);
      }
      result.add(item);
      total++;
   }
   private void nqueen(int row) {
      for (int i = 0; i < n; ++i) {
         if (canplace(row, i)) {
            x[row] = i;
            if (row == n - 1) {
               appendResult();
            }else {
               nqueen(row + 1);
            }
         }
      }
   }
   public List<String[]> solveNQueens(int n) {
      x = new int[n];
      total = 0;
      this.n = n;
      result = new ArrayList<String[]>();
      nqueen(0);
      return result;
   }
   public int totalNQueens(int n) {
      solveNQueens(n);
      return total;
   }
   
   @Test
   public void solveNQueens1() {
      //List<String[]> lst = solveNQueens(1);
      Assert.assertEquals(1, totalNQueens(1));
      Assert.assertEquals(0, totalNQueens(2));
      Assert.assertEquals(2, totalNQueens(4));
      /*for (String[] array : lst) {
         for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
         }
         System.out.println();
      }*/
   }
}

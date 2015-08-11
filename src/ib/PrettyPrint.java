package ib;

import org.junit.*;
import java.util.ArrayList;

public class PrettyPrint {
   public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
      if (A <= 0) return null;
      int k = A + A - 1;
      int[][] mat = new int[k][k];
      ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>(k);
      int row_start = 0, row_end = k - 1;
      int col_start = 0, col_end = k -1;
      for (int val = A; val >= 1; --val) {
         for (int i = col_start; i <= col_end; ++i) {
            mat[row_start][i] = val;
         }
         for (int i = row_start + 1; i <= row_end; ++i) {
            mat[i][col_end] = val;
         }
         for (int i = col_end - 1; i >= col_start; --i) {
            mat[row_end][i] = val;
         }
         for (int i = row_end - 1; i > row_start; --i) {
            mat[i][col_start] = val;
         }
         row_start++;
         row_end--;
         col_start++;
         col_end--;
      }
      for (int i = 0; i < k; ++i) {
         ArrayList<Integer> alist = new ArrayList<Integer>();
         for (int j = 0; j < k; ++j) {
            alist.add(mat[i][j]);
         }
         lst.add(alist);
      }
      return lst;
   }
   @Test
   public void test1() {
      ArrayList<ArrayList<Integer>> res = prettyPrint(6);
      for (ArrayList<Integer> lst : res) {
         for (Integer i : lst) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

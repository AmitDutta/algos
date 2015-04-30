package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Problem120 {

   // TLE
   private int[][] cache;
   public int sum(List<List<Integer>> lst, int i, int j, int prev) {
       if (i >= lst.size()) {
         return prev;
      }
      List<Integer> items = lst.get(i);
      int cur_sum = prev;
      cur_sum += items.get(j);
      int left = sum(lst, i + 1, j, cur_sum);
      int right = sum(lst, i + 1, j + 1, cur_sum);
      cur_sum = Math.min(left, right);
      return cur_sum;
   }

   public int minimumTotalRec(List<List<Integer>> triangle) {
      return sum(triangle, 0, 0, 0);
   }
   
   // using 2d array 333 ms
   public int minimumTotal2D(List<List<Integer>> triangle) {
      if (triangle.size() == 0) return 0;
      int n = triangle.get(triangle.size() - 1).size();
      int[][] cache = new int[n][n];
      for (int i = 0; i < n; ++i) {
         cache[n-1][i] = triangle.get(triangle.size() - 1).get(i);
      }
      for (int i = n - 2; i >= 0; --i) {
         for (int j = 0; j < triangle.get(i).size(); ++j) {
            int cur = triangle.get(i).get(j);
            cache[i][j] = Math.min(cur + cache[i + 1][j], 
                                   cur + cache[i + 1][j + 1]);
         }
      }
      return cache[0][0];
   }

   // Using 1d array 280ms
   public int getIndex(int i, int j) {
      return (i * (i + 1))/2 + j;
   }
   public int minimumTotal(List<List<Integer>> triangle) {
      if (triangle.size() == 0) return 0;
      int n = triangle.get(triangle.size() - 1).size();
      int size = (n * (n + 1)) / 2;
      int[] cache = new int[size];
      int lastRowLenght = triangle.get(triangle.size() - 1).size();
      for (int i = size - lastRowLenght, k = 0; i < size; ++i, ++k) {
         cache[i] = triangle.get(triangle.size() - 1).get(k);
      }
      
      for (int i = n - 2; i >= 0; --i) {
         for (int j = 0; j < triangle.get(i).size(); ++j) {
            int cur = triangle.get(i).get(j);
            cache[getIndex(i, j)] = cur +
                                    Math.min(cache[getIndex(i + 1, j)],
                                             cache[getIndex(i + 1, j + 1)]);
         }
      }
      return cache[0];
   }

   @Test
   public void minimumTotalTest() {
      List<Integer> lst1 = Arrays.asList(2);
      List<Integer> lst2 = Arrays.asList(3,4);
      List<Integer> lst3 = Arrays.asList(6,5,7);
      List<Integer> lst4 = Arrays.asList(4,1,8,3);
      List<List<Integer>> triangle = new ArrayList<List<Integer>>();
      triangle.add(lst1);
      triangle.add(lst2);
      triangle.add(lst3);
      triangle.add(lst4);
      Assert.assertEquals(11, minimumTotal(triangle));
      
      triangle = new ArrayList<List<Integer>>();
      Assert.assertEquals(0, minimumTotal(triangle));
      
      triangle = new ArrayList<List<Integer>>();
      triangle.add(lst1);
      triangle.add(lst2);
      triangle.add(lst3);
      Assert.assertEquals(10, minimumTotal(triangle));
      
   }
}

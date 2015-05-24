package leetcodeoj;

import java.util.*;
import org.junit.*;

public class Problem216 {
   private List<List<Integer>> result;
   public void combinationSum3Int(int k, int n, int sum, int start, int end, List<Integer> lst) {
      if (lst.size() == k) {
         if (sum == n) {
            List<Integer> copy = new ArrayList<Integer>(lst);
            result.add(copy);
         }
         return;
      }
      for (int i = start; i <= end; ++i) {
         lst.add(i);
         combinationSum3Int(k, n, sum + i, i + 1, end, lst);
         lst.remove(lst.size() - 1);
      }
   }
   public List<List<Integer>> combinationSum3(int k, int n) {
      result = new ArrayList<List<Integer>>();
      combinationSum3Int(k, n, 0, 1, 9, new ArrayList<Integer>());
      return result;
   }
   @Test
   public void test1() {
      List<List<Integer>> lst = combinationSum3(0, 0);
      for (List<Integer> items : lst) {
         for (Integer i : items) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

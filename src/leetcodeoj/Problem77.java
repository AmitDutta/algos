package leetcodeoj;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {
   private List<List<Integer>> result;
   private void combineInt(int n, int k, int start, List<Integer> lst) {
      if (lst.size() == k) {
         result.add(new ArrayList<Integer>(lst));
         return;
      }
      for (int i = start; i <= n; ++i) {
         lst.add(i);
         combineInt(n, k, i + 1, lst);
         lst.remove(lst.size() - 1);
      }
   }
   public List<List<Integer>> combine(int n, int k) {
      result = new ArrayList<List<Integer>>();
      combineInt(n, k, 1, new ArrayList<Integer>());
      for (List<Integer> lst : result) {
         for (Integer i : lst) {
            System.out.print(i + " "); 
         }
         System.out.println();
      }
      return result;
   }
   
   public static void main(String... args) {
      Problem77 p77 = new Problem77();
      p77.combine(4, 2);
   }
}

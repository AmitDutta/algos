package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class Problem254 {
   List<List<Integer>> result;
   void factorsInt(int n, int prev, List<Integer> lst) {
      if (n == 1) {
         result.add(new ArrayList<Integer>(lst));
         return;
      }
      for (int i = 2; i <= Math.ceil(n / 2) + 1; ++i) {
         if (n % i == 0 && i <= prev) {
            lst.add(i);
            factorsInt(n / i, i, lst);
            lst.remove(lst.size() - 1);
         }
      }
   }
   public List<List<Integer>> getFactors(int n) {
      result = new ArrayList<List<Integer>>();
      factorsInt(n, n, new ArrayList<Integer>());
      return result;
   }
   @Test
   public void test1() {
      Problem254 p254 = new Problem254();
      List<List<Integer>> r = p254.getFactors(24);
      for (List<Integer> l : r) {
         for (Integer i : l) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

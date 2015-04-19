package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Problem78 {
   List<List<Integer>> result = new ArrayList<List<Integer>>();
   public void generate(int[] S, List<Integer> lst, int n, int start) {
      if (lst.size() == n) {
         List<Integer> set = new ArrayList<Integer>(lst);
         result.add(set);
         return;
      }
      
      for (int i = start; i < S.length; ++i) {
         lst.add(S[i]);
         generate(S, lst, n, i + 1);
         lst.remove(lst.size() - 1);
      }
   }
   public List<List<Integer>> subsets(int[] S) {
      Arrays.sort(S);
      for (int i = 0; i <= S.length; ++i) {
         generate(S, new ArrayList<Integer>(), i, 0);
      }
      return result;
   }
   
   @Test
   public void subsetsTest() {
      Problem78 p78 = new Problem78();
      List<List<Integer>> result = p78.subsets(new int[] {2,3,1});
      Assert.assertEquals(8, result.size());
      for (List<Integer> lst : result) {
         for (Integer i : lst) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

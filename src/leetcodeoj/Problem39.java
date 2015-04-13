package leetcodeoj;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

public class Problem39 {

   private List<List<Integer>> lst = new ArrayList<List<Integer>>();
   
   private void combinationSumInt(int[] candidates, int target,
         List<Integer> current, int value) {
      if (value > target) {
         return;
      }
      if (value == target) {
         List<Integer> item = new ArrayList<Integer>(current);
         //Collections.sort(item);
         lst.add(item);
         return;
      }
      for (int i = 0; i < candidates.length; ++i) {
         if (current.size() > 0 && current.get(current.size() - 1) > candidates[i]) {
            // skipping repeats
            continue;
         }
         current.add(candidates[i]);
         value += candidates[i];
         combinationSumInt(candidates, target, current, value);
         value -= candidates[i];
         current.remove(current.size() - 1);
      }
   }
   
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
      combinationSumInt(candidates, target, new ArrayList<Integer>(), 0);
      return lst;
   }
   
   @Test
   public void Problem39Test() {
      Problem39 p39 = new Problem39();
      int array[] = new int[]{2,3,6,7};
      List<List<Integer>> result = p39.combinationSum(array, 7);
      for (List<Integer> lst : result) {
         for (Integer i : lst) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

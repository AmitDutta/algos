package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem40 {
   List<List<Integer>> result;
   private void combinationSumInt(int[] candidates, int cur, int start, int target, List<Integer> items) {
       if (cur > target) {
           return;
       }
       if (cur == target) {
           List<Integer> lst = new ArrayList<Integer>(items);
           result.add(lst);
           return;
       }
       for (int i = start; i < candidates.length; ++i) {
           if (i > 0 && i > start && candidates[i] == candidates[i - 1]) {
               continue;
           }
           items.add(candidates[i]);
           combinationSumInt(candidates, cur + candidates[i], i + 1, target, items);
           items.remove(items.size() - 1);
       }
   }
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       result = new ArrayList<List<Integer>>();
       Arrays.sort(candidates);
       combinationSumInt(candidates, 0, 0, target, new ArrayList<Integer>());
       return result;
   }
   
   @Test
   public void Problem39Test1() {
      Problem40 p40 = new Problem40();
      int array[] = new int[]{10,1,2,7,6,1,5};
      List<List<Integer>> result = p40.combinationSum2(array, 8);
      for (List<Integer> lst : result) {
         for (Integer i : lst) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
      System.out.println("--");
   }
   
   @Test
   public void Problem39Test2() {
      Problem40 p40 = new Problem40();
      int array[] = new int[]{2, 2, 2};
      List<List<Integer>> result = p40.combinationSum2(array, 4);
      for (List<Integer> lst : result) {
         for (Integer i : lst) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

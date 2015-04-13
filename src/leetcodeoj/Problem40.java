package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem40 {
   private List<List<Integer>> lst = new ArrayList<List<Integer>>();
   
   private void combinationSumInt(int[] candidates, int target,
         List<Integer> current, int value, int start) {
      if (value > target) {
         return;
      }
      if (value == target) {
         List<Integer> item = new ArrayList<Integer>(current);
         //Collections.sort(item);
         lst.add(item);
         return;
      }
      
      for (int i = start; i < candidates.length; ++i) {
         //if (!used[i]) {
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            // why i > start? At each level, we are only allowed to take one 
            // duplicated item. first level, index starts from zero, so we take
            // first one, and skip nexts. Second level, we do the same thing..
            // so always i > start..
            
            current.add(candidates[i]);
            value += candidates[i];
            combinationSumInt(candidates, target, current, value, i + 1);
            value -= candidates[i];
            current.remove(current.size() - 1);
         
      }
   }
   
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      combinationSumInt(candidates, target, new ArrayList<Integer>(), 0, 0);
      return lst;
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

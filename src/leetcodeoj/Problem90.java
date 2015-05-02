package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem90 {
   List<List<Integer>> result = new ArrayList<List<Integer>>();
   public void subsetsWithDupInt(int[] nums, int len, List<Integer> lst, 
                                 int start) {
      if (lst.size() == len) {
         List<Integer> item = new ArrayList<Integer>(lst);
         result.add(item);
         return;
      }
      for (int i = start; i < nums.length; ++i) {
         if (i > start && nums[i] == nums[i- 1]) continue;
         // i > start is critical optimization here..
         lst.add(nums[i]);
         subsetsWithDupInt(nums, len, lst, i + 1);
         lst.remove(lst.size() - 1);
      }
   }
   public List<List<Integer>> subsetsWithDup(int[] nums) {
      result.add(new ArrayList<Integer>());
      if (nums.length == 0) return result;
      Arrays.sort(nums);
      for (int i = 1; i <= nums.length; ++i) {
         subsetsWithDupInt(nums, i, new ArrayList<Integer>(), 0);
      }
      return result;
   }
   @Test
   public void subsetsWithDupTest() {
      List<List<Integer>> result = subsetsWithDup(new int[]{1,2,2,2});
      for (List<Integer> lst : result) {
         for (Integer i : lst) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

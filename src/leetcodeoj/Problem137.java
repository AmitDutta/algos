package leetcodeoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem137 {
   public int singleNumber(int[] nums) {
      if (nums.length == 0) return 0;
      Set<Integer> set = new HashSet<Integer>();
      List<Integer> lst = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; ++i) {
         set.add(nums[i]);
      }
      for (int i = 0; i < nums.length; ++i) {
         lst.add(nums[i]);
      }
      lst.addAll(set);
      int result = lst.get(0);
      for (int i = 0; i < lst.size(); ++i) {
         result ^= lst.get(i);
      }
      return result;
   }
}

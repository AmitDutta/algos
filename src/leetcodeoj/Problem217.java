package leetcodeoj;

import java.util.HashSet;
import java.util.Set;

public class Problem217 {
   public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<Integer>();
      boolean flag = false;
      for (int i = 0; i < nums.length; ++i) {
          if (set.contains(nums[i])) {
              flag = true;
              break;
          }
          set.add(nums[i]);
      }
      return flag;
  }
}

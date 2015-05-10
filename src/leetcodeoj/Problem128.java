package leetcodeoj;

import java.util.HashSet;
import java.util.Set;

import org.junit.*;

import org.junit.Test;

public class Problem128 {
   public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<Integer>();
      for (int i : nums) {
         set.add(i);
      }
      int maxRange = 0;
      for (int i : nums) {
         if (set.contains(i)) {
            set.remove(i);
            int cur = 1;
            int num = i - 1;
            while (set.contains(num)) {
               set.remove(num);
               num--;
               cur++;
            }
            num = i + 1;
            while (set.contains(num)) {
               set.remove(num);
               num++;
               cur++;
            }
            maxRange = Math.max(maxRange, cur);
         }
      }
      return maxRange;
   }
   @Test
   public void longestConsecutiveTest1() {
      Assert.assertEquals(4, longestConsecutive(new int[] {100,4,200,1,3,2}));
      Assert.assertEquals(0, longestConsecutive(new int[] {}));
      Assert.assertEquals(5, longestConsecutive(new int[] {-3,-2,-1,0,1}));
   }
}

package leetcodeoj;

import java.util.Arrays;
import org.junit.*;

// divide rob with two problems 0 to n-1, or 1 to n. pick the best result
// of this two problem..do this for all kinds of circular dps..
// topcoder badneighbour
public class Problem213 {
   private int robInt(int[] nums) {
      if (nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];
      if (nums.length == 2) return Math.max(nums[0], nums[1]);
      int[] cost = new int[nums.length];
      cost[0] = nums[0];
      cost[1] = Math.max(nums[1], cost[0]);
      for (int i = 2; i < cost.length; ++i) {
         cost[i] = Math.max(cost[i - 1], nums[i] + cost[i - 2]);
      }
      return cost[cost.length - 1];
   }
   public int rob(int[] nums) {
      if (nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];
      if (nums.length == 2) return Math.max(nums[0], nums[1]);
      int[] a = Arrays.copyOfRange(nums, 0, nums.length - 1);
      int[] b = Arrays.copyOfRange(nums, 1, nums.length);
      return Math.max(robInt(a), robInt(b));
   }
   @Test
   public void test1() {
      Assert.assertEquals(2, rob(new int[] {1,1,1,1}));
   }
}

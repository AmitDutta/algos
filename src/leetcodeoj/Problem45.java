package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem45 {
   // Latest one
   public int jump(int[] nums) {
      if (nums.length == 0) return 0;
      int[] cost = new int[nums.length];
      for (int i = 0; i < cost.length; ++i) {
         cost[i] = Integer.MAX_VALUE;
      }
      cost[0] = 0;
      int j = 0;
      for (int i = 0; i < nums.length; ++i) {
          int lastIndex = Math.min(i + nums[i], nums.length - 1);
          for (; j <= lastIndex ; ++j) {
             cost[j] = Math.min(cost[j], 1 + cost[i]);
          }
      }
      return cost[nums.length - 1];
   }
   // Same strategy; TLE with regular one
   public int jump2(int[] nums) {
      int cost[] = new int[nums.length];
      if (nums.length <= 1) return 0;
      cost[0] = 0;
      for (int i = 1; i < cost.length; ++i) {
         cost[i] = Integer.MAX_VALUE;
      }
      int previous = 0;
      for (int i = 0; i < nums.length; ++i) {
         int current = Math.min(i + nums[i], nums.length -1);
         if (current == i && nums[i] == 0 && i + 1 < nums.length 
               && cost[i + 1] == Integer.MAX_VALUE) {
            break;
         }
         while (previous <= current && previous < nums.length) {
            cost[previous] = Math.min(cost[previous], 1 + cost[i]);
            ++previous;
         }
      }
      return cost[nums.length - 1];
   }
   
   // basic algo
   public int jump1(int[] nums) {
      int cost[] = new int[nums.length];
      if (nums.length <= 1) return 0;
      cost[0] = 0;
      for (int i = 1; i < cost.length; ++i) {
         cost[i] = Integer.MAX_VALUE;
      }
      for (int i = 0; i < nums.length; ++i) {
         int endIndex = Math.min(i + nums[i], nums.length -1);
         for (int k = i + 1; k <= endIndex; ++k) {
            cost[k] = Math.min(cost[k], 1 + cost[i]);
         }
      }
      return cost[nums.length - 1];
   }
         
   
   @Test
   public void jumpTest1() {
      Assert.assertEquals(2, jump(new int[] {2,3,1,1,4}));
      Assert.assertEquals(0, jump(new int[] {2}));
      Assert.assertEquals(0, jump(new int[] {}));
      Assert.assertEquals(1, jump(new int[] {3,2,1}));
      Assert.assertEquals(2, jump(new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
   }
}

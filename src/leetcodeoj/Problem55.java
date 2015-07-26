package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem55 {
   // This one is a good example of optimization and corner cases.
   public boolean canJump1(int[] nums) {
      if (nums.length == 0) {
         return false;
      }
      if (nums[0] == 0) {
         if (nums.length == 1) return true;
         return false;
      }

      boolean[] cost = new boolean[nums.length];
      cost[0] = true;
      int previous = 0;
      for (int i = 0; i < nums.length; ++i) {
         int current = i + nums[i];
         if (current == i && nums[i] == 0 && i + 1 < nums.length 
               && !cost[i + 1]) {
            break;
         }

         while (previous <= current && previous < nums.length) {
            cost[previous] = true;
            ++previous;
         }
      }

      return cost[nums.length - 1];
   }
   
   public boolean canJump(int[] nums) {
      if (nums.length == 1) return true;
      int last = 0;
      for (int i = 0; i < nums.length; ++i) {
          if (i > last) {
              return false;
          }
          last = Math.max(last, i + nums[i]);
          if (last >= nums.length - 1) {
              return true;
          }
      }
      return false;
  }
   
   // O(1) space
   public boolean canJump2(int[] nums) {
      if (nums.length == 0) return false;
      if (nums.length == 1) return true;
      int lastIndex = 0;
      for (int i = 0; i < nums.length; ++i) {
         int delta = i + nums[i] - lastIndex;
         if (delta > 0) {
            lastIndex += delta;
         }
         if (lastIndex >= nums.length - 1) {
            return true;
         } else if (nums[i] == 0 && lastIndex <= i) {
            return false;
         }
      }
      return lastIndex >= nums.length - 1 ? true : false;
   }
   /*
   public boolean canJump(int[] nums) {
      if (nums.length == 0) {
         return false;
      }
      boolean[] cost = new boolean[nums.length];
      cost[0] = true;
      for (int i = 0; i < nums.length; ++i) {
         for (int j = 1; j <= nums[i]; ++j) {
            if (i + j < cost.length) {
               cost[i + j] = true;
            }
         }
      }
      return cost[nums.length - 1];
   }
   */

   @Test
   public void canJumpTest1() {
      Assert.assertTrue(canJump(new int[] {2,3,1,1,4}));
      Assert.assertFalse(canJump(new int[] {3,2,1,0,4}));
      Assert.assertFalse(canJump(new int[] {}));
      Assert.assertFalse(canJump(new int[] {0,2,3}));
      Assert.assertTrue(canJump(new int[] {0}));
      Assert.assertFalse(canJump(new int[] {1,0,1,0}));
   }

   @Test
   public void canJumpTest2() {
      Assert.assertTrue(canJump(new int[] {1,1,2,2,0,1,1}));
      
   }
   
   @Test
   public void canJumpTest3() {
      Assert.assertTrue(canJump(new int[] {3, 2, 1}));
   }
   @Test
   public void test1() {
      Assert.assertTrue(canJump(new int[] {2,3,1,1,4}));
      Assert.assertFalse(canJump(new int[] {3,2,1,0,4}));
      Assert.assertFalse(canJump(new int[] {0,2,3}));
      Assert.assertTrue(canJump(new int[] {5}));
      Assert.assertTrue(canJump(new int[] {0}));
      Assert.assertTrue(canJump(new int[] {2, 0}));
      Assert.assertTrue(canJump(new int[] {2, 0, 0}));
      Assert.assertTrue(canJump(new int[] {2,5,0,0}));
      Assert.assertTrue(canJump(new int[] {1,1,2,2,0,1,1}));
   }
}

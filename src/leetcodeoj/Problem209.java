package leetcodeoj;

import org.junit.*;

public class Problem209 {
   public int minSubArrayLen(int s, int[] nums) {
      int curStart = 0, minLen = nums.length + 1, sum = 0;
      for (int i = 0; i < nums.length; i++) {
          sum += nums[i];
          if (sum >= s) {
              minLen = Math.min(minLen, i - curStart + 1);
              int k = curStart;
              while (sum - nums[k] >= s) {
                 minLen = Math.min(minLen, i - k);
                 sum = sum - nums[k];
                 k++;
              }
              curStart = k;
          }
      }
      if (minLen == nums.length + 1) {
          return 0;
      }
      return minLen;
  }
   @Test
   public void minSubArrayLenTest() {
      Assert.assertEquals(2, minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
      Assert.assertEquals(1, minSubArrayLen(7, new int[] {1,3,4,7}));
      Assert.assertEquals(0, minSubArrayLen(100, new int[] {1,3,4,7}));
      Assert.assertEquals(1, minSubArrayLen(4, new int[] {1,4,4}));
   }
}

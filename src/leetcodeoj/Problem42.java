package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem42 {
   public int trap(int[] height) {
      int result = 0;
      if (height.length <= 2) return result;

      int[] left_max = new int[height.length];
      int[] right_max = new int[height.length];

      left_max[0] = height[0];
      for (int i = 1; i < height.length; ++i) {
         left_max[i] = Math.max(height[i - 1], left_max[i - 1]);
      }

      right_max[right_max.length - 1] = height[height.length - 1];
      for (int i = right_max.length - 2; i >= 0; --i) {
         right_max[i] = Math.max(height[i + 1], right_max[i + 1]);
      }

      for (int i = 1; i < height.length - 1; ++i) {
         result += Math.max(0, Math.min(left_max[i], right_max[i]) - height[i]);
      }
      return result;
   }

   @Test
   public void trapTest() {
      Assert.assertEquals(0, trap(new int[] {}));
      Assert.assertEquals(0, trap(new int[] {5,6}));
      Assert.assertEquals(9, trap(new int[] {15,6,30}));
      Assert.assertEquals(6, trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
   }
}

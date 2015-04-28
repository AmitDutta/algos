package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem153 {
   public int findMin(int[] nums) {
      if (nums.length == 1) return nums[0];
      int start = 0, end = nums.length - 1, mid = 0;
      int min = Integer.MIN_VALUE;
      while (start < end) {
         if (start + 1 == end) {
            min = nums[end];
            // Handle sorted case
            if (nums.length >= 1 && min > nums[0]) {
               min = nums[0];
            }
            break;
         }
         mid = end + (start - end) / 2;
         if (nums[mid] > nums[start]) {
            start = mid;
         }else {
            end = mid;
         }
      }
      return min;
   }
   
   @Test
   public void findMinTest() {
      Assert.assertEquals(0, findMin(new int[] {4,5,6,8,0,2,3}));
      Assert.assertEquals(0, findMin(new int[] {6,0,1,2,3,4,5}));
      Assert.assertEquals(5, findMin(new int[] {5}));
      Assert.assertEquals(5, findMin(new int[] {5,6,7,8}));
   }
}

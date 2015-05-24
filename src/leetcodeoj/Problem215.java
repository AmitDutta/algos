package leetcodeoj;

import org.junit.*;

public class Problem215 {
   public int partition(int[] nums, int start, int end) {
      int j = start - 1;
      for (int i = start; i < end; ++i) {
          if (nums[i] < nums[end]) {
              j++;
              int tmp = nums[j];
              nums[j] = nums[i];
              nums[i] = tmp;
          }
      }
      j++;
      int tmp = nums[end];
      nums[end] = nums[j];
      nums[j] = tmp;
      return j;
  }
  public int findKthLargest(int[] nums, int k) {
      int low = 0;
      int high = nums.length - 1;
      k = nums.length - k;
      while (low < high) {
          int index = partition(nums, low, high);
          if (index == k) {
              return nums[index];
          } else if (index > k) {
              high = index - 1;
          } else {
              low = index + 1;
          }
          
      }
      return nums[low];
  }
  @Test
  public void findKthLargest() {
     int nums1[] = {99,99};
     Assert.assertEquals(99, findKthLargest(nums1, 1));
     int nums2[] = {3,2,1,5,6,4};
     Assert.assertEquals(5, findKthLargest(nums2, 2));
     int nums3[] = {3,2,1,5,6,4};
     Assert.assertEquals(6, findKthLargest(nums3, 1));
     int nums4[] = {3,3,3};
     Assert.assertEquals(3, findKthLargest(nums4, 3));
  }
}

package leetcodeoj;

import java.util.Arrays;

import org.junit.*;

public class Problem164 {
   public int getMax(int[] nums) {
      int max = nums[0];
      for (int i  = 1; i < nums.length; ++i) {
         max = Math.max(max, nums[i]);
      }
      return max;
   }
   public void countingSort(int[] nums, int k) {
      int[] buckets = new int[10];
      int[] output = new int[nums.length];
      for (int i = 0; i < nums.length; ++i) {
         buckets[(nums[i] / k) % 10]++;
      }
      for (int i = 1; i < 10; ++i) {
         buckets[i] += buckets[i - 1];
      }
      for (int j = nums.length - 1; j >= 0; j--) {
         output[buckets[(nums[j] / k) % 10] - 1]  = nums[j];
         buckets[(nums[j] / k) % 10]--;
      }
      System.arraycopy(output, 0, nums, 0, output.length);
   }
   public void radixSort(int[] nums) {
      if (nums.length == 0) return;
      int max_num = getMax(nums);
      for (int i = 1 ; max_num / i > 0; i *= 10) {
         countingSort(nums, i);
      }
      
   }
   public int maximumGap(int[] nums) {
      radixSort(nums);
      if (nums.length <= 1) return 0;
      int gap = nums[1] - nums[0];
      for (int i = 2; i < nums.length; ++i) {
         gap = Math.max(gap, nums[i] - nums[i - 1]);
      }
      return gap;
   }
   @Test
   public void countingSortTest() {
      int[] array = new int[] {18,99,1,5,4,3,500,99,49,25};
      radixSort(array);
      array = new int[] {95};
      radixSort(array);
   }
   @Test
   public void maximumGapTest1() {
      Assert.assertEquals(5, maximumGap(new int[] {10,7,2,9}));
      Assert.assertEquals(48, maximumGap(new int[] {1,2,50}));
      Assert.assertEquals(0, maximumGap(new int[] {}));
   }
}

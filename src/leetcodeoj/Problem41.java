package leetcodeoj;

import org.junit.*;

public class Problem41 {
   public int firstMissingPositive(int[] nums) {
      // The idea is to use put each item to its spot and get the missing item
      // This is inplace bucket sort, put each item to its index
      for (int i = 0; i < nums.length;) {
         int targetIndex = nums[i] - 1;
         if (nums[i] < nums.length && nums[i] != i + 1 && nums[i] > 0 && nums[i] != nums[targetIndex]) {
            int tmp = nums[targetIndex];
            nums[targetIndex] = nums[i];
            nums[i] = tmp;
         }else {
            i++;
         }
      }
      int i = 0;
      for (i = 0; i < nums.length; ++i) {
         if (nums[i] != i + 1) {
            return i + 1;
         }
      }
      return i + 1;
   }

   @Test
   public void firstMissingPositiveTest1() {
      Assert.assertEquals(3, firstMissingPositive(new int[] {1,2,0}));
      Assert.assertEquals(2, firstMissingPositive(new int[] {3,4,-1,1}));
   }
   
   @Test
   public void firstMissingPositiveTest0() {
      Assert.assertEquals(3, firstMissingPositive(new int[] {2,1}));
      Assert.assertEquals(2, firstMissingPositive(new int[] {3,1}));
      Assert.assertEquals(3, firstMissingPositive(new int[] {0,2,2,1,1}));
   }
   
   @Test
   public void firstMissingPositiveTest2() {
      Assert.assertEquals(1, firstMissingPositive(new int[] {2}));
      Assert.assertEquals(2, firstMissingPositive(new int[] {1}));
   }
}

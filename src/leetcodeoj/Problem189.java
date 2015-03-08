package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem189 {
   // O(n^2); TLE
   public void rotate1(int[] nums, int k) {
      for (int i = 1; i <= k; ++i) {
         int last = nums[nums.length - 1];
         for (int j = nums.length - 1; j >= 1; --j) {
            nums[j] = nums[j -1];
         }
         nums[0] = last;
      }
   }
   
   // Still not O(1) space :(
   public void rotate(int[] nums, int k) {
      int[] extra = new int[k];
      int p = 0;
      
      k = k % nums.length;
      
      for (int i = nums.length  - k; i < nums.length; ++i) {
         extra[p++] = nums[i];
      }
      p = 1;
      for (int i = nums.length - 1 - k; i >= 0; --i) {
         nums[nums.length - p] = nums[i];
         ++p;
      }
      for (int i = 0; i < k; ++i) {
         nums[i] = extra[i];
      }
   }
   
   void printArray(int[] arr) {
      for (int i = 0; i < arr.length; ++i) {
         System.out.println(arr[i] + " ");
      }
      System.out.println("--");
   }
   
   @Test
   public void rotateTest() {
      Problem189 p189 = new Problem189();
      int[] num = new int[] {1,2,3,4,5,6,7};
      
      p189.rotate(num, 3);
      Assert.assertArrayEquals(new int[] {5,6,7,1,2,3,4}, num);
      
      num = new int[] {1,2,3,4,5,6,7};
      p189.rotate(num, 7);
      Assert.assertArrayEquals(num, num);
      
      num = new int[] {1,2,3,4,5,6,7};
      p189.rotate(num, 1);
      Assert.assertArrayEquals(new int[] {7,1,2,3,4,5,6}, num);
      
      num = new int[] {1,2};
      p189.rotate(num, 3);
      Assert.assertArrayEquals(new int[] {2, 1}, num);
      
      num = new int[] {1,2,3};
      p189.rotate(num, 4);
      // Array size is 3 and rotating it 4 times should be equal to rotating it
      // 1 times. So, we requre k = k % length at beginning.
      Assert.assertArrayEquals(new int[] {3,1,2}, num);
   }
}

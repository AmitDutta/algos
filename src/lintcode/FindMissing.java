package lintcode;

import org.junit.*;

// This one has advantage because we can mark a number by -1, and skip
// that index since all the initial numbers are >= 0.
// input has from 0 to n
public class FindMissing {
   public int findMissing(int[] nums) {
      for (int i = 0; i < nums.length;) {
          if (nums[i] >= nums.length || nums[i] < 0) {
              i++;
          } else {
              if (i != nums[i]) {
                  int k = nums[nums[i]];
                  nums[nums[i]] = -1;
                  nums[i] = k;
              } else {
                  nums[i] = -1;
                  i++;
              }
          }
      }
      for (int i = 0; i < nums.length; ++i) {
          if (nums[i] != -1) {
              return i;
          }
      }
      return nums.length;
   }
   // Same concept as before..but we need to find only positive missing
   // number..bucket
   //[1,1], we may run into infinite loop when nums[1] = 1, we want to 
   // put 2 here. but nums[1]-1 = 1 as well, so after swaping we have
   // the same state nums[1] == 1. so if nums[i] == num[nums[i] - 1]
   // just break..
   public int firstMissingPositive(int[] nums) {
      for (int i = 0; i < nums.length;) {
         if (nums[i] <= 0 || nums[i] >= nums.length) {
            ++i;
         } else {
            if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
               int k = nums[nums[i] - 1];
               nums[nums[i] - 1] = nums[i];
               nums[i] = k;
            } else {
               i++;
            }
         }
      }
      for (int i = 0; i < nums.length; ++i) {
         if (nums[i] != i + 1) {
            return i + 1;
         }
      }
      return nums.length + 1;
   }
   @Test
   public void test1() {
      Assert.assertEquals(3, firstMissingPositive(new int[] {1,2,0}));
      Assert.assertEquals(2, firstMissingPositive(new int[] {3,4,-1,1}));
      Assert.assertEquals(1, firstMissingPositive(new int[] {0}));
      Assert.assertEquals(1, firstMissingPositive(new int[] {-1}));
      
      // Infinite loop! So, if two nums[i] and nums[nusm[i]] are equal
      // just break
      Assert.assertEquals(2, firstMissingPositive(new int[] {1,1}));
      Assert.assertEquals(1, firstMissingPositive(new int[] {}));
      Assert.assertEquals(2, firstMissingPositive(new int[] {1}));
   }
}

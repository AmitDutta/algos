package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem81 {
   // Runtime is O(n) because {4,4,4,4}, we need to scan all itmes
   // to get the rotation index. Therefore, doing a liner search
   // will just be fine.
   public int index(int[] nums, int left, int right) {
      while (left < right) {
         if (left + 1 == right) {
            if (nums[left] > nums[right]) {
               return right;
            }
            return -1;
         }
         int mid = left + (right - left)/2;
         if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
            left++;
            // we can not do both start-- and left++ both same time. That way
            // we may loose the rotation point
         } else if (nums[mid] < nums[left]) {
            right = mid;
         }else {
            left = mid;
         }
      }
      return -1;
   }
   public int bs(int[] nums, int left, int right, int target) {
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            return mid;
         }else if (nums[mid] > target) {
            right = mid - 1;
         }else {
            left = mid + 1;
         }
      }
      return -1;
   }
   public boolean search1(int[] nums, int target) {
      // With duplicates searching rotation index will be linear, since
      // if mid is smaller than both ends, we need to search in both ends
      if (nums.length == 0) return false;
      int i =  index(nums, 0, nums.length - 1);
      if (i == -1) {
         int result = bs(nums, 0, nums.length - 1, target);
         if (result > -1) {
            return true;
         }
      }else {
         // i is rotation index
         int result = bs(nums, 0, i - 1, target);
         if (result > -1) return true;
         result = bs(nums, i, nums.length -1, target);
         if (result > -1) return true;
      }
      return false;
   }
   
   private int bsearch(int[] nums, int target, int lo, int hi) {
      while (lo <= hi) {
         int mid = lo + (hi- lo)/2;
         if (nums[mid] == target) {
            return mid;
         }
         if (nums[mid] > target) {
            hi = mid - 1;
         } else {
            lo = mid + 1;
         }
      }
      return -1;
   }
   // The idea is when we see a mid, one part is always sorted. If the data
   // is in that part, just do a binary search in that side. Else do rotated
   // search in the other part. While doing rotated search, keep mid intact
   private int searchInt(int[] nums, int target, int lo, int hi) {
      if (lo > hi) {
         return -1;
      }
      if (lo == hi) {
         if (nums[lo] == target) {
            return lo;
         }
         return -1;
      }
      if (lo + 1 == hi) {
         if (nums[lo] == target) {
            return lo;
         } else if (nums[hi] == target) {
            return hi;
         }
         return -1;
      }
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
         return mid;
      }
      if (nums[mid] > nums[lo]) {
         // lo to mid sorted. If data is here, do binary search
         if (target >= nums[lo] && target < nums[mid]) {
            return bsearch(nums, target, lo, mid - 1);
         }
         return searchInt(nums, target, mid, hi);
      } else  if (nums[mid] < nums[lo]){
         // mid to hi sorted
         if (target > nums[mid] && target <= nums[hi]) {
            return bsearch(nums, target, mid + 1, hi);
         }
         return searchInt(nums, target, lo, mid);
      } else {
         return searchInt(nums, target, lo + 1, hi);
      }
   }    
    public boolean search(int[] nums, int target) {
        int val = searchInt(nums, target, 0, nums.length - 1);
        return val == -1 ? false : true;
    }
   @Test
   public void indexTest1() {
      Assert.assertEquals(1, index(new int[]{5,1,2,3,4}, 0, 4));
      Assert.assertEquals(2, index(new int[]{4,4,1,2,3,4}, 0, 5));
      Assert.assertEquals(2, index(new int[]{4,4,1,2,2,4}, 0, 5));
      Assert.assertEquals(-1, index(new int[]{4,4,4,4,4,4}, 0, 5));
      Assert.assertEquals(-1, index(new int[]{1,2,3,4,5,6}, 0, 5));
      Assert.assertEquals(-1, index(new int[]{4}, 0, 0));
   }
   
   @Test
   public void searchTest1() {
      Assert.assertTrue(search(new int[]{5,1,2,3,4}, 5));
      Assert.assertTrue(search(new int[]{4,5,4,4}, 5));
      Assert.assertTrue(search(new int[]{4,4,1,2,3,4}, 4));
      Assert.assertTrue(search(new int[]{3,1}, 1));
   }
   
   @Test
   public void searchTest2() {
      int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
      Assert.assertTrue(search(arr, 2));
   }
   
   @Test
   public void searchTest3() {
      int[] arr = {1,1,1,1,1,1,2,1,1,1};
      Assert.assertTrue(search(arr, 2));
   }
   
}


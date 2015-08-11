package leetcodeoj;
import org.junit.*;

public class Problem33 {
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
   // for duplicates, just add one to left or right side and continue searchInt
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
         // if array has duplicates
         return searchInt(nums, target, lo + 1, mid);
      }
   }
   public int search(int[] nums, int target) {
      return searchInt(nums, target, 0, nums.length - 1);
   }
   @Test
   public void test1() {
      Assert.assertEquals(-1, search(new int[]{5}, 1));
      Assert.assertEquals(1, search(new int[]{3, 1}, 1));
      Assert.assertEquals(0, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
      Assert.assertEquals(1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
      Assert.assertEquals(2, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
      Assert.assertEquals(3, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
      Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
      Assert.assertEquals(6, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
      Assert.assertEquals(5, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
   }
}

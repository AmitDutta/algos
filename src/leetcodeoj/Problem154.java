package leetcodeoj;

public class Problem154 {
   public int findMin(int[] nums) {
      if (nums.length == 1) return nums[0];
      int lo = 0, hi = nums.length - 1;
      while (true) {
          if (lo + 1 == hi) {
              lo = Math.min(nums[lo], nums[hi]);
              break;
          }
          if (nums[lo] < nums[hi]) {
              lo = nums[lo];
              break;
          }
          if (nums[lo] == nums[hi]) {
              ++lo;
              continue;
          }
          int mid = lo + (hi - lo) / 2;
          if (nums[mid] < nums[lo]) {
              hi = mid;
          } else {
              lo = mid;
          }
      }
      return lo;
  }
}

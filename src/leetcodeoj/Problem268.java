package leetcodeoj;

public class Problem268 {
   public int missingNumber(int[] nums) {
      long expected = (nums.length * (nums.length + 1))/2;
      long actual = 0;
      for (int i = 0; i < nums.length; ++i) {
          actual += nums[i];
      }
      if (actual == expected) return 0;
      return (int) (expected - actual);
   }
}

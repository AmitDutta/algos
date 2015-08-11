package lintcode;

public class PartitionArray {
   public void partitionArray(int[] nums) {
      int i = -1;
      for (int j = 0; j < nums.length; ++j) {
          if ((nums[j] & 1) == 1) {
              ++i;
              int k = nums[i];
              nums[i] = nums[j];
              nums[j] = k;
          }
      }
   }
   public int partitionArray2(int[] nums, int k) {
      int lt = 0, gt = nums.length - 1;
      // i <= gt; not i < gt
      for (int i = 0; i <= gt;) {
          if (nums[i] > k) {
              // swap with gt
              int tmp = nums[gt];
              nums[gt] = nums[i];
              nums[i] = tmp;
              gt--;
          } else if (nums[i] < k) {
              // swap with lt
              int tmp = nums[lt];
              nums[lt] = nums[i];
              nums[i] = tmp;
              i++;
              lt++;
          } else {
              i++;
          }
      }
      return lt == nums.length - 1 ? nums.length : lt;
  }
}

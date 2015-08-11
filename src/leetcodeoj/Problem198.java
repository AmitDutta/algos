package leetcodeoj;

public class Problem198 {
   // here cost[i] is the cost including i, not the optimal upto i
   public int rob1(int[] nums) {
      if (nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];
      int[] cost = new int[nums.length];
      cost[0] = nums[0];
      cost[1] = nums[1];
      int max = Math.max(cost[0], cost[1]);
      for (int i = 2; i < nums.length; ++i) {
          for (int j = 0; j < i - 1; ++j) {
              cost[i] = Math.max(cost[i], nums[i] + cost[j]);
          }
          max = Math.max(cost[i], max);
      }
      return max;
   }
   
   // Same thing, without the other loop. Cost[i] now is the optimial solution
   // up to i
   public int rob(int[] nums) {
      // Lets say cost[i] has the optimum cost upto i
      if (nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];
      int[] cost = new int[nums.length];
      cost[0] = nums[0];
      cost[1] = Math.max(cost[0], nums[1]);
      for (int i = 2; i < nums.length; ++i) {
          cost[i] = Math.max(cost[i - 1], nums[i] + cost[i - 2]);
      }
      return cost[cost.length - 1];
  }
}

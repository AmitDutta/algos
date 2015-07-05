package dp;
import org.junit.*;
public class Lis {
   private void reconstruct_path(int[] nums, int[] s, int p) {
      if (p == s[p]) {
         System.out.print(nums[p] + " ");
         return;
      }
      reconstruct_path(nums, s, s[p]);
      System.out.print(nums[p] + " ");
   }
   // cost[i] has the longest sequence ending at i; means including i
   // it may not be the overall longest, for that we need to find max
   // consider [10,20,30,40,-1], now max list length is 4, but cost[4]
   // will be 1. cost[i] is the lis that includes i
   public int longestIncreasingSubsequence(int[] nums) {
      // write your code here
      if (nums.length == 0) return 0;
      int[] cost = new int[nums.length];
      int[] s = new int[nums.length];
      for (int i = 0; i < nums.length; ++i) {
          cost[i] = 1;
          s[i] = i;
      }
      for (int i = 0; i < nums.length; ++i) {
          for (int j = 0; j < i; ++j) {
              if (nums[j] <= nums[i] && 1 + cost[j] >= cost[i]) {
                  cost[i] = 1 + cost[j];
                  s[i] = j;
              }
          }
      }
      int max = cost[0];
      int maxIndex = 0;
      for (int i = 1; i < cost.length; ++i) {
         if (cost[i] >= max) {
            max = cost[i];
            maxIndex = i;
         }
      }
      reconstruct_path(nums, s, maxIndex);
      System.out.println();
      return max;
   }
   @Test
   public void test1() {
      int[] a = {4,1,5,2,3,4};
      Assert.assertEquals(4, longestIncreasingSubsequence(a));
      int[] b = {5,3,4,8,6,7};
      Assert.assertEquals(4, longestIncreasingSubsequence(b));
   }
   @Test
   public void test2() {
      int[] a = {1,1,1,1,1,1};
      Assert.assertEquals(6, longestIncreasingSubsequence(a));
   }
}

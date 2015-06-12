package dp;

import org.junit.*;

public class Partition {
   private int[] sum;
   private int[][] cache;
   private int getSum(int start, int end) {
      if (start == 0) return sum[end];
      return sum[end] - sum[start - 1];
   }
   public int partitionInt(int[] nums, int start, int k) {
      if (k == 1) {
         return getSum(start, nums.length - 1);
      }
      int cost = Integer.MAX_VALUE;
      int current = Integer.MIN_VALUE;
      for (int i = start; i < nums.length; ++i) {
         int s = getSum(start, i);
         int other = partitionInt(nums, i + 1, k - 1);
         current = Math.max(s, other); 
         cost = Math.min(cost, current);
      }
      return cost;
   }
   // memoization is not correct though
   public int partitionMemo(int[] nums, int start, int k) {
      if (cache[start][k - 1] != Integer.MAX_VALUE) {
         return cache[start][k - 1];
      }
      if (k == 1) {
         cache[start][k - 1] = getSum(start, nums.length - 1);
      } else {
         int current = Integer.MIN_VALUE;
         for (int i = start + 1; i < nums.length; ++i) {
            int s = getSum(start, i);
            int other = partitionInt(nums, i + 1, k - 1);
            current = Math.max(s, other);
            cache[start][k - 1] = Math.min(cache[start][k - 1], current);
         }
      }
      return cache[start][k - 1];
   }
   public int partition(int[] nums, int k, boolean memo) {
      sum = new int[nums.length];
      sum[0] = nums[0];
      for (int i = 1; i < nums.length; ++i) {
         sum[i] = sum[i - 1] + nums[i];
      }
      if (!memo) {
         return partitionInt(nums, 0, k);
      }
      cache = new int[nums.length][k];
      for (int i = 0 ; i < nums.length; ++i) {
         for (int j = 0; j < k; ++j) {
            cache[i][j] = Integer.MAX_VALUE;
         }
      }
      return partitionMemo(nums, 0, k);
   }
   public void reconstruct(int[] nums, int[][] d, int n, int k) {
      if (k == 1) {
         print(nums, 0, n + 1);
         return;
      }
      reconstruct(nums, d, d[n - 1][k - 1], k - 1);
      print(nums, d[n - 1][k - 1] + 1, n - 1);
   }
   public void print(int[] nums, int from, int to) {
      System.out.print("(");
      for (int i = from; i <= to; ++i) {
         System.out.print(nums[i]);
         if (i < to) {
            System.out.print(",");
         }
      }
      System.out.print(")");
   }
   public int partitionDp(int[] nums, int k) {
      sum = new int[nums.length];
      sum[0] = nums[0];
      for (int i = 1; i < nums.length; ++i) {
         sum[i] = sum[i - 1] + nums[i];
      }
      int[][] cost = new int[nums.length][k];
      int[][] d = new int[nums.length][k];
      for (int i = 0; i < nums.length; ++i) {
         cost[i][0] = sum[i];
      }
      for (int i = 0; i < k; ++i) {
         cost[0][i] = sum[0];
      }
      for (int i = 1; i < nums.length; ++i) {
         for (int j = 1; j < k; ++j) {
            cost[i][j] = Integer.MAX_VALUE;
            for (int m = 0; m <= i - 1; ++m) {
               int current = Math.max(cost[m][j - 1], sum[i] - sum[m]);
               if (cost[i][j] > current) {
                  cost[i][j] = current;
                  d[i][j] = m;
               }
            }
         }
      }
      reconstruct(nums, d, nums.length, k);
      System.out.println();
      return cost[nums.length - 1][k - 1];
   }
   
   @Test
   public void test1() {
      int[] a = {100,200,300,400,500,600,700,800,900};
      Assert.assertEquals(1700, partition(a, 3, false));
   }
   @Test
   public void test0() {
      int[] a = {100,200,300,400,500,600,700,800,900};
      Assert.assertEquals(4500, partition(a, 1, false));
   }
   @Test
   public void testDp() {
      int[] a1 = {1,1,1,1,1,1,1,1,1};
      Assert.assertEquals(3, partitionDp(a1, 3));
      int[] a2 = {1,2,3,4,5,6,7,8,9};
      Assert.assertEquals(17, partitionDp(a2, 3));
   }
   @Test
   public void test3() {
      int[] a = {568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782};
      Assert.assertEquals(1785, partition(a, 4, false));
   }
}

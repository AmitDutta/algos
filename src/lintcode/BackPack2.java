package lintcode;
import org.junit.*;

public class BackPack2 {
   int[][] cache;
   private int profitMemo(int m, int[] a, int[] v, int start) {
      if (start >= a.length || m <= 0) {
         return 0;
      }

      if (cache[start][m - 1] != Integer.MIN_VALUE) {
         return cache[start][m - 1];
      }

      if (m == 0) {
         cache[start][m - 1] = 0;
         return cache[start][m - 1];
      }

      int cur1 = 0, cur2 = 0;
      if (a[start] <= m) {
         cur1 = v[start] + profitMemo(m - a[start], a, v, start + 1);
      }
      cur2 = profitMemo(m, a, v, start + 1);
      if (cur1 > cur2) {
         cache[start][m - 1] = cur1;
      } else {
         cache[start][m - 1] = cur2;
      }
      return cache[start][m - 1];
  }
   public int backPack2(int m, int[] A, int V[]) {
      cache = new int[A.length][m];
      for (int i = 0; i < A.length; ++i) {
         for (int j = 0; j < m; ++j ) {
            cache[i][j] = Integer.MIN_VALUE;
         }
      }
      return profitMemo(m, A, V, 0);
   }
   public void reconstruct(int m, int[] A, int[] V, int[][] cost) {
      int i = A.length, j = m;
      while (i > 0 && j > 0) {
         int val1 = cost[i - 1][m];
         int val2 = 0;
         if (A[i - 1] < j) {
            val2 = cost[i - 1][j - A[i - 1]] + V[i - 1];
         }
         if (val1 > val2) {
            i--;
         }else {
            System.out.print(A[i - 1] + " ");
            j = j - A[i - 1];
            i--;
         }
      }
      System.out.println();
   }
   public int backPackII(int m, int[] A, int[] V) {
      int[][] cost = new int[A.length + 1][m + 1];
      for (int i = 0; i <= A.length; ++i) {
         cost[i][0] = 0;
      }
      for (int j = 0; j <= m; ++j) {
         cost[0][j] = 0;
      }
      for (int i = 1; i <= A.length; ++i) {
         for (int j = 1; j <= m; ++j) {
            int ii = i - 1;
            if (A[ii] > j) {
               cost[i][j] = cost[i - 1][j];
            }else {
               cost[i][j] = Math.max(cost[i - 1][j], cost[i - 1][j - A[ii]] + V[ii]);
            }
         }
      }
      reconstruct(m, A, V, cost);
      return cost[A.length][m];
   }
   @Test
   public void test1() {
      int[] a = new int[] {2,3,5,7};
      int[] v = new int[] {1,5,2,4};
      Assert.assertEquals(9, backPackII(10, a, v));
   }
   @Test
   public void test2() {
      int[] a = new int[] {2,3,4,5};
      int[] v = new int[] {3,4,5,6};
      Assert.assertEquals(7, backPackII(5, a, v));
   }
}

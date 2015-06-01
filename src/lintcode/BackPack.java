package lintcode;

import org.junit.*;

public class BackPack {
   /*private int profit(int m, int[] a, int start) {
      if (m == 0) return 0;
      if (start >= a.length) {
         return 0;
      }
      int cur1 = 0, cur2 = 0;
      if (a[start] <= m) {
         cur1 = a[start] + profit(m - a[start], a, start + 1);
      }
      cur2 = profit(m, a, start + 1);
      return Math.max(cur1, cur2);
  }*/
   int[][] cache;
   private int profitMemo(int m, int[] a, int start) {
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
         cur1 = a[start] + profitMemo(m - a[start], a, start + 1);
      }
      cur2 = profitMemo(m, a, start + 1);
      if (cur1 > cur2) {
         cache[start][m - 1] = cur1;
      } else {
         cache[start][m - 1] = cur2;
      }
      return cache[start][m - 1];
  }
   public int backPack(int m, int[] A) {
      cache = new int[A.length][m];
      for (int i = 0; i < A.length; ++i) {
         for (int j = 0; j < m; ++j ) {
            cache[i][j] = Integer.MIN_VALUE;
         }
      }
      int val = profitMemo(m, A, 0);
      return val;
  }
  @Test
  public void tets1() {
     Assert.assertEquals(5, backPack(5, new int[] {2,3}));
     Assert.assertEquals(10, backPack(11, new int[] {2,3,5,7}));
     Assert.assertEquals(12, backPack(12, new int[] {2,3,5,7}));
  }
  @Test
  public void test2() {
     int[] i = {828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388};
     Assert.assertEquals(5000, backPack(5000, i));
  }
}

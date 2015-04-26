package practise;

import org.junit.Assert;
import org.junit.Test;

public class Mcm {

   private int[][] table;

   public int cost(int[] dim, int start, int en) {
      if (start == en) {
         return 0;
      }
      int cost = Integer.MAX_VALUE;
      for (int k = start; k < en; ++k) {
         int cost1 = cost(dim, start, k);
         int cost2 = cost(dim, k + 1, en);
         int cost3 = dim[start - 1] * dim[k] * dim[en];
         /* cost3 is crucial to pick correct dimensions.
          * (A1(A2A3)). cost3 is left dimension of A1, common
          * in between A2A3 and A1, last one is right dimension
          * of A3. It is not d[k-1]*d[k]*d[k+1]
          */
         int current = cost1 + cost2 + cost3;
         if (current < cost) {
            cost = current;
         }
      }
      return cost;
   }

   public int memoInt(int[] dim, int start, int en) {
      if (table[start][en] < Integer.MAX_VALUE) {
         return table[start][en];
      }
      if (start == en) {
         table[start][en] = 0;
      }else {
         for (int k = start; k < en; ++k) {
            int cost1 = memoInt(dim, start, k);
            int cost2 = memoInt(dim, k + 1, en);
            int cost3 = dim[start - 1] * dim[k] * dim[en];
            int current = cost1 + cost2 + cost3;
            if (current < table[start][en]) {
               table[start][en] = current;
            }
         }
      }
      return table[start][en];
   }

   public int memo(int[] dim, int start, int en) {
      table = new int[dim.length][dim.length];
      for (int i = 0; i < dim.length; ++i) {
         for (int j = 0; j < dim.length; ++j) {
            table[i][j] = Integer.MAX_VALUE;
         }
      }
      return memoInt(dim, start, en);
   }

   @Test
   public void costTest() {
      int[] dim = {30, 35, 15, 5, 10, 20, 25};
      Assert.assertEquals(2500, cost(dim, 3, 5));
      Assert.assertEquals(7125, cost(dim, 2, 5));
      Assert.assertEquals(15125, cost(dim, 1, 6));
   }

   @Test
   public void memoTest() {
      int[] dim = {30, 35, 15, 5, 10, 20, 25};
      Assert.assertEquals(2500, memo(dim, 3, 5));
      Assert.assertEquals(7125, memo(dim, 2, 5));
      Assert.assertEquals(15125, memo(dim, 1, 6));
   }
}

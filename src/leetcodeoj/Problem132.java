package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem132 {
   // One approach is like Problem 131, keep track of minimum list size 
   // in a private variable. But that gives tle even with map based
   // palindrome lookup. Bascially, recusive solution is not getting
   // accepted here. Even recursion with memoizetion is not accepted
   // TLE for a long string ..
   private boolean[][] map;
   private int[][] cost;
   private void buildMap(String s) {
      map = new boolean[s.length()][s.length()];
      for (int i = 0; i < s.length(); ++i) {
         map[i][i] = true;
         if (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
               map[i][i + 1] = true;
            }
         }
      }
      for (int len = 2; len < s.length(); ++len) {
         for (int i = 0; i + len < s.length(); ++i) {
            int end = i + len;
            map[i][end] = (s.charAt(i) == s.charAt(end) &&
                          map[i + 1][end - 1]);
         }
      }
   }
   /*public int minCutInt(String s, int start, int end) {
      if (start > end) {
         return 0;
      }
      if (cost[start][end] != 0) {
         return cost[start][end];
      }
      if (map[start][end]) {
         cost[start][end] = 1;
      }else {
         cost[start][end] = Integer.MAX_VALUE;
         for (int i = start; i < end; ++i) {
            int cur = minCutInt(s, start, i) + minCutInt(s, i + 1 ,end);
            if (cur < cost[start][end]) {
               cost[start][end] = cur;
            }
         }   
      }
      return cost[start][end];
   }*/
   public int minCutInt(String s) {
      int[] val = new int[s.length()];
      for (int i = 0; i < s.length(); ++i) {
         if (map[0][i]) {
            val[i] = 0;
         }else {
            val[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
               if(map[j + 1][i]) {
                  val[i] = Math.min(val[i], val[j] + 1);
               }
            }
         }
      }
      return val[s.length() - 1];
   }
   public int minCut(String s) {
      cost = new int[s.length()][s.length()];
      buildMap(s);
      return minCutInt(s);
      //return minCutInt(s, 0, s.length() -1);
   }
   
   @Test
   public void minCutTest() {
      Assert.assertEquals(2, minCut("abc"));
      Assert.assertEquals(1, minCut("aab"));
      Assert.assertEquals(0, minCut("abba"));
      Assert.assertEquals(1, minCut("ab"));
      Assert.assertEquals(0, minCut("a"));
   }
}

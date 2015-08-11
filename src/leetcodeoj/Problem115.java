package leetcodeoj;

import org.junit.*;

public class Problem115 {
   public int numDistinct(String s, String t) {
      int[][] cost = new int[s.length() + 1][t.length() + 1];
      
      cost[0][0] = 1;
      
      for (int i = 1; i <= s.length(); ++i) {
         cost[i][0] = 1;
      }
      for (int i = 1; i < t.length(); ++i) {
         cost[0][i] = 0;
      }
      // S = "rabbbit" -> i
      // T = "rabbit' -> j
      // if (s[i] != t[j]) cost[i][j] = cost[i - 1][j]
      // else cost[i][j] = cost[i - 1][j] + cost[i - 1][j - 1]
      for (int i = 1; i <= s.length(); ++i) {
         for (int j = 1; j <= t.length(); ++j) {
            int ss = i - 1;
            int tt = j - 1;
            if (s.charAt(ss) != t.charAt(tt)) {
               cost[i][j] = cost[i - 1][j];
            } else {
               cost[i][j] = cost[i - 1][j] + cost[i - 1][j - 1];
            }
         }
      }
      return cost[s.length()][t.length()];
   }

   @Test
   public void test1() {
      Assert.assertEquals(3, numDistinct("rabbbit", "rabbit"));
   }
}

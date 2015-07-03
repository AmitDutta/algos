package dp;

import org.junit.*;

public class LongestPalindromicSubsequence {
   public int LongestPalindromicSubsequenceLength(String str) {
      int[][] cost = new int[str.length()][str.length()];
      for (int i = 0; i < str.length(); ++i) {
         cost[i][i] = 1;
         if (i < str.length() - 1) {
            cost[i][i + 1] = str.charAt(i) == str.charAt(i + 1) ? 2 : 1;
         }
      }
      for (int len = 2; len < str.length(); ++len) {
         for (int i = 0; i < str.length() - len; ++i) {
            int j = i + len;
            if (str.charAt(i) == str.charAt(j)) {
               cost[i][j] = 2 + cost[i + 1][j - 1];
            } else {
               cost[i][j] = Math.max(cost[i + 1][j], cost[i][j - 1]);
            }
         }
      }
      return cost[0][str.length() - 1];
   }
   @Test
   public void test1() {
      Assert.assertEquals(5, LongestPalindromicSubsequenceLength("agbdba"));
      Assert.assertEquals(3, LongestPalindromicSubsequenceLength("41424"));
      Assert.assertEquals(10, LongestPalindromicSubsequenceLength("4123465434444444"));
   }
}

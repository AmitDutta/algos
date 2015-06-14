package lintcode;

public class LongestCommonSubstring {
   public int longestCommonSubstring(String A, String B) {
      int[][] cost = new int[A.length() + 1][B.length() + 1];
      if (A.length() == 0 || B.length() == 0) return 0; 
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < A.length(); ++i) {
          for (int j = 0; j < B.length(); ++j) {
              if (A.charAt(i) == B.charAt(j)) {
                  cost[i + 1][j + 1] = 1 + cost[i][j];
                  max = Math.max(max, cost[i + 1][j + 1]);
              }
          }
      }
      return max;
   }
}

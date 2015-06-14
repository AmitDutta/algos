package dp;
import org.junit.*;
public class LCS {
   private void reconstruct_path(int[][] cost, String A) {
      int i = cost.length - 1, j = cost[0].length - 1;
      StringBuffer buffer = new StringBuffer();
      while (i > 0 && j > 0) {
         if (cost[i][j] == 1 + cost[i - 1][j - 1]) {
            buffer.append(A.charAt(i - 1));
            i--;
            j--;
         } else {
            if (cost[i - 1][j] > cost[i][j - 1]) {
               i = i - 1;
            } else {
               j = j - 1;
            }
         }
      }
      System.out.println(buffer.reverse().toString());
   }
   public int longestCommonSubsequence(String A, String B) {
      int[][] cost = new int[A.length() + 1][B.length() + 1];
      for (int i = 0; i < A.length(); ++i) {
          for (int j = 0; j < B.length(); ++j) {
              if (A.charAt(i) == B.charAt(j)) {
                  cost[i + 1][j + 1] = 1 + cost[i][j];
              } else {
                  cost[i + 1][j + 1] = Math.max(cost[i][j + 1], 
                                                cost[i + 1][j]);
              }
          }
      }
      reconstruct_path(cost, A);
      return cost[A.length()][B.length()];
   }
   @Test
   public void test1() {
      Assert.assertEquals(3, longestCommonSubsequence("ABCD", "EACD"));
      Assert.assertEquals(2, longestCommonSubsequence("ABCD", "EACB"));
   }
}

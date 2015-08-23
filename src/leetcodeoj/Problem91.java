package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem91 {
   private boolean isValidChar(char ch) {
      return ch != '0';
   }
   private boolean isValidString(String str) {
      if (str.charAt(0) == '0') return false; 
      int rep = Integer.parseInt(str);
      return rep >= 1 && rep <= 26;
   }
   public int numDecodings(String s) {
      if (s.length() == 0) return 0;
      int[] cost = new int[s.length()];
      cost[0] = isValidChar(s.charAt(0)) ? 1 : 0;
      if (s.length() > 1) {
         cost[1] = isValidChar(s.charAt(1)) ? cost[0] : 0;
         cost[1] += isValidString(s.substring(0, 2)) ? 1 : 0;
      }
      for (int i = 2; i < s.length(); ++i) {
         cost[i] = 0;
         String sub1 = s.substring(i - 1, i + 1);
         if (isValidString(sub1)) {
            cost[i] += cost[i - 2];
         }
         if (isValidChar(s.charAt(i))) {
            cost[i] += cost[i - 1];
         }
      }
      return cost[s.length() - 1];
   }
   @Test
   public void test1() {
      Assert.assertEquals(3, numDecodings("112"));
      Assert.assertEquals(0, numDecodings("1100"));
      Assert.assertEquals(0, numDecodings("01"));
   }
}

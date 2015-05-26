package leetcodeoj;

import org.junit.*;

public class Problem214 {
   public int getIndex(int i, int j, int len) {
      int skipped = (i * (i + 1))/2;
      int index = len * i + j - skipped;
      return index;
   }
   // With 2D array, memory limit exceeded
   // Even wtih 1D array, Out of memory..
   // I think different algorithm required..
   public boolean ispalindrome(String s) {
      for (int i = 0, j = s.length() - 1; i <= j; ++i, --j) {
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }
      }
      return true;
   }
   public String shortestPalindrome(String s) {
      if (s.length() == 0) {
         return s;
      }
      if (ispalindrome(s)) {
         return s;
      }
      int space = (s.length() * (s.length() + 1)) / 2;
      boolean cost[] = new boolean[space];
      for (int i = 0; i < s.length(); ++i) {
         cost[getIndex(i, i, s.length())] = true;
         if (i < s.length() - 1) {
            cost[getIndex(i, i + 1, s.length())] = s.charAt(i) == s.charAt(i + 1);
         }
      }
      for (int len = 2; len < s.length(); ++len) {
         for (int i = 0; i < s.length() - len; ++i) {
            int j = i + len;
            cost[getIndex(i, j, s.length())] = cost[getIndex(i +1, j- 1, s.length())] && s.charAt(i) == s.charAt(j);
         }
      }
      if (cost[getIndex(0, s.length() - 1, s.length())]) {
         return s;
      }

      StringBuffer prefix = new StringBuffer();
      int j = s.length() - 1;
      while (j >= 0) {
         prefix.append(s.charAt(j));
         if (cost[getIndex(0, j - 1, s.length())]) {
            break;
         }
         --j;
      }
      prefix.append(s);
      return prefix.toString();
   }
   @Test
   public void test1() {
      Assert.assertEquals("dcbabcd", shortestPalindrome("abcd"));
      Assert.assertEquals("aaacecaaa", shortestPalindrome("aacecaaa"));
      Assert.assertEquals("", shortestPalindrome(""));
   }
   @Test
   public void test2() {
      Assert.assertTrue(ispalindrome("aaaa"));
   }
}

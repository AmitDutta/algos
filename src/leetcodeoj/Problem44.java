        package leetcodeoj;

import org.junit.*;

public class Problem44 {
   public boolean isMatch(String s, String p) {
      int si, pi, star, ss;
      si = pi = 0;
      star = ss = -1;
      while (si < s.length()) {
          if (pi < p.length() && s.charAt(si) == p.charAt(pi)) {
              si++;
              pi++;
              continue;
          }
          if (pi < p.length() && p.charAt(pi) == '?') {
              si++;
              pi++;
              continue;
          }
          if (pi < p.length() && p.charAt(pi) == '*') {
              star = pi;
              ss = si;
              pi++;
              continue;
          }
          if (star != -1) {
              pi = star + 1;
              si = ++ss;
              continue;
          }
          return false;
      }
      while (pi < p.length()) {
          if (p.charAt(pi) != '*') {
              break;
          }
          pi++;
      }
      return pi == p.length();
  }
   
   @Test
   public void Problem44Test() {
      Assert.assertTrue(isMatch("", "*"));
      Assert.assertFalse(isMatch("aa", "a"));
      Assert.assertTrue(isMatch("aa", "aa"));
      Assert.assertFalse(isMatch("aaa", "aa"));
      Assert.assertTrue(isMatch("aa", "*"));
      Assert.assertTrue(isMatch("aa", "a*"));
      Assert.assertTrue(isMatch("ab", "?*"));
      Assert.assertFalse(isMatch("aab", "c*a*b*"));
      Assert.assertTrue(isMatch("abkbckd", "a*b*c*"));
   }
   @Test
   public void Test1() {
      Assert.assertTrue(isMatch("bkyz","b*z"));
   }
}

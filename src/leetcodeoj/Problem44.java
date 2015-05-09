package leetcodeoj;

import org.junit.*;

public class Problem44 {
   public boolean isMatch(String s, String p) {
      int starIndex, pi, ss, si;
      // star index of star
      pi =  si = 0;
      starIndex = ss = -1;
      while (si < s.length()) {
         if (si < s.length() && pi < p.length() && s.charAt(si) == p.charAt(pi)) {
            si++;
            pi++;
            continue;
         }
         if (si < s.length() && pi < p.length() && p.charAt(pi) == '?') {
            si++;
            pi++;
            continue;
         }
         if (si < s.length() && pi < p.length() && p.charAt(pi) == '*') {
            starIndex = pi;
            pi++;
            ss = si;
            continue;
         }
         if (starIndex != -1) {
            pi = starIndex + 1;
            si = ++ss;
            continue;
         }
         return false;
      }
      while (pi < p.length()) {
         if (p.charAt(pi) == '*') {
            pi++;
            continue;
         }else {
            break;
         }
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
   
}

package leetcodeoj;

import org.junit.*;


public class Problem87 {
   // generating all permutation works, but its too much  time.
   private String s2;
   private boolean valid = false;
   public void partition(String s1, StringBuffer buffer, boolean[] visited) {
      if (buffer.length() == s1.length()) {
         if (buffer.toString().equals(s2)) {
            valid = true;
         }
         return;
      }
      for (int i = 0; i < s1.length(); ++i) {
         if (!visited[i] && !valid) {
            visited[i] = true;
            buffer.append(s1.charAt(i));
            partition(s1, buffer, visited);
            visited[i] = false;
            buffer.setLength(buffer.length() - 1);
         }
      }
   }
   public boolean isScramble1(String s1, String s2) {
      this.s2 = s2;
      partition(s1, new StringBuffer(), new boolean[s1.length()]);
      return valid;
   }
   public boolean isScramble(String s1, String s2) {
      if (s1.length() != s2.length()) {
         return false;
      }
      if (s1.equals(s2)) {
         return true;
      }
      if (!sameLetter(s1, s2)) {
         return false;
      }
      int len = s1.length();
      for (int i = 1; i < len; ++i) {
         String s11 = s1.substring(0, i);
         String s12 = s1.substring(i, len);
         String s21 = s2.substring(0, i);
         String s22 = s2.substring(i, len);
         if (isScramble(s11, s21) && isScramble(s12, s22)) {
            return true;
         }
         s21 = s2.substring(len - i, len);
         s22 = s2.substring(0, len - i);
         if (isScramble(s11, s21) && isScramble(s12, s22)) {
            return true;
         }
      }
      return false;
   }
   public boolean sameLetter(String s1, String s2) {
      int[] num = new int[26];
      for (int i = 0; i < s1.length(); ++i) {
         num[s1.charAt(i) -'a']++;
      }
      for (int i = 0; i < s2.length(); ++i) {
         num[s2.charAt(i) -'a']--;
      }
      for (int i = 0; i < 26; ++i) {
         if (num[i] != 0) {
            return false;
         }
      }
      return true;
   }
   @Test
   public void test1() {
      Assert.assertTrue(isScramble("great", "rgeat"));
      Assert.assertTrue(isScramble("abc", "bac")); 
      Assert.assertTrue(isScramble("great", "rgtae"));
      Assert.assertTrue(isScramble("abc", "bca"));
   }
}

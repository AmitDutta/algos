package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;;

public class Problem125 {
   public boolean isPalindrome(String s) {
      if (s.equals("")) return true;
      boolean pal = true;
      for (int i = 0, j = s.length() - 1; i <= j;) {
         if (!Character.isLetterOrDigit(s.charAt(i))) {
            i++;
         }else if (!Character.isLetterOrDigit(s.charAt(j))) {
            j--;
         }else {
            if (Character.toLowerCase(s.charAt(i)) != 
                Character.toLowerCase(s.charAt(j))) {
               pal = false;
               break;
            }
            i++;
            j--;
         }
      }
      return pal;
   }
   
   @Test
   public void isPalindromeTest() {
      Assert.assertTrue(isPalindrome(""));
      Assert.assertFalse(isPalindrome("abca"));
      Assert.assertTrue(isPalindrome("abba"));
      Assert.assertTrue(isPalindrome("aba"));
      Assert.assertTrue(isPalindrome("a"));
      Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
      Assert.assertFalse(isPalindrome("race a car"));
   }
}

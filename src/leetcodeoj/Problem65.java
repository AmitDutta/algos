package leetcodeoj;
import org.junit.*;
public class Problem65 {
   public boolean isValidChar(char ch) {
      if (ch >= '0' && ch <= '9') return true;
      if (ch == 'e' || ch == '+' || ch == '-' || ch == '.') return true;
      return false;
   }
   // Not a good a way to write this..
   public boolean isNumber(String s) {
      s = s.trim();
      if (s.length() == 0) return false;
      boolean valid = true;
      int dotcount = 0;
      int ecount = 0;
      int eIndex =  -1;
      int dotIndex = -5;
      for (int i = 0; i < s.length(); ++i) {
          if (!isValidChar(s.charAt(i))) {
             return false;
          }
          if (s.charAt(i) == '.') {
              dotIndex = i;
              dotcount++;
              if (s.length() == 1) {
                 valid = false;
              } else if (i > 0 && s.charAt(i - 1) == '-' && i == s.length() - 1) {
                 valid = false;
              }
          } else if (s.charAt(i) == 'e') {
               eIndex = i;
               ecount++;
               /*if (i > 0 && s.charAt(i - 1) == '0') {
                  valid = false;
               } else if (i == s.length() - 1) {
                  valid = false;
               }*/
               if (eIndex == 0 || eIndex == s.length() -1) {
                  valid = false;
               } else if (s.charAt(i - 1) == '-' || s.charAt(i - 1) == '+') {
                  valid = false;
               }
          } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
              if (i > 0 && eIndex != i - 1) {
                  valid = false;
              }
              if (i == s.length() -1) {
                 valid = false;
              }
          }
          if (dotIndex + 1 == eIndex) {
             if (s.length() <= 2) {
                valid = false;
             } else if (dotIndex == 0) {
                valid = false;
             }
          }
          if (dotcount > 1 || !valid || dotcount > 1 || ecount > 1 
              || eIndex == 0 || (dotIndex > eIndex && eIndex != -1)) {
              valid = false;
              break;
          }
      }
      return valid;
   }
   @Test
   public void test1() {
      Assert.assertFalse(isNumber("."));
      Assert.assertFalse(isNumber("abc"));
      Assert.assertFalse(isNumber("1 a"));
      Assert.assertFalse(isNumber("25e23.7"));
      Assert.assertFalse(isNumber("0e"));
      Assert.assertFalse(isNumber("e."));
      Assert.assertFalse(isNumber(".e"));
      Assert.assertFalse(isNumber(". 1"));
      Assert.assertFalse(isNumber(".e1"));
      Assert.assertFalse(isNumber("434+"));
      Assert.assertFalse(isNumber("4.34+"));
      Assert.assertFalse(isNumber("2-+4"));
      Assert.assertFalse(isNumber("e-"));
      Assert.assertFalse(isNumber("-."));
      Assert.assertFalse(isNumber("-e58"));

      Assert.assertFalse(isNumber(".e132"));
   }
   @Test
   public void test2() {
      Assert.assertTrue(isNumber("0"));
      Assert.assertTrue(isNumber("0e1"));
      Assert.assertTrue(isNumber("0.1"));
      Assert.assertTrue(isNumber("2e10"));
      Assert.assertTrue(isNumber("-2.5e-45"));
      Assert.assertTrue(isNumber("+3."));
      Assert.assertTrue(isNumber("+.8"));
      Assert.assertTrue(isNumber("46.e3"));
      Assert.assertTrue(isNumber("-.3e6"));
   }
}

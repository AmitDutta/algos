package leetcodeoj;
import org.junit.*;
public class Problem13 {
   private int getInt(String s) {
      if (s.equals("I")) return 1;
      else if (s.equals("IV")) return 4;
      else if (s.equals("V")) return 5;
      else if (s.equals("IX")) return 9;
      else if (s.equals("X")) return 10;
      else if (s.equals("XL")) return 40;
      else if (s.equals("L")) return 50;
      else if (s.equals("XC")) return 90;
      else if (s.equals("C")) return 100;
      else if (s.equals("CD")) return 400;
      else if (s.equals("D")) return 500;
      else if (s.equals("CM")) return 900;
      else if (s.equals("M")) return 1000;
      return 0;
   }
   public int romanToInt(String s) {
      int result = 0;
      for (int i = 0 ; i < s.length();) {
         if (i < s.length() - 1) {
            if (getInt(s.substring(i, i + 2)) > 0) {
               result += getInt(s.substring(i, i + 2));
               i += 2; 
               continue;
            }
         }
         result += getInt(s.substring(i, i + 1));
         ++i;
      }
      return result;
   }
   @Test
   public void test1() {
      Assert.assertEquals(36, romanToInt("XXXVI"));
      Assert.assertEquals(2012, romanToInt("MMXII"));
      Assert.assertEquals(1996, romanToInt("MCMXCVI"));
      Assert.assertEquals(3999, romanToInt("MMMCMXCIX"));
   }
}

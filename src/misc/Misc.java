package misc;

import java.util.HashSet;
import java.util.Set;
import org.junit.*;

public class Misc {
   public static boolean isPangram(String s) {
      Set<Character> set = new HashSet<Character>();
      s = s.toLowerCase();
      for (int  i = 0; i < s.length(); ++i) {
         if (s.charAt(i) != ' ') {
            set.add(s.charAt(i));
         }
      }
      return set.size() == 26 ? true : false;
   }
   public static int numDigits(int num) {
      int digits = 0;
      for (long i  = 1; num / i > 0; i *= 10){
         digits++;
      }
      return  num == 0 ? 1 : digits;
   }
   @Test
   public void numDigitsTest() {
      Assert.assertEquals(1, numDigits(0));
      Assert.assertEquals(1, numDigits(5));
      Assert.assertEquals(4, numDigits(1599));
      Assert.assertEquals(10, numDigits(Integer.MAX_VALUE));
   }
}

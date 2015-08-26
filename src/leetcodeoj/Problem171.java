package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem171 {
   public int titleToNumber1(String s) {
      int result = 0;
      for (int i = 0; i < s.length(); ++i) {
         if (i > 0) result *= 26;
         result += (s.charAt(i) - 64);
      }
      return result;
   }

   public int titleToNumber(String s) {
      int result = 0;
      for (int i = 0; i < s.length(); ++i) {
          result = result * 26 + (s.charAt(i) - 64);
      }
      return result;
  }
   @Test
   public void Problem171Test() {
      Problem171 p171 = new Problem171();
      Assert.assertEquals(1, p171.titleToNumber("A"));
      Assert.assertEquals(26, p171.titleToNumber("Z"));
      Assert.assertEquals(52, p171.titleToNumber("AZ"));
      Assert.assertEquals(53, p171.titleToNumber("BA"));
      Assert.assertEquals(78, p171.titleToNumber("BZ"));
      Assert.assertEquals(79, p171.titleToNumber("CA"));
      Assert.assertEquals(81, p171.titleToNumber("CC"));
      Assert.assertEquals(703, p171.titleToNumber("AAA"));
      Assert.assertEquals(704, p171.titleToNumber("AAB"));
   }
}


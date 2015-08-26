package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem168 {
   // Tricky to prepare mod staff
   public String convertToTitle1(int n) {
      StringBuffer buffer = new StringBuffer();
      while (n > 0) {
         int code = (n % 26);
         char ch = code > 0 ? (char) (code + 64) : (char) (26 + 64);
         buffer.append(ch);
         n = n/26;
         if (code == 0) n = n - 1;
      }
      return buffer.reverse().toString();
   }
   
   public String convertToTitle(int n) {
      StringBuffer buffer = new StringBuffer();
      while (n > 26) {
          int p = n % 26;
          if (p == 0) {
              --n;
          }
          p = p == 0 ? 26 : p;
          char ch = (char) (64 + p);
          buffer.append(ch);
          n = n / 26;
      }
      n = n == 0 ? 26 : n;
      char ch = (char) (64 + n);
      buffer.append(ch);
      return buffer.reverse().toString();
  }
   
   @Test
   public void convertToTitleTest() {
      Problem168 p168 = new Problem168();
      Assert.assertEquals("A", p168.convertToTitle(1));
      Assert.assertEquals("Z", p168.convertToTitle(26));
      Assert.assertEquals("AZ", p168.convertToTitle(52));
      Assert.assertEquals("BA", p168.convertToTitle(53));
      Assert.assertEquals("BZ", p168.convertToTitle(78));
      Assert.assertEquals("CA", p168.convertToTitle(79));
      Assert.assertEquals("CC", p168.convertToTitle(81));
   }
}

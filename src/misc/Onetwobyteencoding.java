package misc;

import org.junit.*;

public class Onetwobyteencoding {
   // https://github.com/checkcheckzz/coding-questions/blob/master/problem/String/Onetwobyteencoding.cpp
   // lets assume the string contains only the msbs of the bytes, since we
   // only need msbs
   public int oneOrtwo(String str) {
      if (str.length() == 0) {
         return 0;
      }
      int k = str.length();
      if (str.charAt(k - 1) == '1') {
         return 2;
      }
      int result = 1;
      int i = k - 2;
      for (; i >= 0; --i) {
         if (str.charAt(i) == '0') {
            int p = k - i - 1;
            result = p % 2 == 0 ? 2 : 1;
            break;
         }
      }
      if (i < 0) {
         result = 1;
      }
      return result;
   }
   @Test
   public void test1() {
      Assert.assertEquals(2, oneOrtwo("111011"));
      Assert.assertEquals(1, oneOrtwo("0"));
      Assert.assertEquals(1, oneOrtwo("10"));
      Assert.assertEquals(1, oneOrtwo("0100"));
      Assert.assertEquals(2, oneOrtwo("101111"));
   }
}

package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem28 {
   public int strStr(String haystack, String needle) {
      if (needle.length() > haystack.length()) return -1;
      if (needle.equals("") && haystack.equals("")) return 0;
      int index = -1, i, j;
      i = j = 0;
      for (; i < haystack.length() - needle.length() + 1; ++i) {
         for (j = 0; j < needle.length(); ++j) {
            if (needle.charAt(j) != haystack.charAt(i + j)) {
               break;
            }
         }
         if (j == needle.length()) {
            index = i;
            break;
         }
      }
      return index;
   }
   
   @Test
   public void strStrTest() {
      Problem28 p28 = new Problem28();
      Assert.assertEquals(0, p28.strStr("", ""));
      Assert.assertEquals(0, p28.strStr("a", "a"));
      Assert.assertEquals(0, p28.strStr("amitdutta", "amit"));
      Assert.assertEquals(4, p28.strStr("amitdutta", "dutta"));
      Assert.assertEquals(-1, p28.strStr("asdasdasd", "zz"));
   }
}

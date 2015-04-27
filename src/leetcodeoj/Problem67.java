package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem67 {

   private char add(char ch1, char ch2) {
      return ch1 == ch2 ? '0' : '1';
   }

   // This can be written in very smart way, but for the time being ..
   public String addBinary(String a, String b) {
      StringBuffer buffer = new StringBuffer();
      String first = "", last = "";
      if (a.length() > b.length()) {
         first = a;
         last = b;
      }else {
         first = b;
         last = a;
      }
      char hand = '0';
      int i = 0, j = first.length() - 1;
      for (i = last.length() - 1; i >= 0; --i, --j) {
         char ch_first = first.charAt(j);
         char ch_last = last.charAt(i);
         char to_add = add(hand, add(ch_first, ch_last));
         buffer.append(to_add);
         if ((ch_first == '1' && ch_last == '1') || (ch_first != ch_last && hand == '1')) {
            hand = '1';
         }else {
            hand = '0';
         }
      }
      while (j >= 0) {
         buffer.append(add(first.charAt(j), hand));
         if (first.charAt(j) == '1' && hand == '1') {
            hand = '1';
         }else {
            hand = '0';
         }
         --j;
      }
      if (hand == '1') {
         buffer.append(hand);
      }
      return buffer.reverse().toString();
   }

   @Test
   public void addBinaryTest1() {
      Assert.assertEquals("100", addBinary("11", "1"));
      Assert.assertEquals("10", addBinary("1", "1"));
   }
   
   @Test
   public void addBinaryTest2() {
      Assert.assertEquals("10101", addBinary("1010", "1011"));
   }
   
   @Test
   public void addBinaryTest3() {
      Assert.assertEquals("110110", addBinary("100", "110010"));
   }
   
   @Test
   public void addBinaryTest4() {
      Assert.assertEquals("1001001", addBinary("110010", "10111"));
   }
}

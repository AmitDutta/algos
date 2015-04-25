package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem43 {
   public int toInt(char ch) {
      return ch - '0';
   }
   public String add(String num1, String num2) {
      StringBuffer result = new StringBuffer();
      if (num2.length() > num1.length()) {
         String temp = num1;
         num1 = num2;
         num2 = temp;
      }
      int i = num1.length() - 1, j = num2.length() - 1, hand = 0, cur = 0;
      while (i >= 0 && j >= 0) {
         cur = hand + toInt(num1.charAt(i)) + toInt(num2.charAt(j));
         hand = cur / 10;
         cur = cur % 10;
         result.append(cur);
         i--;
         j--;
      }
      if (j < 0) {
         while (i >= 0) {
            cur = hand + toInt(num1.charAt(i));
            hand = cur / 10;
            cur = cur % 10;
            result.append(cur);
            i--;
         }
      }
      if (hand > 0) result.append(hand);
      
      String value = result.reverse().toString();
      int k = 0;
      for (; k < result.length(); ++k) {
         if (value.charAt(k) != '0') {
            break;
         }
      }
      value = k == result.length() ?  "0" : result.substring(k);
      return value;  
   }
   public String multiply(String num1, String num2) {
      if (num2.length() > num1.length()) {
         String temp = num1;
         num1 = num2;
         num2 = temp;
      }
      String previous = "0";
      StringBuffer buffer;
      int cur, hand;
      cur = hand = 0;
      for (int i = num2.length() -1, turn = 0; i >= 0; --i, ++turn) {
         buffer = new StringBuffer();
         for (int j = num1.length() - 1; j >= 0; j--) {
            cur = hand + toInt(num2.charAt(i)) * toInt(num1.charAt(j));
            hand = cur / 10;
            cur = cur % 10;
            buffer.append(cur);
         }
         if (hand > 0) {
            buffer.append(hand);
            hand = 0;
         }
         int k = 1;
         buffer.reverse();
         while (k <= turn) {
            buffer.append("0");
            k++;
         }
         previous = add(buffer.toString(), previous);
      }
      return previous;
   }

   @Test
   public void multiplyTest() {
      Assert.assertEquals("999", multiply("999", "1"));
      Assert.assertEquals("0", multiply("999", "0"));
      Assert.assertEquals("26068", multiply("49", "532"));
      Assert.assertEquals("0", multiply("49", "0000000"));
      Assert.assertEquals("152399025", multiply("12345", "12345"));
   }
   
   @Test
   public void addTest() {
      Assert.assertEquals("1000", add("1", "999"));
      Assert.assertEquals("1000", add("999", "1"));
      Assert.assertEquals("1998", add("999", "999"));
      Assert.assertEquals("999", add("999", "0"));
      Assert.assertEquals("0", multiply("0", "0000"));
   }
}

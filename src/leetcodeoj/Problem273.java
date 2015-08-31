package leetcodeoj;

import org.junit.*;

// definitely need to refactor this code ..

public class Problem273 {
   private static String hundreds[] = {"", "Thousand", "Million", "Billion"};
   private static String ones[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
   private static String elevens[] = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                                       "Nineteen"};
   private static String tens[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   private String convert(int n) {
      if (n <= 0) return "";
      StringBuffer result = new StringBuffer();
      if (n >= 100) {
         int k = n / 100;
         result.append(ones[k] + " Hundred");
         n = n % 100;
         if (n > 0) {
            result.append(" ");
         }
      }
      if (n >= 11 && n <= 19) {
         result.append(elevens[n - 10]);
         return result.toString();
      } else if (n >= 20) {
         int k = n / 10;
         result.append(tens[k]);
         n = n % 10;
         if (n > 0) {
            result.append(" ");
         }
      } else if (n == 10) {
         result.append(tens[1]);
         return result.toString();
      }
      if (n > 0) {
         result.append(ones[n]);
      }
      return result.toString();
   }
   public String numberToWords(int num) {
      if (num == 0) return "Zero";
      String result = "";
      int k = 0;
      while (num / 1000 > 0) {
         int x = num % 1000;
         if (x > 0) {
            String part = convert(x);
            int ahead = (num / 1000) % 1000;
            if (ahead > 0) {
               result = " " + hundreds[++k] + " " + part + result;
            } else {
               result = " " + part + result;
               ++k;
            }
         } else {
            int ahead = (num / 1000) % 1000;
            if (ahead > 0) {
               result = " " + hundreds[++k] + result;
            } else {
               ++k;
            }
         }
         num /= 1000;
      }
      String part = convert(num % 1000);
      result = part + result;
      return result;
   }
   @Test
   public void test1() {
      Assert.assertEquals("Zero", numberToWords(0));
      Assert.assertEquals("One Hundred Twenty Three", numberToWords(123));
      Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", numberToWords(12345));
      Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", numberToWords(1234567));
      Assert.assertEquals("Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven",
                           numberToWords(Integer.MAX_VALUE));
   }
   @Test
   public void test2() {
      Assert.assertEquals("One Hundred One", numberToWords(101));
      Assert.assertEquals("Ten", numberToWords(10));
      Assert.assertEquals("One Thousand One", numberToWords(1001));
      Assert.assertEquals("One Million", numberToWords(1000000));
   }
   @Test
   public void test3() {
      Assert.assertEquals("One Million Ten", numberToWords(1000010));
      Assert.assertEquals("Three Million Fifty Five Thousand", numberToWords(3055000));
   }
}

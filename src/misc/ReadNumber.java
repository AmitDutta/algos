package misc;

import org.junit.*;
public class ReadNumber {
   // 19,120,515 break in 3 digits and compute each three..this is key
   private String[] nums = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
   private String[] nums1 = new String[] {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   private String[] numTeens = new String[] {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "NineTeen" };
   private String[] bigs = new String[] {"", "Thousands", "Million"};
   public String read(int number) {
      String result = "";
      int k = 0;
      if (number == 0) {
         return nums[number];
      }
      while (number > 0) {
         String tmp = convert100(number % 1000);
         result = tmp + bigs[k++] + result;
         number /= 1000;
      }
      return result;
   }
   // 515 525 500
   private String convert100(int num) {
      String result = "";
      if (num >= 100) {
         int k = num / 100;
         result += nums[k] + "Hundred";
         num = num % 100;
      }
      if (num >= 10) {
         if (num > 10 && num <= 19) {
            result += numTeens[num - 10];
            return result;
         }
         int k = num / 10;
         result += nums1[k];
         num = num % 10;
      }
      if (num > 0) {
         result += nums[num];
      }
      return result;
   }
   @Test
   public void test1() {
      Assert.assertEquals("OneHundred", read(100));
      Assert.assertEquals("TwentySix", read(26));
      Assert.assertEquals("Zero", read(0));
      Assert.assertEquals("NineTeenThousandsOneHundredFive", read(19105));
      Assert.assertEquals("OneHundredNineTeenThousandsOneHundredFive", read(119105));
      Assert.assertEquals("ElevenMillionOneHundredNineTeenThousandsOneHundredFive", read(11119105));
   }
}

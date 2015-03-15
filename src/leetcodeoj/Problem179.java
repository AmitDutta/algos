package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem179 {
   public class NumberComparator implements Comparator<String> {

      @Override
      public int compare(String o1, String o2) {
         String s1 = o1 + o2;
         String s2 = o2 + o1;
         return s1.compareTo(s2);
      }
      
   }
   public String largestNumber(int[] num) {
      StringBuffer buffer = new StringBuffer();
      String[] nums = new String[num.length];
      for (int i = 0; i < num.length; ++i) {
         nums[i] = Integer.toString(num[i]);
      }
      Arrays.sort(nums, Collections.reverseOrder(new NumberComparator()));
      for (int i = 0; i < nums.length; ++i) {
         buffer.append(nums[i]);
      }
      return buffer.length() == 0 ?
            "" :
            new java.math.BigInteger(buffer.toString()).toString();
      /*Following code is hassle. Instead we do above*/
      /*int i;
      for (i= 0; i < buffer.length(); ++i) {
         if (buffer.charAt(i) != '0') {
            break;
         }
      }
      
      if (i == buffer.length()) --i;
      return buffer.length() > 0 ? buffer.substring(i) : buffer.toString();*/
   }
   
   @Test
   public void largestNumberTest() {
      int[] num = new int[]{3, 30, 34, 5, 9};
      Problem179 p179 = new Problem179();
      Assert.assertEquals("9534330", p179.largestNumber(num));
      num = new int[]{9};
      Assert.assertEquals("9", p179.largestNumber(num));
      num = new int[]{};
      Assert.assertEquals("", p179.largestNumber(num));
      num = new int[] {0,0};
      Assert.assertEquals("0", p179.largestNumber(num));
   }
}

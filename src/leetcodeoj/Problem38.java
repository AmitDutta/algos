package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem38 {
   public String next(String str) {
      StringBuffer result = new StringBuffer();
      int count = 1;
      char cur = str.charAt(0);
      for (int i = 1; i < str.length(); ++i) {
         if (cur == str.charAt(i)) {
            count++;
         }else {
            result.append(count + "" + cur);
            cur =  str.charAt(i); 
            count = 1;
         }
      }
      result.append(count + "" + cur);
      return result.toString();
   }
   public String countAndSay(int n) {
      if (n == 1) return "1";
      int turn = 2;
      String num = "1";
      while (turn <= n) {
         num = next(num);
         ++turn;
      }
      return num;
   }

   @Test
   public void countAndSayTest() {
      Problem38 p38 = new Problem38();
      Assert.assertEquals("1", p38.countAndSay(1));
      Assert.assertEquals("11", p38.countAndSay(2));
      Assert.assertEquals("21", p38.countAndSay(3));
      Assert.assertEquals("1211", p38.countAndSay(4));
      Assert.assertEquals("111221", p38.countAndSay(5));
   }
}

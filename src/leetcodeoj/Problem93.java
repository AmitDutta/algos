package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Problem93 {
   private List<String> result;
   private boolean isValid(String s) {
      if (s.length() > 3) return false;
      int part = Integer.parseInt(s);
      if (part <= 9 && s.length() > 1) return false;
      if (part <= 99 && s.length() > 2) return false;
      return part <= 255;
   }
   private void restoreInt(String s, int start, List<String> buffer, int size) {
      if (buffer.size() == 4) 
      {
         if (size == s.length()) {
            StringBuffer address = new StringBuffer();
            for (int i = 0; i < buffer.size(); ++i) {
               address.append(buffer.get(i));
               if (i < buffer.size() - 1) {
                  address.append(".");
               }
            }
            result.add(address.toString());
         }
         return;
      }
      for (int len = 1; len <= 3; ++len) {
         if (start + len <= s.length()) {
            String part = s.substring(start, start + len);
            if (isValid(part)) {
               buffer.add(part);
               restoreInt(s, start + len, buffer, size + part.length());
               buffer.remove(buffer.size() - 1);
            }
         }
      }
   }
   public List<String> restoreIpAddresses(String s) {
      result = new ArrayList<String>();
      restoreInt(s, 0, new ArrayList<String>(), 0);
      return result;
   }
   @Test
   public void restoreIntTest1() {
      List<String> result = restoreIpAddresses("25525511135");
      List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
   @Test
   public void restoreIntTest2() {
      List<String> result = restoreIpAddresses("1111");
      List<String> expected = Arrays.asList("1.1.1.1");
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
   @Test
   public void restoreIntTest3() {
      List<String> result = restoreIpAddresses("010010");
      List<String> expected = Arrays.asList("0.10.0.10","0.100.1.0");
      for (String str : result) System.out.println(str);
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
}

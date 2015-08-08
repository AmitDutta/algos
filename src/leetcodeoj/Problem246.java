package leetcodeoj;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.*/
public class Problem246 {
   // interesting implementation
   public boolean strobogrammatic(String number) {
      Map<Character, Character> map = new HashMap<Character, Character>();
      map.put('6', '9');
      map.put('0', '0');
      map.put('1', '1');
      map.put('9', '6');
      map.put('8', '8');
      boolean result = true;
      for (int i = 0, j = number.length() -1; i < j; ++i, --j) {
         char ch1 = number.charAt(i);
         char ch2 = number.charAt(j);
         if (!map.containsKey(ch1) || !map.containsKey(ch2)) return false;
         if (ch2 != map.get(ch1) || ch1 != map.get(ch2)) return false;
      }
      return result;
   }
   @Test
   public void test1() {
      Assert.assertTrue(strobogrammatic("0"));
      Assert.assertTrue(strobogrammatic("1"));
      Assert.assertTrue(strobogrammatic("8"));
      Assert.assertTrue(strobogrammatic("11"));
      Assert.assertTrue(strobogrammatic("69"));
      Assert.assertTrue(strobogrammatic("88"));
      Assert.assertTrue(strobogrammatic("111"));
      Assert.assertTrue(strobogrammatic("181"));
      Assert.assertTrue(strobogrammatic("609"));
      Assert.assertFalse(strobogrammatic("525"));
   }
}

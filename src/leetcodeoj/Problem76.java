package leetcodeoj;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;

public class Problem76 {
   public String minWindow(String s, String t) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); ++i) {
         char ch = t.charAt(i);
         if (map.containsKey(ch)) {
            map.put(t.charAt(i), map.get(ch) + 1);
         } else {
            map.put(ch, 1);
         }
      }
      int len = 0, start = 0;
      String result = "";
      Map<Character, Integer> tmp = new HashMap<Character, Integer>();
      for (int i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (!map.containsKey(ch)) {
            continue;
         }
         if (tmp.containsKey(ch)) {
            tmp.put(ch, tmp.get(ch) + 1);
         } else {
            tmp.put(ch, 1);
         }
         if (tmp.get(ch) <= map.get(ch)) {
            len++;
         }
         if (len >= t.length()) {
            while (start <= i) {
               char ch2 = s.charAt(start);
               if (!map.containsKey(ch2)) {
                  start++;
                  continue;
               }
               if (tmp.get(ch2) > map.get(ch2)) {
                  tmp.put(ch2, tmp.get(ch2) - 1);
                  start++;
               } else {
                  break;
               }
            }
            if (result == "" || result.length() > i - start) {
               result = s.substring(start, i + 1);
            }
         }
      }
      return result;
   }
   
   @Test
   public void test1() {
      Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
      Assert.assertEquals("cba", minWindow("abbcbcba", "abc"));
      Assert.assertEquals("aa", minWindow("aa", "aa"));
      Assert.assertEquals("ba", minWindow("bba", "ab"));
   }
}

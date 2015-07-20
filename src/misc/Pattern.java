package misc;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;

public class Pattern {
   private Map<Character, String> map;
   private boolean matchInt(String pattern, String str) {
      if (pattern.length() == 0) {
         return str.length() == 0;
      }
      char pch = pattern.charAt(0);
      for (int i = 0; i < str.length(); ++i) {
         if (!map.containsKey(pch)) {
            String val = str.substring(0, i + 1);
            map.put(pch, val);
            if (matchInt(pattern.substring(1), str.substring(val.length()))) {
               return true;
            } else {
               map.remove(pch);
            }
         } else {
            String val = map.get(pch);
            if (!str.startsWith(val)) {
               return false;
            }
            return matchInt(pattern.substring(1), str.substring(val.length()));
         }
      }
      return false;
   }
   public boolean match(String pattern, String str) {
      map = new HashMap<Character, String>();
      return matchInt(pattern, str);
   }
   @Test
   public void test1() {
      Assert.assertTrue(match("aabb", "ABABCDCD"));
      Assert.assertTrue(match("abba", "redbluebluered"));
      Assert.assertTrue(match("abba", "asdasdasdasd"));
      Assert.assertFalse(match("aabb", "xyzabcxzyabc"));
      Assert.assertTrue(match("abba", "catdogdogcat"));
      Assert.assertTrue(match("abab", "ryry"));
      Assert.assertFalse(match("abba", " redblueredblue"));
   }
}
package hackerRank;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;

public class MakeAnagram {
   public int distance(String str1, String str2) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (int i = 0; i < str1.length(); ++i) {
         char ch = str1.charAt(i);
         if (!map.containsKey(ch)) {
            map.put(ch, 1);
         } else {
            map.put(ch, map.get(ch) + 1);
         }
      }
      for (int i = 0; i < str2.length(); ++i) {
         char ch = str2.charAt(i);
         if (!map.containsKey(ch)) {
            map.put(ch, -1);
         }else {
            map.put(ch, map.get(ch) - 1);
         }
      }
      int result = 0;
      for (Character key : map.keySet()) {
         if (map.get(key) != 0) {
            result += Math.abs(map.get(key));
         }
      }
      return result;
   }
   @Test
   public void test1() {
      Assert.assertEquals(4, distance("cde", "abc"));
      Assert.assertEquals(5, distance("abc", "aaaa"));
   }
}

package leetcodeoj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class Problem205 {
   public boolean isIsomorphic(String s, String t) {
      if (s.length() != t.length()) return false;
      Set<Character> set = new HashSet<Character>();
      boolean isomorphic = true;
      Map<Character, Character> map = new HashMap<Character, Character>();
      for (int i = 0; i < s.length(); ++i) {
         if (!map.containsKey(s.charAt(i))) {
            if (set.contains(t.charAt(i))) {
               isomorphic = false;
               break;
            } else {
               map.put(s.charAt(i), t.charAt(i));
               set.add(t.charAt(i));
            }
         } else {
            if (map.get(s.charAt(i)) != t.charAt(i)) {
               isomorphic = false;
               break;
            }
         }
      }
      return isomorphic;
   }
   
   @Test
   public void isIsomorphicTest1() {
      Assert.assertTrue(isIsomorphic("egg", "add"));
      Assert.assertFalse(isIsomorphic("foo", "bar"));
      Assert.assertTrue(isIsomorphic("", ""));
      Assert.assertTrue(isIsomorphic("paper", "title"));
      Assert.assertTrue(isIsomorphic("foo", "app"));
      Assert.assertTrue(isIsomorphic("axx", "boo"));
   }
}

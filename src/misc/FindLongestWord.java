package misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.*;

// Given a list of words, find longest word that can be formed from the
// words in list
// http://www.ardendertat.com/2012/06/15/programming-interview-questions-28-longest-compound-word/
public class FindLongestWord {
   private Set<String> set;
   private Map<String, Boolean> map;
   public class LengthComparator implements Comparator<String> {
      @Override
      public int compare(String o1, String o2) {
         return o2.length() - o1.length();
      }
   }
   public String getLongest(List<String> words) {
      //set = new HashSet<String>();
      map = new HashMap<String, Boolean>();
      for (String word : words) {
         //set.add(word);
         map.put(word, true);
      }
      Collections.sort(words, new LengthComparator());
      for (String s : words) {
         if (canBreak(s, true)) {
            return s;
         }
      }
      return "";
   }
   // Need to make sure we do not return just chekcing original, we need to
   // check parts
   public boolean canBreak1(String str, String original) {
      if (!str.equals(original) && set.contains(str)) {
         return true;
      }
      for (int i = 0; i < str.length(); ++i) {
         String left = str.substring(0, i + 1);
         String right = str.substring(i + 1);
         if (set.contains(left) && canBreak1(right, original)) {
            return true;
         }
      }
      return false;
   }
   public boolean canBreak(String str, boolean original) {
      if (!original && map.containsKey(str)) {
         return map.get(str);
      }
      for (int i = 0; i < str.length(); ++i) {
         String left = str.substring(0, i + 1);
         String right = str.substring(i + 1);
         if (map.containsKey(left) && map.get(left) && canBreak(right, false)) {
            return true;
         }
      }
      map.put(str,  false); // dp
      return false;
   }
   @Test
   public void test1() {
      List<String> lst = Arrays.asList("cat", "banana", "dog", "nana", "walk", "walker", "dogwalker");
      Assert.assertEquals("dogwalker", getLongest(lst));
   }
   @Test
   public void test2() {
      List<String> lst = Arrays.asList("cat", "cats", "catsdogcats", "catxdogcatsrat", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcat", "ratcatdog", "ratcatdogcat");
      Assert.assertEquals("ratcatdogcat", getLongest(lst));
   }
}

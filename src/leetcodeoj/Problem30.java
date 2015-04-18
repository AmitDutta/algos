package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;

public class Problem30 {
   
   // definitely not a good solution
   public boolean canParse(String str, Map<String, Integer> dict, int word) {
      boolean canParse = true;
      int len = 0;
      Map<String, Integer> map = new HashMap<String, Integer>();
      for (Map.Entry<String, Integer> entry : dict.entrySet()) {
         map.put(entry.getKey(), entry.getValue());
      }

      for (int i = 0; i <= str.length() - word; i += word) {
         String subStr = str.substring(i, i + word);
         if (!map.containsKey(subStr)) {
            canParse = false;
            break;
         }
         map.put(subStr, map.get(subStr) - 1);
         if (map.get(subStr) <= 0) {
            map.remove(subStr);
         }
         len += word;
      }
      if (len < dict.size()) {
         canParse = false;
      }
      return canParse;
   }
   public List<Integer> findSubstring(String S, List<String> L) {
      List<Integer> result = new ArrayList<Integer>();
      Map<String, Integer> set = new HashMap<String, Integer>();
      for (String str : L) {
         if (!set.containsKey(str)) {
            set.put(str, 1);
         }else {
            set.put(str, set.get(str) + 1);
         }
      }
      int word = L.get(0).length();
      int total = word * L.size();
      for (int i = 0; i <= S.length() - total; ++i) {
         String sub = S.substring(i, i + total);
         if (canParse(sub, set, word)) {
            result.add(i);
            //i += total;
         }else {
            //i++;
         }
      }
      return result;
   }
   
   @Test
   public void Problem30Test1() {
      Problem30 p30 = new Problem30();
      List<String> dict = Arrays.asList("foo", "bar");
      String S = "barfoothefoobarman";
      List<Integer> expected = Arrays.asList(0, 9);
      List<Integer> actual = p30.findSubstring(S, dict);
      Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
   }
   
   @Test
   public void Problem30Test2() {
      Problem30 p30 = new Problem30();
      List<String> dict = Arrays.asList("foo", "bar");
      String S = "asdeqwefoobaraqweqfoofoobar";
      List<Integer> expected = Arrays.asList(7, 21);
      List<Integer> actual = p30.findSubstring(S, dict);
      Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
   }
   
   @Test
   public void Problem30Test3() {
      Problem30 p30 = new Problem30();
      List<String> dict = Arrays.asList("fooo","barr","wing","ding","wing");
      String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
      List<Integer> expected = Arrays.asList(13);
      List<Integer> actual = p30.findSubstring(S, dict);
      Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
   }
   
   @Test
   public void Problem30Test4() {
      Problem30 p30 = new Problem30();
      List<String> dict = Arrays.asList("a","a");
      String S = "aaa";
      List<Integer> expected = Arrays.asList(0, 1);
      List<Integer> actual = p30.findSubstring(S, dict);
      Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
   }
}

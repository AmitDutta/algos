package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

/**
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 *
 * Examples:
 *
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 *
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 *
 */
public class Problem269 {
   private List<Integer>[] adj;
   private StringBuffer buffer;
   private Map<Integer, Boolean> map;
   private void dfs(int i) {
      map.put(i, true);
      if (adj[i] != null) {
         for (int child : adj[i]) {
            if (!map.get(child)) {
               dfs(child);
            }
         }
      }
      char ch = (char) (i + 'a');
      buffer.append(ch);
   }
   public String alienOrder (List<String> words) {
      adj = (ArrayList<Integer>[]) new ArrayList[26];
      for (int i = 0; i < 26; ++i) {
         adj[i] = new ArrayList<Integer>();
      }
      for (int i = 0; i < 26; ++i) 
      buffer = new StringBuffer();
      map = new HashMap<Integer, Boolean>();
      for (int i = 1; i < words.size(); ++i) {
         String prev = words.get(i - 1);
         String current = words.get(i);
         int j = 0, limit = Math.min(current.length(), prev.length());
         while (j < limit) {
            if (prev.charAt(j) != current.charAt(j)) {
               int previ = prev.charAt(j) - 'a';
               int curi = current.charAt(j) - 'a';
               adj[previ].add(curi);
               if (!map.containsKey(previ)) {
                  map.put(previ, false);
               }
               if (!map.containsKey(curi)) {
                  map.put(curi, false);
               }
               break;
            }
            j++;
         }
      }
      for (int key : map.keySet()) {
         if (!map.get(key)) {
            dfs(key);
         }
      }
      return buffer.reverse().toString();
   }
   
   @Test
   public void test1() {
      List<String> words = Arrays.asList("baa", "abcd", "abca", "cab", "cad");
      Assert.assertEquals("bdac", alienOrder(words));
   }
   @Test
   public void test2() {
      List<String> words = Arrays.asList("caa", "aaa", "aab");
      Assert.assertEquals("cab", alienOrder(words));
   }
   @Test
   public void test3() {
      List<String> words = Arrays.asList("wrt","wrf","er","ett","rftt");
      Assert.assertEquals("wertf", alienOrder(words));
   }
}


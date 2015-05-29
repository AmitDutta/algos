package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class Problem127 {
   private Set<String> dict;
   private List<String> getNeighbours(String str) {
      List<String> items = new ArrayList<String>();
      for (int i = 0; i < str.length(); ++i) {
         char[] chars = str.toCharArray();
         for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (ch != str.charAt(i)) {
               chars[i] = ch;
               String item = new String(chars);
               if (dict.contains(item)) {
                  items.add(item);
                  dict.remove(item);
               }
            }
         }
      }
      return items;
   }
   public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
      dict = wordDict;
      dict.add(endWord);
      if (beginWord.equals(endWord)) return 0;
      Queue<String> queue = new LinkedList<String>();
      queue.add(beginWord);
      int current = 1, hops = 1, next = 0;
      boolean found = false;
      while (queue.size() > 0) {
         String node = queue.poll();
         current--;
         if (node.equals(endWord)) {
            found = true;
            break;
         }
         List<String> children = getNeighbours(node);
         for (String child : children) {
            queue.add(child);
            next++;
         }
         if (current == 0) {
            current = next;
            next = 0;
            hops++;
         }
      }
      return found ? hops : 0;
   }

   @Test
   public void ladderLengthTest1() {
      Problem127 p27 = new Problem127();
      Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
      Assert.assertEquals(5, p27.ladderLength("hit", "cog", dict));
      Assert.assertEquals(2, p27.ladderLength("dog", "cog", dict));
   }
   
   @Test
   public void ladderLengthTest2() {
      Problem127 p27 = new Problem127();
      Set<String> dict = new HashSet<String>(Arrays.asList("a","b","x","d","e"));
      Assert.assertEquals(2, p27.ladderLength("a", "x", dict));
   }
   
   @Test
   public void ladderLengthTest3() {
      Problem127 p27 = new Problem127();
      Set<String> dict = new HashSet<String>(Arrays.asList("hot","dog"));
      Assert.assertEquals(0, p27.ladderLength("hot", "dog", dict));
   }
}

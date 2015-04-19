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

  /* private List<String> getNeighbours(String str) {
      List<String> neighbours = new ArrayList<String>();
      for (char ch = 'a'; ch <= 'z'; ++ch) {
         for (int i = 0; i < str.length(); ++i) {
            if (ch != str.charAt(i)) {
               String candidate = str.substring(0, i) + ch + str.substring(i+1);
               neighbours.add(candidate);
               
            }
         }
      }
      return neighbours;
   }*/
   
   private List<String> getNeighbours(String str) {
      List<String> neighbours = new ArrayList<String>();
      char input[] = str.toCharArray();
      for (int i = 0; i < input.length; ++i) {
         char orig = input[i];
         for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (ch != orig) {
               input[i] = ch;
               neighbours.add(new String(input));
            }
            
         }
         input[i] = orig;
      }
      return neighbours;
   }

   // This is very simple problem.. Keep that in mind
   public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
      int current, next, levels;
      current = next = levels = 0;
      // Without using used set, got TLE. Basically, in one ladder, there will
      // be no repetation of strings
      Set<String> used = new HashSet<String>();
      Queue<String> queue = new LinkedList<String>();
      queue.offer(beginWord);
      used.add(beginWord);
      current = 1;
      levels = 0;
      boolean found = false;
      while (queue.size() > 0) {
         String str = queue.poll();
         current--;

         List<String> neighbours = getNeighbours(str);
         /*if (neighbours.contains(endWord)) {
            found = true;
         }*/

         for (String child : neighbours) {
            if (child.equals(endWord)) {
               found = true;
            }
            if (wordDict.contains(child) && !used.contains(child)) {
               queue.offer(child);
               used.add(child);
               next++;
            }
         }

         if (current == 0) {
            current = next;
            next = 0;
            levels++;
            if (found) break;
         }
      }
      return found ? levels + 1: 0;
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

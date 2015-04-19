package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class Problem128 {

   private class Node {
      private Node parent;
      private String value;
      public Node (String value) {
         this.value = value;
         parent = null;
      }
   }
   
   // Remember this way of replacing..using tochararray
   private List<String> getNeighbours(String str, Set<String> dict) {
      List<String> neighbours = new ArrayList<String>();
      char input[] = str.toCharArray();
      for (int i = 0; i < input.length; ++i) {
         char orig = input[i];
         for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (ch != orig) {
               input[i] = ch;
               String s = new String(input);
               if (dict.contains(s)) {
                  neighbours.add(s);
               }
            }
         }
         input[i] = orig;
      }
      return neighbours;
   }

   List<String> getPath(Node node) {
      List<String> path = new ArrayList<String>();
      while (node != null) {
         path.add(node.value);
         node = node.parent;
      }
      Collections.reverse(path);
      return path;
   }

   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
      List<List<String>> result = new ArrayList<List<String>>();
      int current, next, levels, maxLevel = Integer.MAX_VALUE;
      Node node = new Node(start);
      Set<String> set = new HashSet<String>();
      // add end to dict
      dict.add(end);
      Queue<Node> queue = new LinkedList<Node>();
      queue.offer(node);
      current = 1; levels = 0; next = 0;
      while (queue.size() > 0) {
         node = queue.poll();
         current--;
         List<String> neighbours = getNeighbours(node.value, dict);
         for (String child : neighbours) {
            // child will have end since added end in dict
            if (child.equals(end)) {
               maxLevel = levels;
               List<String> path = getPath(node);
               path.add(end);
               result.add(path);
            }
            
            if (dict.contains(child)) {
               if (child == node.value) continue;
               Node childNode = new Node(child);
               childNode.parent = node;
               queue.offer(childNode);
               set.add(child);
               next++;
            }
         }
         
         if (current == 0) {
            dict.removeAll(set); // This line saves from TLE..Dictionary
            // lookup is not free at all when large number of items are
            // there..took me hours to see
            set = new HashSet<String>();
            current = next;
            next = 0;
            if (levels >= maxLevel) {
               break;
            }else {
               levels++;
            }
         }
      }
      return result;
   }
   
   @Test
   public void ladderLengthTest1() {
      Problem128 p28 = new Problem128();
      Set<String> dict = new HashSet<String>(Arrays.asList("a","b","a","c"));
      List<List<String>> result = p28.findLadders("a", "c", dict);
      for (List<String> lst : result) {
         for (String str : lst) {
            System.out.print(str + " ");
         }
         System.out.println();
      }
   }
   
   @Test
   public void ladderLengthTest2() {
      Problem128 p28 = new Problem128();
      Set<String> dict = new HashSet<String>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
      List<List<String>> result = p28.findLadders("red", "tax", dict);
      for (List<String> lst : result) {
         for (String str : lst) {
            System.out.print(str + " ");
         }
         System.out.println();
      }
   }
}

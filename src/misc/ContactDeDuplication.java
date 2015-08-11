package misc;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of contacts with phone numbers/emails you should detect and union identical contacts. 

   For example, given the following contacts array: 

   [ [ "John", "john@gmail.com", "john@fb.com"], 
   [ "Dan", "dan@gmail.com", "+1234567"], 
   [ "john123", "+5412312", "john123@skype.com"], 
   [ "john1985", "+5412312", "john@fb.com"] ] 

   We can see that john1985, John and john123 are the same person by their contact information. 

   We should output 

   [[ 0, 2, 3], [1]] (0,2,3 are the same person and 1 is another one)
 * 
 * 
 * */

public class ContactDeDuplication {
   private class Node {
      private List<String> info;
      private int id;
      private List<Node> children;
      public Node (List<String> info, int id) {
         this.info = new ArrayList<String>(info);
         this.id = id;
         children = new ArrayList<Node>();
      }
   }
   private Map<String, Node> map;
   private Set<Node> visited;
   private List<Node> nodes;
   
   public void dfs(Node node) {
      visited.add(node);
      for (Node child : node.children) {
         if (!visited.contains(child)) {
            dfs(child);
         }
      }
   }
   
   public int dedup(List<List<String>> contacts) {
      int uuid = 0;
      int count = 0;
      map = new HashMap<String, Node>();
      visited = new HashSet<Node>();
      nodes = new ArrayList<Node>();
      for (int i = 0; i < contacts.size(); ++i) {
         List<String> info = contacts.get(i);
         Node node = new Node(info, ++uuid);
         nodes.add(node);
         for (String str : info) {
            if (!map.containsKey(str)) {
               map.put(str, node);
            } else {
               map.get(str).children.add(node);
               // we do not need to keep track of all
               //node, later we will do dfs..just connect with one
            }
         }
      }
      // graph is built in O(N) .. just run dfs and count connected component
      for (Node node : nodes) {
         if (!visited.contains(node)) {
            dfs(node);
            count++;
         }
      }
      return count;
   }
   
   @Test
   public void test1() {
      // name, email, phone or any format
      List<String> lst1 = Arrays.asList("amit", "amit.856@gmail.com", "");
      List<String> lst2 = Arrays.asList("ashit", "ashit.bd@gmail.com", "123");
      List<String> lst3 = Arrays.asList("ad", "amit.856@gmail.com", "205413");
      List<String> lst4 = Arrays.asList("", "mt_dutta@yahoo.com", "205413");
      List<String> lst5 = Arrays.asList("ashit dutta", "ashit.bd@gmail.com", "123");
      List<String> lst6 = Arrays.asList("efd", "s.bd@gmail.com", "1d23");
      List<List<String>> contacts = Arrays.asList(lst1, lst2, lst3, lst4, lst5, lst6);
      Assert.assertEquals(3, dedup(contacts));
   }
}

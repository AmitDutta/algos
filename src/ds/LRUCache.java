package ds;

import java.util.HashMap;
import java.util.Map;

// All operation is O(1)
public class LRUCache {
   private class Node {
      private Node next, prev;
      int key, value;
      public Node(int key, int value) {
          this.key = key;
          this.value = value;
          next = prev = null;
      }
      public Node() {
         next = prev = null;
      }
   }
   private int capacity = 0;
   private Map<Integer, Node> map;
   private Node head, tail;
   private int size = 0;
   public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<Integer, Node>();
      head = new Node();
      tail = new Node();
      head.next = tail;
      tail.prev = head;
   }
   public int get(int key) {
      if (!map.containsKey(key)) {
         return -1;
      }
      Node node = map.get(key);
      /*Fix node neighbors*/
      node.prev.next = node.next;
      node.next.prev = node.prev;
      /*Add before tail*/
      tail.prev.next = node;
      node.prev = tail.prev;
      node.next = tail;
      tail.prev = node;
      return node.value;
   }
   public void set(int key, int value) {
      Node node = null;
      if (map.containsKey(key)) {
         get(key);
         // update value
         Node found = map.get(key);
         found.value = value;
         return;
      } else {
         node = new Node(key, value);
         map.put(key, node);
      }
      // Add before tail
      tail.prev.next = node;
      node.prev = tail.prev;
      node.next = tail;
      tail.prev = node;
      size++;
      if (size > capacity) {
         // just advance head
         Node skipped = head.next;
         Node nd = head.next.next;
         head.next = nd;
         nd.prev = head;
         map.remove(skipped.key);
         skipped = null;
      }
   }
   @Override
   public String toString() {
      StringBuffer buffer = new StringBuffer();
      Node cur = head.next;
      while (cur != tail) {
         buffer.append("(" + cur.key + "," + cur.value + ")");
         cur = cur.next;
      }
      return buffer.toString();
   }
}

package ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;

public class BST <Key extends Comparable<Key>, Value>{
   public class Node {
      private Key key;
      private Value value;
      private int count;
      private Node left, right;
      public Node(Key key, Value value) {
         this.key = key;
         this.value = value;
         count = 1;
         left = right = null;
      }
   }
   private Node root;
   public void put(Key key, Value value) {
      if (root == null) {
         root = new Node(key, value);
      } else {
         Node prev = null;
         Node cur = root;
         while (cur != null) {
            prev = cur;
            int cmp = key.compareTo(cur.key);
            cur.count++;
            if (cmp > 0) {
               cur = cur.right;
            } else {
               cur = cur.left;
            }
         }
         Node newNode = new Node(key, value);
         int cmp = newNode.key.compareTo(prev.key);
         if (cmp > 0) {
            prev.right = newNode;
         } else {
            prev.left = newNode;
         }
      }
   }
   
   public void putAll(Key[] keys, Value[] values) {
      for (int i = 0; i < keys.length; ++i) {
         put(keys[i], values[i]);
      }
   }
   
   /* If item is found, return item. Else return smallest item larger
    * than the item. */
   public Key celing(Key key) {
      Node cur = root;
      Node prev = null;
      while (cur != null) {
         int cmp = key.compareTo(cur.key);
         if (cmp == 0) {
            return cur.key;
         }
         if (cmp > 0) {
            cur = cur.right;
         } else {
            prev = cur;
            cur = cur.left;
         }
      }
      return prev.key;
   }
   
   public int size() {
      return size(root);
   }
   
   private int size(Node node) {
      return node == null ? 0 : node.count;
   }
   /* If item is found, return item. Else return largest item smaller
    * than the item. */
   public Key floor(Key key) {
      Node cur = root;
      Node prev = null;
      while (cur != null) {
         int cmp = key.compareTo(cur.key);
         if (cmp == 0) {
            return cur.key;
         }
         if (cmp > 0) {
            prev = cur;
            cur = cur.right;
         } else {
            cur = cur.left;
         }
      }
      return prev.key;
   }

   // how many nodes smaller than k? not including k
   public int rank(Key k) {
      Node cur = root;
      int rank = 0;
      while (cur != null) {
         int cmp = k.compareTo(cur.key);
         if (cmp == 0) {
            rank += size(cur.left);
            break;
         }
         if (cmp > 0) {
            rank += 1 + size(cur.left);
            cur = cur.right;
         } else {
            cur = cur.left;
         }
      }
      return rank;
   }
   
   public Iterable<Key> iterator() {
      Queue<Key> queue = new LinkedList<Key>();
      Stack<Node> stack = new Stack<Node>();
      boolean done = false;
      Node cur = root;
      while (!done) {
         while (cur != null) {
            stack.push(cur);
            cur = cur.left;
         }
         if (stack.empty()) {
            done = true;
            break;
         }
         Node k = stack.pop();
         queue.add(k.key);
         if (k.right != null) {
            cur = k.right;
         }
      }
      return queue;
   }
   
   // This is based on left subtree size. If there is one node, left
   // subtree size is zero. See the tests, index is zero based
   private Node kthSmallest(int k, Node node) {
      if (node == null) {
         return null;
      }
      int t = size(node.left);
      if (t > k) {
         return kthSmallest(k, node.left);
      } else if (t < k) {
         return kthSmallest(k - t - 1, node.right);
      } else {
         return node;
      }
   }
   
   public Key kthSmallest(int k) {
      return kthSmallest(k, root).key;
   }
   
   // serialize a bst. note that, it can be done with {pre,in} or {post, in}
   // but only pre is sufficient as well, since it is possible to uniquely
   // identify bst with a pre order traversal. How? the sequence we insert the data
   // in bst, is a pre order traversal. so, if we just write the prorder traversal
   // that is enough..it is possible to uniquely generate bst with preorder
   public Key[] serialize() {
      List<Key> keys = new ArrayList<Key>();
      Stack<Node> stack = new Stack<Node>();
      if (root != null) {
         stack.push(root);
      }
      while (!stack.isEmpty()) {
         Node node = stack.pop();
         keys.add(node.key);
         if (node.right != null) {
            stack.push(node.right);
         }
         if (node.left != null) {
            stack.push(node.left);
         }
      }
      return (Key[]) keys.toArray();
   }
   private int i = 0;
   /*private void deserializeInt(Key[] keys, int i, int min, int max) {
      if (keys[i] > min && keys[i] < max) {
         
      }
   }
   public Node deserialize(Key[] keys) {
      i = 0;
      deserializeInt(keys, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
      return root;
   }*/
}

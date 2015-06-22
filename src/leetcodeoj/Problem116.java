package leetcodeoj;

import java.util.LinkedList;
import java.util.Queue;

// With bfs, its easy. Here I did with depth limited dfs
public class Problem116 {
   public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
   }
   private TreeLinkNode prev = null;
   public void connectInt(TreeLinkNode root, int cur, int max) {
      if (cur > max) return;
      if (root == null) return;
      if (cur == max) {
         if (prev != null && prev.next == null) {
            prev.next = root;
         }
         prev = root;
         return;
      }
      if (root.left != null && root.right != null) {
         root.left.next = root.right;
      }
      
      connectInt(root.left, cur + 1, max);
      connectInt(root.right, cur + 1, max);
   }
   
   public void connect(TreeLinkNode root) {
      int height = getHeight(root);
      int i = 1;
      while (i <= height) {
         prev = null;
         connectInt(root, 1, i);
         i++;
      }
   }
   
   // since perfect binary tree, to get height we traverse only one direction
   public int getHeight(TreeLinkNode tn) {
      if (tn == null) return 0;
      return 1 + Math.max(getHeight(tn.left), getHeight(tn.right));
   }
   
   void print (TreeLinkNode tn) {
      if (tn == null) return;
      TreeLinkNode cur = tn;
      while (cur != null) {
         System.out.print(cur.val + "->");
         cur = cur.next;
      }
      System.out.println();
      print(tn.left);
   }
   
   // For complete tree only
   public void connectCompleteTree(TreeLinkNode root) {
      if (root == null) {
          return;
      }
      if (root.left != null && root.right != null) {
          root.left.next = root.right;
          if (root.next != null) {
              root.right.next = root.next.left;
          }
      }
      connect(root.left);
      connect(root.right);
  }

   // This is O(n) space, did not read the question properly !!
   public void connect1(TreeLinkNode root) {
      if (root == null) return;
      Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
      TreeLinkNode prev = null;
      queue.offer(root);
      int current = 1, next = 0;
      while (queue.size() > 0) {
         TreeLinkNode node = queue.poll();
         if (prev != null) {
            prev.next = node;
         }
         prev = node;
         current--;
         if (node.left != null) {
            queue.offer(node.left);
            next++;
         }
         if (node.right != null) {
            queue.offer(node.right);
            next++;
         }
         if (current == 0) {
            node.next = null;
            prev = null;
            current = next;
            next = 0;
         }
      }
   }
}

package ds;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class TreeNode {
   public int val;
   public TreeNode left, right;
   public TreeNode(int data) {
      this.val = data;
      left = right = null;
   }

   public TreeNode(int data, TreeNode left, TreeNode right) {
      this.val = data;
      this.left = left;
      this.right = right;
   }

   public int getData() { 
      return this.val;
   }

   public TreeNode getLeft() {
      return this.left;
   }

   public TreeNode getRight() {
      return this.right;
   }

   public void setLeft(TreeNode node) {
      this.left = node;
   }

   public void setRight(TreeNode node) {
      this.right = node;
   }
   
   public List<List<Integer>> toLevelOrder() {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(this);
      int current = 1, next = 0;
      List<Integer> lst = new ArrayList<Integer>();
      while (queue.size() > 0) {
         TreeNode node = queue.poll();
         lst.add(node.val);
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
            current = next;
            next = 0;
            result.add(lst);
            lst = new ArrayList<Integer>();
         }
      }
      return result;
   }
}

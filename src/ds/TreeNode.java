package ds;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

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

   public static List<List<Integer>> toLevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
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

   public static String toPreOrder(TreeNode node) {
      StringBuffer buffer = new StringBuffer();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      stack.push(node);
      while (!stack.empty()) {
         TreeNode nd = stack.pop();
         buffer.append(nd.val);
         if (nd.left == null) {
            buffer.append('#');
         }
         if (nd.right == null) {
            buffer.append('#');
         } else {
            stack.push(nd.right);
         }
         if (nd.left != null) {
            stack.push(nd.left);
         }
      }
      return buffer.toString();
   }
   private static TreeNode fromPreOrderInt(String str, int[] i) {
      if (i[0] >= str.length()) {
         return null;
      }
      if (str.charAt(i[0]) == '#') {
         i[0]++;
         return null;
      }
      TreeNode node = new TreeNode(str.charAt(i[0]) - '0');
      i[0]++;
      node.left = fromPreOrderInt(str, i);
      node.right = fromPreOrderInt(str, i);
      return node;
   }
   public static TreeNode fromPreOrder(String str) {
      return fromPreOrderInt(str, new int[]{0});
   }
}

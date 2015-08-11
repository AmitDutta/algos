package leetcodeoj;

import ds.TreeNode;

import org.junit.*;

public class Problem156 {
   private TreeNode result;
   private TreeNode flipInt(TreeNode root) {
      if (root == null) {
         return null;
      }
      if (root.left == null && root.right == null) {
         return root;
      }
      TreeNode left = flipInt(root.left);
      TreeNode right = flipInt(root.right);
      // Free root, otherwise infinite loop!
      root.left = null;
      root.right = null;
      left.right = root;
      left.left = right;
      if (result == null) {
         result = left;
      }
      return root;
   }
   
   public TreeNode flip(TreeNode root) {
      flipInt(root);
      return result;
   }
   @Test
   public void test1() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      node1.left = node2;
      node1.right = node3;
      node2.left = node4;
      node2.right = node5;
      TreeNode result = flip(node1);
      TreeNode.toLevelOrderPrint(result);
   }
}

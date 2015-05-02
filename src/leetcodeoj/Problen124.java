package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problen124 {
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode (int x) { val = x; }
   }
   private int cost;
   
   public int visitInt(TreeNode node) {
      if (node == null) {
         return 0;
      }
      return node.val + Math.max(visitInt(node.left), visitInt(node.right));
   }
   public int visit(TreeNode node) {
      if (node == null) {
         return 0;
      }
      return node.val +  visitInt(node.left) + visitInt(node.right);
   }
   // While this is valid, this is O(n^2). Whenever there is situation
   // like this, we require to consider 
   public void inorder(TreeNode root) {
      if (root == null) return;
      inorder(root.left);
      int current = visit(root);
      if (current > cost) {
         cost = current;
      }
      inorder(root.right);
   }
   public int maxPathSum1(TreeNode root) {
      cost = Integer.MIN_VALUE;
      inorder(root);
      return cost;
   }
   
   public int postorder(TreeNode root) {
      if (root == null) {
         return 0;
      }
      int left = Math.max(0, postorder(root.left)); // if left is negative, we dont add anything..
      int right = Math.max(0, postorder(root.right));
      cost = Math.max(cost, left + root.val + right);
      return Math.max(root.val + left, root.val + right);
   }
   // Runtime O(n
   public int maxPathSum(TreeNode root) {
      cost = Integer.MIN_VALUE;
      postorder(root);
      return cost;
   }
   @Test
   public void maxPathSumTest1() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      node1.left = node2;
      node1.right = node3;
      Assert.assertEquals(6, maxPathSum(node1));
   }
   
   @Test
   public void maxPathSumTest2() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      TreeNode node6 = new TreeNode(6);
      TreeNode node7 = new TreeNode(7);

      node2.left = node4;
      node2.right = node5;

      node3.left = node6;
      node3.right = node7;

      node1.left = node2;
      node1.right = node3;

      Assert.assertEquals(18, maxPathSum(node1));
   }
   
   @Test
   public void maxPathSumTest3() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4000);
      TreeNode node5 = new TreeNode(5000);
      TreeNode node6 = new TreeNode(6);
      TreeNode node7 = new TreeNode(7);

      node2.left = node4;
      node2.right = node5;

      node3.left = node6;
      node3.right = node7;

      node1.left = node2;
      node1.right = node3;

      Assert.assertEquals(9002, maxPathSum(node1));
   }
}

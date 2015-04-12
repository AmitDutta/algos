package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem112 {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
   // http://cslibrary.stanford.edu/110/BinaryTrees.html#s2
   // Valid to me but not to leetcode
   private boolean hasPathSumInt2(TreeNode root, int sum) {
      if (root == null) return sum == 0;
      int cur_sum = sum - root.val;
      return hasPathSumInt2(root.left, cur_sum) || hasPathSumInt2(root.right, cur_sum);
   }
   
   public boolean hasPathSum1(TreeNode root, int sum) {
      if (root == null) return false;
      return hasPathSumInt2(root, sum);
   }
   
   // Surprising, they are thinking that 1->2 does not have a path sum 1 !!
   public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) return false;
      int cur_sum = sum - root.val;
      if (root.left == null && root.right == null) {
         return cur_sum == 0;
      }
      return hasPathSum(root.left, cur_sum) || hasPathSum(root.right, cur_sum);
   }
   
   @Test
   public void hasPathSumTest1() {
      Problem112 p112 = new Problem112();
      TreeNode node1 = null;
      Assert.assertFalse(p112.hasPathSum(node1, 0)); // critical case
   }
   
   @Test
   public void hasPathSumTest2() {
      Problem112 p112 = new Problem112();
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      node1.left = node2;
      Assert.assertFalse(p112.hasPathSum(node1, 1)); // critical case
   }
}

package leetcodeoj;

import ds.TreeNode;
import org.junit.*;

// Univalue tree..kind of like cluster, but cluster can be
// formed in middle, but univalue tree is not
public class Problem250 {
   private int count;
   private boolean uniInt(TreeNode node) {
      if (node == null) return true;
      boolean left = uniInt(node.left);
      boolean right = uniInt(node.right);
      boolean result = left & right;
      if (node.left != null && node.val != node.left.val) {
         result = false;
      }
      if (node.right != null && node.val != node.right.val) {
         result = false;
      }
      if (!result) {
         if (left) count++;
         if (right) count++;
      }
      return result;
   }
   public int univalue(TreeNode node) {
      count = 0;
      boolean val = uniInt(node);
      if (val) {
         count++;
      }
      return count;
   }
   
   @Test
   public void test1() {
      TreeNode node1 = new TreeNode(5);
      Assert.assertEquals(1, univalue(node1));
   }
   @Test
   public void test2() {
      TreeNode node = new TreeNode(5);
      for (int i = 0; i < 5; ++i) {
         node.left = new TreeNode(5);
         node = node.left;
      }
      Assert.assertEquals(1, univalue(node));
   }
   @Test
   public void test3() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(1);
      TreeNode node3 = new TreeNode(2);
      TreeNode node4 = new TreeNode(1);
      TreeNode node5 = new TreeNode(2);
      TreeNode node6 = new TreeNode(2);
      TreeNode node7 = new TreeNode(2);
      TreeNode node8 = new TreeNode(2);
      node1.left = node2;
      node1.right = node3;
      node2.left = node4;
      node4.left = node7;
      node4.right = node8;
      node3.left = node5;
      node3.right = node6;
      Assert.assertEquals(3, univalue(node1));
   }
}

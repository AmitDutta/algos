package ds;

import org.junit.*;
import java.util.List;

public class TreeCodes {
   private TreeNode result;
   public TreeNode flipInt(TreeNode root) {
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
   
   private int diameter = 0;
   
   private int diameterInt(TreeNode root) {
      if (root == null) {
         return 0;
      }
      int left = diameterInt(root.left);
      int right = diameterInt(root.right);
      int val = 1 + left + right;
      diameter = Math.max(diameter, val);
      return 1 + Math.max(left, right);
   }
   
   public int diameter(TreeNode root) {
      diameter = 0;
      diameterInt(root);
      return diameter;
   }

   // http://www.danielbit.com/blog/puzzle/leetcode/leetcode-binary-tree-upside-down
   public TreeNode flip(TreeNode root) {
      flipInt(root);
      return result;
   }

   @Test
   public void diameterTest1() {
      TreeNode node1 = new TreeNode(1);
      Assert.assertEquals(1, diameter(node1));
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      node1.left = node2;
      node1.right = node3;
      Assert.assertEquals(3, diameter(node1));
   }
   
   @Test
   public void diameterTest2() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      TreeNode node6 = new TreeNode(6);
      TreeNode node7 = new TreeNode(7);
      TreeNode node8 = new TreeNode(8);
      TreeNode node9 = new TreeNode(9);
      TreeNode node10 = new TreeNode(10);
      TreeNode node11 = new TreeNode(11);
      TreeNode node12 = new TreeNode(12);
      TreeNode node13 = new TreeNode(13);
      
      node1.left = node2;
      node1.right = node3;
      
      node2.left = node4;
      node2.right = node5;
      
      node5.left = node7;
      node5.right = node8;
      
      node3.right = node6;
      
      node6.right = node9;
      
      node9.left = node10;
      
      node10.left = node12;
      node10.right = node13;
      
      node9.right = node11;
      
      /*System.out.println("--");
      TreeNode.toLevelOrderPrint(node1);*/
      
      Assert.assertEquals(9, diameter(node1));
   }
   
   @Test
   public void diametertest3() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      TreeNode node6 = new TreeNode(6);
      TreeNode node7 = new TreeNode(7);
      TreeNode node8 = new TreeNode(8);
      TreeNode node9 = new TreeNode(9);
      TreeNode node10 = new TreeNode(10);
      TreeNode node11 = new TreeNode(11);
      TreeNode node12 = new TreeNode(12);
      TreeNode node13 = new TreeNode(13);
      TreeNode node14 = new TreeNode(14);
      TreeNode node15 = new TreeNode(15);
      
      node1.left = node2;
      node1.right = node3;
      
      node2.left = node4;
      node2.right = node5;
      
      node3.right = node6;
      
      node4.left = node7;
      node4.right = node8;
      
      node8.left = node10;
      node10.left = node13;
      node10.right = node14;
      
      node5.right = node9;
      node9.left = node11;
      node9.right = node12;
      node12.right = node15;
      
      /*System.out.println("--");
      TreeNode.toLevelOrderPrint(node1);*/
      
      Assert.assertEquals(9, diameter(node1));
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
   @Test
   public void test2() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      node1.left = node2;
      node1.right = node3;
      node2.left = node4;
      node2.right = node5;
      //TreeNode.printAllPaths(node1);
   }
   
   @Test
   public void test3() {
      TreeNode node = TreeNode.FromLevelOrderArray(new String[] {"1","2","3","#","#","#","#"});
      //TreeNode.toLevelOrderPrint(node);
   }
}

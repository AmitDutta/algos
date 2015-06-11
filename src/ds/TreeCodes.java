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
      return right;
   }
   // http://www.danielbit.com/blog/puzzle/leetcode/leetcode-binary-tree-upside-down
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
      /*String str = TreeNode.toPreOrder(result);
      System.out.println(str);
      
      TreeNode root = TreeNode.fromPreOrder(str);
      List<List<Integer>> lst = TreeNode.toLevelOrder(root);
      for (List<Integer> l : lst) {
         for (Integer i : l) {
            System.out.print(i + " "); 
         }
         System.out.println();
      }*/
      
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
      TreeNode.printAllPaths(node1);
   }
}

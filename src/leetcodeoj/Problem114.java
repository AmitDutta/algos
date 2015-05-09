package leetcodeoj;

import java.util.Stack;

import org.junit.*;

public class Problem114 {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
   // TLE
   public TreeNode flattenInt(TreeNode root) {
      if (root == null) return null;
      TreeNode tmp_right = flattenInt(root.right);
      TreeNode tmp_left = flattenInt(root.left);
      root.right = tmp_left;
      TreeNode cur = tmp_left;
      if (cur != null) {
         while (cur.right != null) {
            cur = cur.right;
         }
         cur.right = tmp_right;
      }
      return root;
   }
   public void flattenRec(TreeNode root) {
      flattenInt(root);
   }
   
   // This is really good stack based problem
   // This can be done without extra storage
   public void flatten(TreeNode root) {
      if (root == null) return;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode node = root;
      
      while (node != null || !stack.isEmpty()) {
         if (node.right != null) {
            stack.push(node.right);
         }
         if (node.left != null) {
            node.right = node.left;
            node.left = null;
         }else if (!stack.empty()) {
            node.right = stack.pop();
         }
         node = node.right;
      }
   }
   @Test
   public void flattenTest() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);
      TreeNode node6 = new TreeNode(6);
      TreeNode node7 = new TreeNode(7);
      
      node2.left = node3;
      node2.right = node4;
      
      node5.right = node6;
      node5.left = node7;
      
      node1.left = node2;
      node1.right = node5;
      
      flatten(node1);
      while (node1 != null) {
         System.out.print(node1.val + " ");
         node1 = node1.right;
      }
      
   }
}

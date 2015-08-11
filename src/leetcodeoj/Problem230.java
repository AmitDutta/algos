package leetcodeoj;

import ds.TreeNode;

public class Problem230 {
   private TreeNode result;
   private int k;
   private void inorderInt(TreeNode node) {
       if (node == null) {
           return;
       }
       inorderInt(node.left);
       k--;
       if (k == 0) {
           result = node;
           return;
       }
       inorderInt(node.right);
   }
   public int kthSmallest(TreeNode root, int k) {
       result = null;
       this.k = k;
       inorderInt(root);
       return result.val;
   }
}

package tree;

import ds.TreeNode;

public class LCA {
   public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || q == null || q == null) {
         return null;
      }
      if (p.val == root.val || q.val == p.val) {
         return root;
      }
      TreeNode left = LCA(root.left, p, q);
      TreeNode right = LCA(root.right, p, q);
      if (left != null && right != null) {
         return root;
      }
      return left == null ? root.right : root.left;
   }
}

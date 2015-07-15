package leetcodeoj;

import ds.TreeNode;

public class Problem236 {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || p == null || q == null) {
          return null;
      }
      // this is must !!! not root.val == p .. if the root node itself equals to p
      if (root.equals(p) || root.equals(q)) {
          return root;
      }
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left != null && right != null) {
          return root;
      }
      return left == null ? right : left;
   }
}

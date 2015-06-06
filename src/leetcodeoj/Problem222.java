package leetcodeoj;

import ds.TreeNode;

public class Problem222 {
   private int height(TreeNode root, boolean isLeft) {
      if (root == null) return 0;
      if (isLeft) {
          return 1 + height(root.left, isLeft);
      }
      return 1 + height(root.right, isLeft);
  }
  // Look at the line, all nodes in the last level are as far LEFT as possible.
  // That means if we traverse recursively on left and right, they will reach
  // to two ends. If this two ends have same height, that says the tree is
  // actually full. So, just return 2^h -1
  public int countNodes(TreeNode root) {
      if (root == null) return 0;
      int leftHeight = height(root, true);
      int rightHeight = height(root, false);
      if (leftHeight == rightHeight) {
          return (1 << leftHeight) - 1;
      }
      return 1 + countNodes(root.left) + countNodes(root.right);
  }
}

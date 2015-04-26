package leetcodeoj;

public class Problem98 {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
   public boolean isValidBstInt(TreeNode root, long min, long max) {
      if (root == null) return true;
      if (root.val <= min || !isValidBstInt(root.left, min, root.val)) {
         return false;
      }
      if (root.val >= max || !isValidBstInt(root.right, root.val, max)) {
         return false;
      }
      return true;
   }
   public boolean isValidBST(TreeNode root) {
      return isValidBstInt(root, Long.MIN_VALUE, Long.MAX_VALUE);
   }
}

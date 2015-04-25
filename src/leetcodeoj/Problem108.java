package leetcodeoj;

public class Problem108 {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
   public TreeNode convert(int[] num, int low, int high) {
      if (low > high) {
         return null;
      }
      int mid = low + (high - low) / 2;
      TreeNode root = new TreeNode(num[mid]);
      root.left = convert(num, low, mid - 1);
      root.right = convert(num, mid + 1, high);
      return root;
   }
   public TreeNode sortedArrayToBST(int[] num) {
      return convert(num, 0, num.length -1);
   }
}

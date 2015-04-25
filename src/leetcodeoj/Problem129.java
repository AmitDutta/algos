package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

// using private variable 256ms
// returning 279 ms

public class Problem129 {

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

   public int sumNumbers(TreeNode root, int prev) {
      if (root == null) return 0;
      int cur = prev * 10 + root.val;
      if (root.left == null && root.right == null) {
         return cur;
      }
      int left = sumNumbers(root.left, cur);
      int right = sumNumbers(root.right, cur);
      return left + right;
   }

   public int sumNumbers(TreeNode root) {
      return sumNumbers(root, 0);
   }
   
   @Test
   public void sumNumbersTest() {
      TreeNode nd1 = new TreeNode(1);
      TreeNode nd2 = new TreeNode(2);
      TreeNode nd3 = new TreeNode(3);
      //TreeNode nd4 = new TreeNode(4);
      nd1.left = nd2;
      nd1.right = nd3;
      //nd2.left = nd4;
      Assert.assertEquals(25, sumNumbers(nd1));
   }
}

package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94 {

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      boolean done = false;
      TreeNode current = root;
      while (!done) {
         while (current != null) {
            stack.push(current);
            current = current.left;
         }
         if (stack.empty()) {
            done = true;
         } else {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
               current = node.right;
            }
         }
      }
      return result;
   }
}

package lintcode;

import java.util.Stack;

import ds.TreeNode;

public class MaxTree {
   // This one is interesting..pushing nodes in stack..
   public TreeNode maxTree(int[] A) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode result = null;
      for (int i = 0; i < A.length; ++i) {
          TreeNode node = new TreeNode(A[i]);
          while (!stack.isEmpty() && A[i] > stack.peek().val) {
              node.left = stack.pop();
          }
          if (!stack.isEmpty() && A[i] < stack.peek().val) {
              stack.peek().right = node;
          }
          stack.push(node);
      }
      while (!stack.isEmpty()) {
          result = stack.pop();
      }
      return result;
  }
}

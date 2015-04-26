package leetcodeoj;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class Problem105 {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
   private int preIndex;
   public TreeNode buildTreeInt(int[] preorder, int[] inorder, int left,
                                int right) {
      if (left > right) {
         return null;
      }
      int i = left;
      for (; i <= right; ++i) {
         if (inorder[i] == preorder[preIndex]) {
            break;
         }
      }
      TreeNode node = new TreeNode(inorder[i]);
      ++preIndex;
      node.left = buildTreeInt(preorder, inorder, left, i - 1);
      node.right = buildTreeInt(preorder, inorder, i + 1, right);
      return node;
   }

   public TreeNode buildTree(int[] preorder, int[] inorder) {
      preIndex = 0;
      if (preorder.length == 0 || inorder.length == 0) return null;
      return buildTreeInt(preorder, inorder, 0, inorder.length - 1);
   }
   
   @Test
   public void buildTreeIntTest() {
      //int[] in = {2,50,75,100,125,170,200};
      //int[] pre = {100,50,2,75,170,125,200};
      int[] in = {};
      int[] pre = {};
      TreeNode node = buildTree(pre, in);
      if (node == null) return;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(node);
      int current = 1, next = 0;
      while (queue.size() > 0) {
         TreeNode nd = queue.poll();
         System.out.print(nd.val + " ");
         current--;
         if (nd.left != null) {
            queue.offer(nd.left);
            ++next;
         }
         if (nd.right != null) {
            queue.offer(nd.right);
            ++next;
         }
         if (current == 0) {
            current = next;
            next = 0;
            System.out.println();
         }
      }
   }
}

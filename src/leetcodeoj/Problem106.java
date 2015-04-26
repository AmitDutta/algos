package leetcodeoj;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


public class Problem106 {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
   private int postIndex;
   public TreeNode buildTreeInt(int[] inorder, int[] postorder, int left,
                                int right) {
      if (left > right) {
         return null;
      }
      int i = left;
      for (; i <= right; ++i) {
         if (inorder[i] == postorder[postIndex]) {
            break;
         }
      }
      TreeNode node = new TreeNode(inorder[i]);
      --postIndex;
      node.right = buildTreeInt(inorder, postorder, i + 1, right);
      node.left = buildTreeInt(inorder, postorder, left, i - 1);
      return node;
   }

   public TreeNode buildTree(int[] inorder, int[] postorder) {
      postIndex = postorder.length - 1;
      if (postorder.length == 0 || inorder.length == 0) return null;
      return buildTreeInt(inorder, postorder, 0, inorder.length - 1);
   }
   
   @Test
   public void buildTreeIntTest() {
      int[] in = {2,50,75,100,125,170,200};
      //int[] pre = {100,50,2,75,170,125,200};
      int[] post = {2,75,50,125,200,170,100};
      //int[] in = {};
      //int[] pre = {};
      TreeNode node = buildTree(in, post);
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

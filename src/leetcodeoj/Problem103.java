package leetcodeoj;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Problem103 {

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if (root == null) return result;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      int current = 1, next = 0, level = 1;
      List<Integer> lst = new ArrayList<Integer>();
      while (queue.size() > 0) {
         TreeNode nd = queue.poll();
         lst.add(nd.val);
         current--;
         if (nd.left != null) {
            queue.offer(nd.left);
            next++;
         }
         if (nd.right != null) {
            queue.offer(nd.right);
            next++;
         }
         if (current == 0) {
            if (level % 2 == 0) {
               Collections.reverse(lst);
            }
            result.add(lst);
            current = next;
            next = 0;
            level++;
            lst = new ArrayList<Integer>();
         }
      }
      return result;
   }
}

package leetcodeoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Problem107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        // note that priority queue is heap, so type needs comparable.
        // general purpose queue is linkedlist
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        
        List<Integer> current = new ArrayList<Integer>();
        int cur, next;
        cur = 1; next = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            current.add(node.val);
            cur--;
            if (node.left != null) {
                queue.offer(node.left);
                ++next;
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                ++next;
            }
            
            if (cur == 0) {
                result.add(current);
                cur = next;
                next = 0;
                current = new ArrayList<Integer>();
            }
        }
        Collections.reverse(result);
        return result;
    }
}

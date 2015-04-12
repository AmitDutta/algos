package leetcodeoj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Problem199 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        int cur, next;
        cur = 1; next = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
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
                result.add(node.val);
                cur = next;
                next = 0;
            }
        }
        return result;
    }
}

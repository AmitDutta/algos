package collections;

import java.util.Stack;

import ds.TreeNode;

public class InorderIterator {
   private TreeNode current, item;
   private Stack<TreeNode> stack;
   public InorderIterator(TreeNode root) {
       current = root;
       item = null;
       stack = new Stack<TreeNode>();
   }

   /** @return whether we have a next smallest number */
   public boolean hasNext() {
       if (item == null) {
           while (current != null) {
               stack.push(current);
               current = current.left;
           }
           if (!stack.empty()) {
               item = stack.pop();
               if (item.right != null) {
                   current = item.right;
               }
           }
       }
       return item != null;
   }

   /** @return the next smallest number */
   public int next() {
       if (hasNext()) {
           int val = item.val;
           item = null;
           return val;
       }
       return Integer.MIN_VALUE;
   }
}

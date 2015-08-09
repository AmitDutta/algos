package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import ds.TreeNode;

public class PostOrderIterator implements Iterator<Integer>{
   private Stack<TreeNode> stack = null;
   private TreeNode item = null;
   public PostOrderIterator(TreeNode node) {
      stack = new Stack<TreeNode>();
      while (node != null) {
         stack.push(node);
         if (node.left != null) {
            node = node.left;
         } else {
            node = node.right;
         }
      }
   }
   @Override
   public boolean hasNext() {
      if (item == null) {
         if (!stack.isEmpty()) {
            item = stack.pop();
            if (!stack.isEmpty() && item == stack.peek().left) {
               TreeNode cur = stack.peek().right;
               while (cur != null) {
                  stack.push(cur);
                  if (cur.left != null) {
                     cur = cur.left;
                  } else {
                     cur = cur.right;
                  }
               }
            }
         }
      }
      return item != null;
   }
   @Override
   public Integer next() {
      if (hasNext()) {
         int data = item.val;
         item = null;
         return data;
      }
      throw new NoSuchElementException();
   }
   public static void main(String... s) {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      node1.right = node2;
      node2.right = node3;
      node3.right = node4;
      PostOrderIterator pt = new PostOrderIterator(node1);
      while (pt.hasNext()) {
         pt.hasNext();
         System.out.print(pt.next() + " ");
      }
      System.out.println();
      
      
      node1 = new TreeNode(1);
      node2 = new TreeNode(2);
      node3 = new TreeNode(3);
      node4 = new TreeNode(4);
      node1.left = node2;
      node2.right = node3;
      node3.left = node4;
      pt = new PostOrderIterator(node1);
      while (pt.hasNext()) {
         pt.hasNext();
         System.out.print(pt.next() + " ");
      }
      System.out.println();
   }
}

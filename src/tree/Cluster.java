package tree;

import java.util.List;

import ds.TreeNode;

import org.junit.*;

public class Cluster {
   // This one is excellent example, when someone asks to return a subtree
   // or any node from inside tree and no other data structure allowed. Just
   // traverse the tree and call fucntion for each node. consider traverse method
   // as a for loop and do any order, in/post etc
   private TreeNode result;
   private int num;
   private int getCount(TreeNode node, int color) {
      if (node == null) {
         return 0;
      }
      if (node.getData() != color) {
         return 0;
      }
      return 1 + getCount(node.getLeft(), node.getData())
               + getCount(node.getRight(), node.getData());
   }

   private void traverse(TreeNode root) {
      if (root == null) return ;
      traverse(root.getLeft());
      int count = getCount(root, root.getData()); // visit this node
      if (count > num) {
         num = count;
         result = root;
      }
      traverse(root.getRight());
   }

   public TreeNode getMaxClusterRoot(TreeNode root) {
      num = Integer.MIN_VALUE;
      traverse(root);
      return result;
   }

   @Test
   public void getMaxClusterRootTest() {
      TreeNode node1 = new TreeNode(2);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(2);
      node1.setLeft(node2);
      node1.setRight(node3);
      TreeNode node4 = new TreeNode(2);
      TreeNode node5 = new TreeNode(2);
      node3.setLeft(node4);
      node3.setRight(node5);
      TreeNode node6 = new TreeNode(2);
      TreeNode node7 = new TreeNode(2);
      node4.setLeft(node6);
      node4.setRight(node7);
      
      TreeNode root = getMaxClusterRoot(node1);
      //System.out.println(node1.getData());
      List<List<Integer>> subTree = root.toLevelOrder();
      for (List<Integer> level : subTree) {
         for (Integer i : level) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

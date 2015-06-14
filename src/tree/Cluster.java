package tree;

import java.util.List;

import ds.TreeNode;

import org.junit.*;

public class Cluster {
   // This one is excellent example, when someone asks to return a subtree
   // or any node from inside tree and no other data structure allowed. Just
   // traverse the tree and call fucntion for each node. consider traverse method
   // as a for loop and do any order, in/post etc
   // Runitme: O(n^2); this is brute force
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
   
   private int max;
   // every node itself is a cluster of size 1
   // This is the desired solution. If current node can be part of
   // the cluster, that means it has same color as left or right, it will
   // return 1 + left + right to root. Otherwise, will return 1.
   // Keep track of max and root node
   private int clusterRootInt(TreeNode root) {
      if (root == null) {
         return 0;
      }
      int left = clusterRootInt(root.left);
      int right = clusterRootInt(root.right);
      int current = 0;
      if (left == 0 & right == 0) {
         current = 1;
      } else if (left > 0 && right > 0) {
         // current node can be a part of the cluster formed with left
         // and right. If so, current = left + 1 + right. else current = 1
         if (root.getData() == root.left.getData() && root.getData() == root.right.getData()) {
            current = 1 + left + right;
         } else {
            current = 1;
         }
      } else if (left > 0) {
         // right is definitely zero, otherwise previous condition would work
         if (root.getData() == root.left.getData()) {
            current =  1 + left;
         } else {
            current = 1;
         }
      } else {
         // left is zero, but right is not
         if (root.getData() == root.right.getData()) {
            current = 1 + right;
         } else {
            current = 1;
         }
      }
      if (current > max) {
         max = current;
         result = root;
      }
      return current;
   }

   public TreeNode clusterRoot(TreeNode root) {
      result = null;
      max = Integer.MIN_VALUE;
      clusterRootInt(root);
      System.out.println("Max size: " + max);
      return result;
   }

   //@Test
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
      List<List<Integer>> subTree = TreeNode.toLevelOrder(root);
      for (List<Integer> level : subTree) {
         for (Integer i : level) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
   
   @Test
   public void test1() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(2);
      node1.setLeft(node2);
      node1.setRight(node3);
      clusterRoot(node1);
   }
   @Test
   public void test2() {
      /*   1
         1    2 
                1 
                  2 
                 2  2 
      */
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(1);
      TreeNode node3 = new TreeNode(2);
      TreeNode node4 = new TreeNode(1);
      TreeNode node5 = new TreeNode(2);
      TreeNode node6 = new TreeNode(2);
      TreeNode node7 = new TreeNode(2);
      node1.left = node2;
      node1.right = node3;
      node3.right = node4;
      node4.right = node5;
      node5.left = node6;
      node5.right = node7;
      
      TreeNode result = clusterRoot(node1);
      TreeNode.toLevelOrderPrint(result);
   }
   
   @Test
   public void test3() {
      /*   1
         1    1 
                1 
                  2 
                 2  2 
      */
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(1);
      TreeNode node3 = new TreeNode(1);
      TreeNode node4 = new TreeNode(1);
      TreeNode node5 = new TreeNode(2);
      TreeNode node6 = new TreeNode(2);
      TreeNode node7 = new TreeNode(2);
      node1.left = node2;
      node1.right = node3;
      node3.right = node4;
      node4.right = node5;
      node5.left = node6;
      node5.right = node7;
      
      TreeNode result = clusterRoot(node1);
      TreeNode.toLevelOrderPrint(result);
   }
}

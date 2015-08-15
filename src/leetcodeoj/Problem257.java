package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import ds.TreeNode;

public class Problem257 {
   // using stringbuffer here is not a good idea since "->" need to be added
   // and removing is not trivial..collection buffer is always good
   List<String> paths;
   private void pathInt(TreeNode node, List<Integer> lst) {
       if (node == null) {
           return;
       }
       if (node.left == null && node.right == null) {
           StringBuffer buffer = new StringBuffer();
           for (Integer i : lst) {
              buffer.append(i + "->");
           }
           buffer.append(node.val);
           paths.add(buffer.toString());
           return;
       }
       lst.add(node.val);
       if (node.left != null) {
           pathInt(node.left, lst);
       }
       if (node.right != null) {
           pathInt(node.right, lst);
       }
       lst.remove(lst.size() -  1);
   }
   public List<String> binaryTreePaths(TreeNode root) {
       paths = new ArrayList<String>();
       pathInt(root, new ArrayList<Integer>());
       return paths;
   }
   @Test
   public void test1() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      node1.left = node2;
      node2.left = node3;
      node1.right = node4;
      List<String> paths = binaryTreePaths(node1);
      for (String path : paths) {
         System.out.println(path);
      }
   }
}

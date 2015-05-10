package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import ds.TreeNode;

public class Problem99 {
   List<TreeNode> invalidNodes;
   
   // This method will return only the first failure
   public boolean validate(TreeNode root, int min, int max) {
      if (root == null) return true;
      if (root.val <= min || !validate(root.left, min, root.val)) {
         invalidNodes.add(root);
         return false;
      }
      if (root.val >= max || !validate(root.right, root.val, max)) {
         invalidNodes.add(root);
         return false;
      }
      return true;
   }
   TreeNode prev, node1, node2;
   public void inorder(TreeNode root) {
      if (root == null) {
         return;
      }
      inorder(root.left);
      //visit node
      if (prev == null) {
         prev = root;
      }else {
         // if previous data is greater than current, then which one is 
         // actually invalid?? Think 25 - 15 - 17 -10. Which two items
         // are not in sorted position (e.g. we are one swap away from sort)
         // we mark 25 and move ahead to find the other..node2 does that work
         //here
         if (prev.val > root.val) {
            if (node1 == null) {
               node1 = prev;
            }
            node2 = root; // this pointer will change
         }
         prev = root;
      }
      inorder(root.right);
   }
   public void recoverTree(TreeNode root) {
      if (root == null) return;
      inorder(root);
      int data = node1.val;
      node1.val = node2.val;
      node2.val = data;
   }
}

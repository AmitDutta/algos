package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;


public class Problem113 {

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

   private List<List<Integer>> result = new ArrayList<List<Integer>>();
   public void pathSumInt(TreeNode root, int sum, 
                                        List<Integer> current) {
      if (root == null) return;
      //current.add(root.val);
      int cur_sum = sum - root.val;
      if (root.left == null && root.right == null) {
         if (cur_sum == 0) {
            List<Integer> tmp = new ArrayList<Integer>(current); // This is must, doing a deep clone
            tmp.add(root.val); // last item, since we decide here, no need to add in list. or I can add
            // and remove, see comments aboev and below
            result.add(tmp);
         }
         //current.remove(current.size() - 1);
         return;
      }
      current.add(root.val);
      pathSumInt(root.left, cur_sum, current);
      pathSumInt(root.right, cur_sum, current);
      current.remove(current.size() - 1);
   }
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
      if (root == null) return result;
      pathSumInt(root, sum, new ArrayList<Integer>());
      return result;
      
   }
   
   @Test
   public void pathSumTest1() {
      Problem113 p113 = new Problem113();
      TreeNode node1 = new TreeNode(5);
      TreeNode node2 = new TreeNode(4);
      TreeNode node3 = new TreeNode(5);
      TreeNode node4 = new TreeNode(1);
      
      node1.left = node2;
      node2.left = node4;
      node1.right = node3;
      
      List<List<Integer>> result = p113.pathSum(node1, 10);
      
      Assert.assertEquals(Arrays.asList(5,4,1), result.get(0));
      Assert.assertEquals(Arrays.asList(5,5), result.get(1));
   }
}

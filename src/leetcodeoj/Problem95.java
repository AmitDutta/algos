package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

import ds.TreeNode;

public class Problem95 {
   private List<TreeNode> lst;
   private TreeNode current = null;
   private TreeNode generateInt(int start, int end, int level, int n) {
      if (start > end) {
         /*if (start == n) {
            lst.add(current);
         }*/
         return null;
      }
      TreeNode nd = null;
      for (int k = start; k <= end; ++k) {
         nd = new TreeNode(k);
         if (level == 1) {
            current = nd;
         }
         nd.left = generateInt(start, k - 1, level + 1, n);
         nd.right = generateInt(k + 1, end, level + 1, n);
      }
      return nd;
   }
   
   public List<TreeNode> generateInt(int start, int end) {
      List<TreeNode> lst = new ArrayList<TreeNode>();
      if (start > end) {
         lst.add(null);
         return lst;
      }
      for (int i = start; i <= end; ++i) {
         List<TreeNode> lefts = generateInt(start, i - 1);
         List<TreeNode> rights = generateInt(i + 1, end);
         for (TreeNode left : lefts) {
            for (TreeNode right : rights) {
               TreeNode nd = new TreeNode(i);
               nd.left = left;
               nd.right = right;
               lst.add(nd);
            }
         }
      }
      return lst;
   }
   public List<TreeNode> generateTrees(int n) {
      return generateInt(1, n);
   }
   @Test
   public void test1() {
      List<TreeNode> result = generateTrees(3);
      /*for (TreeNode nd : result) {
         System.out.println("---");
         TreeNode.toLevelOrderPrint(nd);
      }*/
      Assert.assertEquals(5, result.size());
      result = generateTrees(4);
      Assert.assertEquals(14, result.size());
      /*result = generateTrees(2);
      Assert.assertEquals(2, result.size());*/
   }
}

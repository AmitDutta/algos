package ib;

import java.util.ArrayList;

import org.junit.*;
import ds.TreeNode;

public class HowManyBsts {
   public ArrayList<TreeNode> generateTreesInt(int start, int end) {
      ArrayList<TreeNode> lst = new ArrayList<TreeNode>();
      if (start > end) {
         lst.add(null);
      } else {
         for (int i = start; i <= end; ++i) {
            ArrayList<TreeNode> lefts = generateTreesInt(start, i - 1);
            ArrayList<TreeNode> rights = generateTreesInt(i + 1, end);
            for (TreeNode left : lefts) {
               for (TreeNode right : rights) {
                  TreeNode node = new TreeNode(i);
                  node.left = left;
                  node.right = right;
                  lst.add(node);
               }
            }
         }
      }
      return lst;
   }
   public ArrayList<TreeNode> generateTrees(int A) {
      return generateTreesInt(1, A);
   }
   @Test
   public void test1() {
      Assert.assertEquals(5, generateTrees(3).size());
   }
}

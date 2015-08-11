package ds;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

// https://monsiterdex.wordpress.com/2013/09/23/maximal-surpasser-count-problem-binary-search-tree-solution/
// http://www.careercup.com/question?id=5716707660267520
public class Surpasser {
   private class Node {
      private Node left, right;
      private int count, rightSize, surpasser, key;
      public Node(int val) {
         count = 1;
         key = val;
         rightSize = surpasser = 0;
         left = right = null;
      }
   }
   private int max = 0;
   private Node root;
   public List<Node> nodes;
   private void insert(int a) {
      if (root == null) {
         root = new Node(a);
         nodes.add(root);
         return;
      }
      Node cur = root;
      Node prev = null;
      int p = 0;
      while (cur != null) {
         prev = cur;
         if (cur.key > a) {
            p += cur.count + cur.rightSize;
            cur = cur.left;
         } else if (cur.key < a) {
            cur.rightSize++;
            cur = cur.right;
         } else {
            // key is same..update count and surpasser for this node
            cur.count++;
            cur.surpasser = p + cur.rightSize; // because all the node of this nodes right are greater and added before
            max = Math.max(cur.surpasser, max);
            return;
         }
      }
      Node nd = new Node(a);
      nd.surpasser = p;
      max = Math.max(nd.surpasser, max);
      if (a > prev.key) {
         prev.right = nd;
      } else {
         prev.left = nd;
      }
      nodes.add(nd);
   }
   public int maxsurpasser(int[] a) {
      root = null;
      nodes = new ArrayList<Node>();
      for (int i = a.length - 1; i >= 0; --i) {
         insert(a[i]);
      }
      /*for (int i = 0; i < nodes.size(); ++i) {
         System.out.println(nodes.get(i).key + ":" + nodes.get(i).surpasser);
      }*/
      return max;
   }
   
   //@Test
   public void test1() {
      int[] a = {2, 7, 5, 5, 2, 7, 0, 8, 1};
      Assert.assertEquals(5, maxsurpasser(a));
   }
   @Test
   public void test2() {
      int[] a = {82,74,17,93,96,20,25,55,15,24,25,56};
      Assert.assertEquals(8, maxsurpasser(a));
   }
}

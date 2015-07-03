package ds;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
   private BST<Integer, Integer> bst = null;
   
   @Before
   public void init() {
      bst = new BST<Integer, Integer>();
      Integer[] a = new Integer[] {10,5,20,1,6,15,30};
      bst.putAll(a, a);
   }
   @Test
   public void putTest() {
      Integer[] b = new Integer[] {1,5,6,10,15,20,30};
      Iterator<Integer> it = bst.iterator().iterator();
      int k = 0;
      while (it.hasNext()) {
         Assert.assertEquals(b[k++], it.next());
      }
      Assert.assertEquals(b.length, k);
      Assert.assertEquals(b.length, bst.size());
   }
   
   @Test
   public void ceilingTest() {
      Assert.assertEquals(new Integer(20), bst.celing(16));
      Assert.assertEquals(new Integer(5), bst.celing(2));
      Assert.assertEquals(new Integer(1), bst.celing(-5));
      Assert.assertEquals(new Integer(30), bst.celing(25));
      Assert.assertEquals(new Integer(1), bst.celing(1));
   }
   
   @Test
   public void floorTest() {
      Assert.assertEquals(new Integer(10), bst.floor(12));
      Assert.assertEquals(new Integer(30), bst.floor(35));
      Assert.assertEquals(new Integer(6), bst.floor(8));
      Assert.assertEquals(new Integer(15), bst.floor(15));
   }
   
   @Test
   public void rankTest() {
      Assert.assertEquals(0, bst.rank(1));
      Assert.assertEquals(1, bst.rank(5));
      Assert.assertEquals(2, bst.rank(6));
      Assert.assertEquals(3, bst.rank(10));
      Assert.assertEquals(5, bst.rank(20));
      Assert.assertEquals(4, bst.rank(15));
      Assert.assertEquals(6, bst.rank(30));
   }
   
   @Test
   public void kthSmallestTest() {
      // zero based, first item is zeroth smallest
      // which is true since if tree has one node, it has left subtree of size 0
      Assert.assertEquals(new Integer(1), bst.kthSmallest(1 - 1));
      Assert.assertEquals(new Integer(5), bst.kthSmallest(2 - 1));
      Assert.assertEquals(new Integer(6), bst.kthSmallest(3 - 1));
      Assert.assertEquals(new Integer(10), bst.kthSmallest(4 - 1));
      Assert.assertEquals(new Integer(15), bst.kthSmallest(5 - 1));
      Assert.assertEquals(new Integer(20), bst.kthSmallest(6 - 1));
      Assert.assertEquals(new Integer(30), bst.kthSmallest(7 - 1));
   }
}

package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.*;

public class MultiIteratorTest {

   @Test
   public void test1() {
      List<Integer> a = Arrays.asList(1,2,3);
      List<Integer> b = Arrays.asList(4);
      List<Integer> c = Arrays.asList();
      List<Integer> d = Arrays.asList(5,6,7,8);
      List<Iterator<Integer>> its = new ArrayList<Iterator<Integer>>();
      MultiIterator<Integer> mlt = new MultiIterator<Integer>(its);
      Assert.assertFalse(mlt.hasNext());
      its.add(a.iterator());
      its.add(b.iterator());
      its.add(c.iterator());
      its.add(d.iterator());
      mlt = new MultiIterator<Integer>(its);
      Assert.assertTrue(mlt.hasNext());
      int i = 1;
      while (mlt.hasNext()) {
         Assert.assertTrue(mlt.hasNext());
         Assert.assertEquals(new Integer(i), mlt.next());
         i++;
      }
   }
}

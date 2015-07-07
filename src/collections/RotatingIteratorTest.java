package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.*;

public class RotatingIteratorTest {
   @Test
   public void test1() {
      List<Integer> a = Arrays.asList(1,4);
      List<Integer> b = Arrays.asList(2,5);
      List<Integer> c = Arrays.asList(3,6,7,8,9);
      List<Iterator<Integer>> lst = new ArrayList<Iterator<Integer>>();
      RotatingIterator<Integer> rt = new RotatingIterator<Integer>(lst);
      Assert.assertFalse(rt.hasNext());
      lst.add(a.iterator());
      lst.add(b.iterator());
      lst.add(c.iterator());
      int i = 1;
      while (rt.hasNext()) {
         Assert.assertTrue(rt.hasNext());
         Assert.assertEquals(new Integer(i), rt.next());
         i++;
      }
   }
}

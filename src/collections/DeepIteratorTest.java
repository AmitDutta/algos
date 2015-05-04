package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.*;

public class DeepIteratorTest {
   @Test(expected = NoSuchElementException.class)
   public void DeepIteratorTest1() {
      DeepIterator<Integer> dip = new DeepIterator(null);
      Assert.assertFalse(dip.hasNext());
      dip.next();
   }
   @Test
   public void DeepIteratorTest2() {
      List<Integer> lst1 = Arrays.asList(1, 2, 3);
      List<Integer> lst2 = Arrays.asList(4, 5, 6);
      List<Integer> lst3 = Arrays.asList(7, 8, 9);
      List<List<Integer>> lst = new ArrayList<List<Integer>>();
      List<Object> param = new ArrayList<Object>();
      lst.add(lst1);
      lst.add(lst2);
      param.add(lst);
      param.add(lst3);
      DeepIterator<Integer> dip = new DeepIterator(param);
      List<Integer> actual = new ArrayList<Integer>();
      while (dip.hasNext()) {
         actual.add(dip.next());
      }
      for (int i = 0; i < actual.size(); ++i) {
         Integer act = actual.get(i);
         Integer exp = i + 1;
         Assert.assertEquals(exp, act);
      }
   }
}

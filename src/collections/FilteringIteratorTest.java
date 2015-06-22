package collections;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.*;

public class FilteringIteratorTest {

   public class EvenPredicate<T> implements Predicate<T> {
      @Override
      public boolean apply(T item) {
         Integer i = (Integer) item;
         return (i & 1) == 0;
      }
   }
   
   @Test
   public void test1() {
      List<Integer> lst = Arrays.asList(1,1,3,2,4,6,9,13,8,67,10);
      EvenPredicate<Integer> ep = new EvenPredicate<Integer>();
      FilteringIterator<Integer> filter = new FilteringIterator<Integer>(lst, ep);
      Integer i = 2;
      while(filter.hasNext()) {
         Assert.assertEquals(i, filter.next());
         i += 2;
      }
   }

   @Test(expected = NoSuchElementException.class)
   public void test2() {
      List<Integer> lst = Arrays.asList();
      EvenPredicate<Integer> ep = new EvenPredicate<Integer>();
      FilteringIterator<Integer> filter = new FilteringIterator<Integer>(lst, ep);
      Assert.assertFalse(filter.hasNext());
      filter.next();
   }
   
   @Test
   public void test3() {
      List<Integer> lst = Arrays.asList(1,2,3);
      PeekingIterator<Integer> peek = new PeekingIterator<Integer>(lst.iterator());
      while (peek.hasNext()) {
         System.out.println( peek.next() + ":" + peek.top());
      }
   }
}

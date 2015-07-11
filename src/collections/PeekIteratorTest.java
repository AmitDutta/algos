package collections;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
public class PeekIteratorTest {
   @Test
   public void test1() {
      List<Integer> lst = Arrays.asList(1,2,3);
      PeekIterator<Integer> pi = new PeekIterator<Integer>(lst);
      Integer i = 1;
      while (pi.hasNext()) {
         Assert.assertTrue(pi.hasNext());
         Assert.assertEquals(i, pi.peek());
         Assert.assertEquals(i, pi.peek());
         Assert.assertEquals(i, pi.next());
         ++i;
      }
   }
}

package collections;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class FlattenIteratorTest {
   @Test
   public void test1() {
      List<Integer> l1 = Arrays.asList(1,2);
      List<Integer> l2 = Arrays.asList(3);
      List<Integer> l22 = Arrays.asList();
      List<Integer> l3 = Arrays.asList(4,5,6);
      List<Integer> l33 = Arrays.asList();
      List<List<Integer>> l = Arrays.asList(l1, l2, l22, l3, l33);
      FlattenVector<Integer> ft = new FlattenVector<Integer>(l);
      while (ft.hasNext()) {
         ft.hasNext();
         ft.hasNext();
         System.out.println(ft.next());
      }
   }
}

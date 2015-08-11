package leetcodeoj;

import java.util.*;

import org.junit.*;

// Iterator for flatting 2D list
public class Problem251 {
   public class FlatIterator implements Iterator<Integer>{
      private List<List<Integer>> lst;
      private Integer item;
      private int i;
      private Iterator<Integer> it;
      public FlatIterator(List<List<Integer>> lst) {
         this.lst = lst;
         item = null;
         it = null;
         i = 0;
      }
      
      // everytime we call iterator from list class, it will give
      // us a new iterator..we want to cache one
      private void pick() {
         if (it != null && it.hasNext()) return;
         while (i < lst.size()) {
            if (lst.get(i).iterator().hasNext()) {
               it = lst.get(i).iterator();
               ++i;
               break;
            }
            ++i;
         }
         if (it != null && !it.hasNext()) {
            it = null;
         }
      }
      

      @Override
      public boolean hasNext() {
         if (item == null) {
            pick();
            if (it != null) {
               item = it.next();
            }
         }
         return item != null;
      }

      @Override
      public Integer next() {
         if (hasNext()) {
            Integer result = item;
            item = null;
            return result;
         }
         throw new NoSuchElementException();
      }
   }
   
   @Test
   public void test1() {
      List<Integer> l1 = Arrays.asList(1,2);
      List<Integer> l2 = Arrays.asList(3);
      List<Integer> l22 = Arrays.asList();
      List<Integer> l3 = Arrays.asList(4,5,6);
      List<List<Integer>> l = Arrays.asList(l1, l2, l22, l3);
      FlatIterator ft = new FlatIterator(l);
      while (ft.hasNext()) {
         ft.hasNext();
         ft.hasNext();
         System.out.println(ft.next());
      }
   }
}

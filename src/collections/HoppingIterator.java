package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class HoppingIterator<T> implements Iterator<T> {

   private Iterator<T> iterator;
   private T currentItem;
   private int hop;
   boolean first;

   public HoppingIterator(List<T> lst, int hop) {
      if (lst == null || hop < 0) {
         throw new IllegalArgumentException();
      }
      this.iterator = lst.iterator();
      this.hop = hop;
      first = true;
   }
 
   @Override
   public boolean hasNext() {
      if (currentItem != null) return true;
      if (first) {
         if (iterator.hasNext()) {
            currentItem = iterator.next();
         }
         first = false;
      }else {
         int counter = 0;
         while (counter < hop) {
            if (iterator.hasNext()) {
               iterator.next();
               counter++;
            }else {
               return false;
            }
         }
         if (!iterator.hasNext()) return false;
         currentItem = iterator.next();
      }
      return currentItem != null;
   }

   @Override
   public T next() {
      if (hasNext()) {
         T item = currentItem;
         currentItem = null;
         return item;
      }
      throw new NoSuchElementException();
   }

   public static void main(String... s) {
      List<Integer> lst = Arrays.asList(1,2,3,4,5);
      HoppingIterator<Integer> hi = new HoppingIterator<Integer>(lst, 3);
      while (hi.hasNext()) {
         System.out.println(hi.next());
      }
   }
}

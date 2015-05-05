package collections;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FilteringIterator<T> implements Iterator<T> {


   private T currentItem;
   private Iterator<T> iterator;
   private Predicate<T> predicate;
   
   public FilteringIterator(List<T> list, Predicate<T> predicate) {
      this.iterator = list.iterator();
      this.predicate = predicate;
   }

   @Override
   public boolean hasNext() {
      if (currentItem == null) {
         while (iterator.hasNext()) {
            T item = iterator.next();
            if (predicate.apply(item)) {
               currentItem = item;
               break;
            }
         }
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

}

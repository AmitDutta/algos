package collections;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MultiIterator<T> implements Iterator<T> {
   private List<Iterator<T>> iterators;
   private T item;
   private Iterator<T> currentIterator;
   private int index;
   public MultiIterator(List<Iterator<T>> iterators) {
      item = null;
      index = 0;
      currentIterator = null;
      this.iterators = iterators;
   }

   // picks an appropriate iterator. It may be currentIterator, if it has 
   // more items. Or the next available iterator in iterators list. If no
   // iterator is available, currentIterator will be null
   private void pickIterator() {
      if (currentIterator != null && currentIterator.hasNext()) {
         return;
      }
      currentIterator = null;
      // just pick the iterator which is not empty
      for (int i = index; i < iterators.size(); ++i) {
         Iterator<T> it = iterators.get(i);
         if (it.hasNext()) {
            currentIterator = it;
            break;
         }
      }
   }
   
   @Override
   public boolean hasNext() {
      if (item == null) {
         pickIterator();
         if (currentIterator != null) {
            // pickIteratr gurrantees that the iterator it picks is not null
            // and also have item in it. It does  not pick empty iterator. if no
            // iterator with item found, it sets currentiterator to null
            item = currentIterator.next();
         }
      }
      return item != null;
   }

   @Override
   public T next() {
      if (hasNext()) {
         T result = item;
         item = null; 
         return result;
      }
      throw new NoSuchElementException();
   }
}

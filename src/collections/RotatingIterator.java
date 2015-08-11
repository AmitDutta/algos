package collections;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RotatingIterator<T> implements Iterator<T> {
   private List<Iterator<T>> iterators;
   private T item;
   private Iterator<T> currentIterator;
   private int index;
   public RotatingIterator(List<Iterator<T>> iterators) {
      index = 0;
      currentIterator = null;
      item = null;
      this.iterators = iterators;
   }
   private void pickIterator() {
      if (iterators.size() == 0) {
         return;
      }
      int turn = 0;
      currentIterator = null;
      while (turn < iterators.size()) {
         index = index % iterators.size();
         Iterator<T> it = iterators.get(index);
         turn++;
         index++;
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

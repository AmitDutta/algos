package collections;

import java.util.Iterator;

public class PeekingIterator<T> implements Iterator<T>{
   private Iterator<T> it;
   private boolean picked;
   private T currentItem;
   public PeekingIterator(Iterator<T> it) {
      this.it = it;
      picked = false;
      currentItem = null;
   }
   @Override
   public boolean hasNext() {
      return picked || it.hasNext();
   }
   public T top() {
      if (!picked) {
         currentItem = it.next();
      }
      picked = true;
      return currentItem;
   }
   @Override
   public T next() {
      if (!picked) {
         currentItem = it.next();
      }
      picked = false;
      return currentItem;
   }
}

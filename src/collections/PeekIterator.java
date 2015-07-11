package collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekIterator <T> implements Iterator<T>{

   private Iterator<T> it;
   private T item;

   public PeekIterator(Iterable<T> it) {
      this.it = it.iterator();
      item = null;
   }

   public boolean hasNext() {
      if (item == null) {
         if (it.hasNext()) {
            item = it.next();
         }
      }
      return item != null;
   }

   public T peek() {
      if (hasNext()) {
         return item;
      }
      throw new NoSuchElementException();
   }

   public T next() {
      if (hasNext()) {
         T result = item;
         item = null;
         return result;
      }
      throw new NoSuchElementException();
   }
}

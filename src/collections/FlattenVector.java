package collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlattenVector<T> implements Iterator<T>{
   private List<List<T>> lst;
   private T item;
   private int i;
   private Iterator<T> it;
   public FlattenVector(List<List<T>> lst) {
      this.lst = lst;
      it = null;
      item = null;
      i = 0;
   }
   private void pick() {
      if (it != null && it.hasNext()) {
         return;
      }
      it = null;
      while (i < lst.size()) {
         Iterator<T> tmp = lst.get(i).iterator();
         ++i;
         if (tmp.hasNext()) {
            it = tmp;
            break;
         }
      }
   }
   public boolean hasNext() {
      if (item == null) {
         pick();
         if (it != null) {
            item = it.next();
         }
      }
      return item != null;
   }
   public T next() {
      if (hasNext()) {
         T ret = item;
         item = null;
         return ret;
      }
      throw new NoSuchElementException();
   }
}

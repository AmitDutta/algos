package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DeepIterator<T> implements Iterator<T> {

   /* Is there any type safe heterogenous collection in Java?
    * https://apocalisp.wordpress.com/2008/10/23/heterogeneous-lists-and-the-limits-of-the-java-type-system/
    * List<Object> serves the purpose, for the time being :). Not type safe though
    */
   private Stack<Object> stack;
   private T curentItem = null;

   public DeepIterator() {
   }
   
   public DeepIterator(Object collection) {
      if (collection == null) return;
      stack = new Stack<Object>();
      if (collection instanceof List<?>) {
         List<T> lst = (List<T>) collection;
         for (int i = lst.size() - 1; i >= 0; --i) {
            stack.push(lst.get(i));
         }
      }
   }

   @Override
   public boolean hasNext() {
      if (stack == null) return false;
      if (curentItem == null) {
         while (true) {
            if (curentItem != null) {
               break;
            }
            if (stack.empty()) {
               return false;
            }
            Object entry = stack.pop();
            if (entry instanceof List<?>) {
               List<T> lst = (List<T>) entry;
               for (int i = lst.size() - 1; i >= 0; --i) {
                  stack.push(lst.get(i));
               }
            }else {
               curentItem = (T) entry;
            }
         }
      }
      return curentItem != null;
   }

   @Override
   public T next() {
      if (hasNext()) {
         T item = curentItem;
         curentItem = null;
         return item;
      }
      throw new NoSuchElementException(); 
   }
}

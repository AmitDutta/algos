package leetcodeoj;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class Problem284 implements Iterator<Integer> {
   private Iterator<Integer> iterator;
   private Integer item;
   public Problem284(Iterator<Integer> iterator) {
      this.iterator = iterator;
      item = null;
   }

   // Returns the next element in the iteration without advancing the iterator.
   public Integer peek() {
        if (hasNext()) {
            return item;
        }
        return null;
   }

   // hasNext() and next() should behave the same as in the Iterator interface.
   // Override them if needed.
   @Override
   public Integer next() {
       if (hasNext()) {
           Integer tmp = item;
           item = null;
           return tmp;
       }
       return null;
   }

   @Override
   public boolean hasNext() {
       if (item == null) {
           if (iterator.hasNext()) {
               item = iterator.next();
           }
       }
       return item != null;
   }
}
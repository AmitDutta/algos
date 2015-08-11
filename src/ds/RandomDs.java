package ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// It will support insert, delete, get, delete random all in O(1) time
// We can not do random delete in linked list in O(1). We know size, but 
// we don't have a index mechanism to access that item. We may have a map,
// but that is not ordered.
// We will use arraylist and hashmap
// get should be getat, this is not key value, just item. so nothing to get
// by item
// We need the map here because all the methods are accessed with the item,
// not index
public class RandomDs <T> {
   private List<T> lst;
   private Map<T, Integer> map;
   private Random rand;
   public RandomDs() {
      lst = new ArrayList<T>();
      map = new HashMap<T, Integer>();
      rand = new Random();
   }
   public void add(T item) {
      if (!map.containsKey(item)) {
         lst.add(item);
         map.put(item, lst.size() - 1);
      }
   }
   public boolean search (T item) {
      return map.containsKey(item);
   }
   // arraylist backed by array, get is o(1)
   public T get(int index) {
      return lst.get(index);
   }
   // swap with last item so that we don't have wholes in the collection
   // removing from last is o(1)
   public void delete(T item) {
      int index= map.get(item);
      map.remove(item);
      // swap with last item
      /*if (index < lst.size() - 1) {
         T lastItem = lst.get(lst.size() - 1);
         lst.set(index, lastItem);
          // update map
      }*/
      T last = lst.get(lst.size() - 1);
      Collections.swap(lst, index, lst.size() - 1); // clean code
      map.put(last, index);
      lst.remove(lst.size() - 1);
   }
   public void deleteRandom() {
      int r = rand.nextInt(lst.size());
      T itm = lst.get(r);
      delete(itm);
   }
   public T getRandom() {
      return lst.get(rand.nextInt(lst.size()));
   }
}

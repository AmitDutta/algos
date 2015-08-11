package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.*;

public class Subtract {
   // assume number presented by a is greate or equal than b
   public List<Integer> subtract(Iterator<Integer> a, Iterator<Integer> b) {
      List<Integer> lst = new ArrayList<Integer>();
      int hand = 0;
      while (a.hasNext() && b.hasNext()) {
         int aa = a.next();
         int bb = b.next() + hand;
         if (aa >= bb) {
            lst.add(aa - bb);
            hand = 0;
         } else {
            lst.add((10 + aa) - bb);
            hand = 1;
         }
      }
      if (!b.hasNext()) {
         while (a.hasNext()) {
            int aa = a.next();
            int bb = hand;
            if (aa >= bb) {
               lst.add(aa - bb);
               hand = 0;
            } else {
               lst.add((10 + aa) - bb);
               hand = 1;
            }
         }
      }
      Collections.reverse(lst);
      // remove starting zeros from lst;
      return lst;
   }
   
   @Test
   public void test1() {
      // 10000 - 9
      List<Integer> l1 = Arrays.asList(0,0,0,0, 1);
      List<Integer> l2 = Arrays.asList(9);
      List<Integer> result = subtract(l1.iterator(), l2.iterator());
      for (Integer i : result) {
         System.out.print(i);
      }
      System.out.println();
   }
   @Test
   public void test2() {
      // 36 - 9
      List<Integer> l1 = Arrays.asList(6, 3);
      List<Integer> l2 = Arrays.asList(5, 3);
      List<Integer> result = subtract(l1.iterator(), l2.iterator());
      for (Integer i : result) {
         System.out.print(i);
      }
      System.out.println();
   }
}

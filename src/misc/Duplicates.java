package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class Duplicates {
   // the array has 1 to n-1, and length n, find all duplicate numbers
   public List<Integer> findAllDuplicates(int[] a) {
      List<Integer> lst = new ArrayList<Integer>();
      for (int i = 0; i < a.length; ++i) {
         int k = Math.abs(a[i]);
         if (a[k] < 0) {
            lst.add(k);
         } else {
            a[k] = -a[k];
         }
      }
      return lst;
   }
   @Test
   public void test1() {
      List<Integer> actual =findAllDuplicates(new int[] {3,2,1,1,3});
      List<Integer> expected = Arrays.asList(1,3);
      Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
      actual =findAllDuplicates(new int[] {1, 2, 3, 1, 3, 6, 6});
      expected = Arrays.asList(1,3,6);
      Assert.assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
   }
}

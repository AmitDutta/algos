package misc;

import org.junit.*;

public class SawTooth {
   private void swap(int[] a, int m, int n) {
      int t = a[m];
      a[m] = a[n];
      a[n] = t;
   }
   // a < b > c < d > e < f
   // just maintain the invariant
   public void convert(int[] a) {
      // if i is even, look for smaller relation
      // else look for even relation
      for (int i = 0; i < a.length - 1; ++i) {
         if ((i & 1) == 1) {
            // odd case
            if (a[i] < a[i + 1]) {
               swap(a, i, i + 1);
            }
         } else {
            //even case
            if (a[i] > a[i + 1]) {
               swap(a, i , i + 1);
            }
         }
      }
   }
   
   @Test
   public void test1() {
      int[] a = new int[] {5,2,10,1,3,4};
      convert(a);
      for (int i = 0; i < a.length; ++i) {
         System.out.println(a[i]);
      }
   }
}
package ib;

import org.junit.*;

public class Inversions {
   private int merge(int[] a, int lo, int mid, int hi) {
      int[] c = new int[hi - lo + 1];
      int inv = 0;
      int i = lo, j = mid + 1, k = 0;
      while (true) {
         if (i > mid || j > hi) {
            break;
         }
         if (a[i] < a[j]) {
            c[k++] = a[i++];
         } else if (a[j] < a[i]) {
            inv += mid -  i + 1; // count inversions
            c[k++] = a[j++];
         } else {
            c[k++] = a[i++];
            c[k++] = a[j++];
         }
      }
      if (i > mid) {
         while (j <= hi) {
            c[k++] = a[j++];
         }
      } else {
         while (i <= mid) {
            c[k++] = a[i++];
         }
      }
      k = 0;
      for (i = lo; i <= hi; ++i) {
         a[i] = c[k++];
      }
      return inv;
   }
   public int mergeSort(int[] a, int lo, int hi) {
      int invs = 0;
      if (lo < hi) {
         int mid = lo + (hi - lo)/2;
         invs += mergeSort(a, lo, mid);
         invs += mergeSort(a, mid + 1, hi);
         invs += merge(a, lo, mid, hi);
      }
      return invs;
   }
   public int brute(int[] a) {
      int invs = 0;
      for (int i = 0; i < a.length; ++i) {
         for (int j = i + 1; j < a.length; ++j) {
            if (a[j] < a[i]) {
               invs++;
            }
         }
      }
      return invs;
   }
   @Test
   public void test1() {
      int[] a = {5,6,4,4,3,2,1};
      int exp = brute(a);
      Assert.assertEquals(exp, mergeSort(a, 0, a.length - 1));
   }
}

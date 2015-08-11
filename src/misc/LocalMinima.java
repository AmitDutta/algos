package misc;
import org.junit.*;
public class LocalMinima {
   public int minima(int[] a) {
      if (a.length == 0) return 0;
      int lo = 0, hi = a.length - 1;
      while (true) {
         if (lo + 1 == hi) {
            if (a[lo] > a[hi]) {
               lo = hi;
            }
            break;
         }
         int mid = lo + (hi - lo)/2;
         if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
            return mid;
         }
         if (a[mid] > a[mid - 1]) {
            hi = mid;
         } else {
            lo = mid;
         }
      }
      return lo;
   }
   @Test
   public void test1() {
      Assert.assertEquals(1, minima(new int[] {2,1,2}));
      int[] a = new int[] {1,2,3,4,5};
      Assert.assertEquals(0, minima(a));
      a = new int[] {5,4,3,2,1};
      Assert.assertEquals(4, minima(a));
   }
}

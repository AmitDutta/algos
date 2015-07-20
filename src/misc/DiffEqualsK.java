package misc;

import java.util.HashSet;
import java.util.Set;
import org.junit.*;

public class DiffEqualsK {
   // return all pairs a,b whose diff equals k
   // this is a bit trickier.. a-b=k; a[i] can be both a or b
   // if a = b + k, if b = a - k; a and b are nothing but a[i]
   // so just look for a[i] in the map
   public void diff(int[] a, int k) {
      Set<Integer> set = new HashSet<Integer>();
      for (int i = 0; i < a.length; ++i) {
         set.add(a[i]);
      }
      for (int i = 0; i < a.length; ++i) {
         if (set.contains(a[i] + k)) {
            int x = a[i] + k;
            System.out.print(x + "," + a[i] + " ");
         }
         if (set.contains(a[i] - k)) {
            int y = a[i] - k;
            System.out.print(a[i] + "," + y + " ");
         }
         // to remove duplicate, remove a[i] from the map
         // 4,1 = 3..for 4 we get one pair, for 1 we get another pari..
         set.remove(a[i]);
      }
      System.out.println();
   }
   
   @Test
   public void test1() {
      diff (new int[] {1,5,3,4,2}, 3);
   }
}

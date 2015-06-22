package leetcodeoj;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.*;

// Insted of n^2; first sort and then look for the difference
public class Problem220 {
   private class Pair {
      private int value;
      private int index;
      public Pair(int value, int index) {
         this.value = value;
         this.index = index;
      }
      public String toString() {
         return "(" + value + "," + index + ")";
      }
   }
   public class PairComparator implements Comparator<Pair> {
      @Override
      public int compare(Pair o1, Pair o2) {
         return o1.value - o2.value;
      }
   }
   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      Pair[] pairs = new Pair[nums.length];
      for (int i = 0; i < nums.length; ++i) {
         pairs[i] = new Pair(nums[i], i);
      }
      Arrays.sort(pairs, new PairComparator());
      for (int i = 0; i < pairs.length; ++i) {
         int j = i + 1;
         while (j < pairs.length && 
               Math.abs((long)pairs[i].value - (long)pairs[j].value) <= t) {
               if (Math.abs(pairs[i].index - pairs[j].index) <= k) {
                  return true;
               }
            j++;
         }
      }
      return false;
   }
   @Test
   public void test1() {
      Assert.assertFalse(containsNearbyAlmostDuplicate(new int[] {-3, 3}, 2, 4));
      Assert.assertTrue(containsNearbyAlmostDuplicate(new int[] {7, 1, 3}, 2, 3));
   }
   @Test
   public void test2() {
      Assert.assertTrue(containsNearbyAlmostDuplicate(new int[] {1, 3, 6, 2}, 1, 2));
   }
   @Test
   public void test3() {
      Assert.assertFalse(containsNearbyAlmostDuplicate(new int[] {-1,2147483647}, 1, 2147483647));
   }
}

package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.*;
public class DataStreamMedian {
   private class MaxComparator implements Comparator<Integer> {
      @Override
      public int compare(Integer o1, Integer o2) {
         return o2 - o1;
      }
   }
   public int[] medianII(int[] nums) {
      if (nums == null) return null;
      PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
      PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(11, new MaxComparator());
      int[] result = new int[nums.length];
      for (int i = 0; i < nums.length; ++i) {
         int n = i + 1; // this is nth item
         // if n is odd, item will be inserted to max; since max always have
         // one more item
         if (n % 2 == 1) {
            if (!minpq.isEmpty() && minpq.peek() < nums[i]) {
               maxpq.offer(minpq.poll());
               minpq.offer(nums[i]);
            } else {
               maxpq.offer(nums[i]);
            }
         } else {
            if (maxpq.peek() > nums[i]) {
               minpq.offer(maxpq.poll());
               maxpq.offer(nums[i]);
            } else {
               minpq.offer(nums[i]);
            }
         }
         /*if (n % 2 == 0) {
            result[i] = (maxpq.peek() + minpq.peek())/2;
         } else {
            result[i] = maxpq.peek();
         }*/
         result[i] = maxpq.peek();
      }
      return result;
   }
   @Test
   public void test1() {
      int[] a = {1,2,3,4,5};
      int[] exp = {1,1,2,2,3};
      Assert.assertArrayEquals(exp, medianII(a));
   }
   @Test
   public void test2() {
      int[] a = {4, 5, 1, 3, 2, 6, 0};
      int[] exp = {4, 4, 4, 3, 3, 3, 3};
      Assert.assertArrayEquals(exp, medianII(a));
   }
   @Test
   public void test3() {
      int[] a = {2, 20, 100};
      int[] exp = {2,2,20};
      Assert.assertArrayEquals(exp, medianII(a));
   }
}

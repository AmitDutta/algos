package leetcodeoj;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.junit.*;

public class Problem239 {
   // We do not require the pair class, instead just keep the
   // indices in the queue..that should be good enough
   // This solve is with O(nlogk)
   // if we just keep indices, we require to pass the array to comparator
   // to sort etc..then we need to store the array as private variable etc
   private class Pair {
      private int value;
      private int index;
      public Pair(int index, int value) {
         this.index = index;
         this.value = value;
      }
   }
   private class PairComparator implements Comparator<Pair> {

      @Override
      public int compare(Pair o1, Pair o2) {
         return o2.value - o1.value;
      }
      
   }

   public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums.length == 0) {
         return nums;
      }
      int[] result = new int[nums.length - k + 1];
      int x = 0;
      PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new PairComparator());
      for (int i = 0; i <= nums.length - k; ++i) {
         if (i == 0) {
            for (int p = i; p < i + k; ++p) {
               queue.offer(new Pair(p, nums[p]));
            }
         } else {
            queue.offer(new Pair(i + k - 1, nums[i + k - 1]));
         }

         while (queue.size() > 0) {
            if (queue.peek().index >= i) {
               result[x++] = queue.peek().value;
               break;
            } else {
               // this item is at the left of current window..
               queue.poll();
            }
         }
      }
      return result;
   }
   // This is using deque..amortized runtime O(n)
   public int[] maxSlidingWindow1(int[] nums, int k) {
      Deque<Integer> dq = new LinkedList<Integer>();
      if (nums.length == 0) {
         return nums;
      }
      int[] result = new int[nums.length - k + 1];
      int x = 0;
      for (int i = 0; i < k; ++i) {
         while (dq.size() > 0 && nums[i] > nums[dq.peekLast()]) {
            dq.removeLast();
         }
         dq.addLast(i);
      }
      for (int i = k; i < nums.length; i++) {
         result[x++] = nums[dq.peekFirst()];
         while (dq.size() > 0 && nums[i] > nums[dq.peekLast()]) {
            dq.removeLast();
         }
         // we are always adding at end of a window. so, i -k th item is 
         // not valid
         if (dq.size() > 0 && dq.peekFirst() <= i - k) {
            dq.removeFirst();
         }
         dq.addLast(i);
      }
      result[x++] = nums[dq.peek()];
      return result;
   }
   @Test
   public void test1() {
      int[] a = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
      Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, a);
   }
   @Test
   public void test2() {
      int[] a = maxSlidingWindow(new int[] {1, -1}, 1);
      Assert.assertArrayEquals(new int[] {1, -1}, a);
   }
   @Test
   public void test3() {
      int[] a = maxSlidingWindow(new int[] {9,10,9,-7,-4,-8,2,-6}, 5);
      Assert.assertArrayEquals(new int[] {10, 10, 9, 2}, a);
   }
   @Test
   public void test4() {
      int[] a = maxSlidingWindow(new int[] {-7,-8,7,5,7,1,6,0}, 4);
      Assert.assertArrayEquals(new int[] {7,7,7,7,7}, a);
   }
   @Test
   public void test5() {
      int[] a = maxSlidingWindow(new int[] {-95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22}, 10);
      int[] x = new int[] {92,94,94,94,94,94,94,94,94,94,94,91,91,91,91,91,91,91,93,93,93,93,93,93,93,93,93,93,63,100,100,100,100,100,100,100,100,100,100,59,48,87,87,87,87,87,87,87,87,87,100,100,100,100,100,100,100,100,100,100,78,78,78,78,78,83,83,83,83,83,83,86,86,86,86,86,86,86,86,86,86,84,84,84,54,54,54,54,80,80,80};
      Assert.assertArrayEquals(x, a);
   }
}

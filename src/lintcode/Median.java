package lintcode;
import org.junit.*;
public class Median {
   private int partition(int[] a, int low, int high) {
      int p = low - 1;
      for (int i = low; i < high; ++i) {
          if (a[i] <= a[high]) {
              ++p;
              int tmp = a[p];
              a[p] = a[i];
              a[i] = tmp;
          }
      }
      ++p;
      int tmp = a[high];
      a[high] = a[p];
      a[p] = tmp;
      return p;
  }
  private int kthLargest(int[] a, int k) {
      int low = 0, high = a.length - 1;
      while (low < high) {
          int index = partition(a, low, high);
          if (index == k) {
              return a[index];
          }
          if (index > k) {
             high = index - 1;
          } else {
              low = index + 1;
          }
      }
      return a[low];
  }
  public int median(int[] nums) {
      // write your code here
      return kthLargest(nums, (nums.length - 1)/2);
  }
  @Test
  public void test1() {
     Assert.assertEquals(5, median(new int[] {7,9,4,5}));
     Assert.assertEquals(3, median(new int[] {4,5,1,2,3}));
     Assert.assertEquals(-3, median(new int[] {-1,-2,-3,-100,-1,-50}));
  }
}

package leetcodeoj;
import org.junit.*;
public class Problem162 {
   public int findPeakElement(int[] nums) {
      int start = 0, end = nums.length - 1;
      int peak = 0;
      while (start < end) {
         if (start + 1 == end) {
            if (nums[start] > nums[end]) {
               peak  = start;
            }else {
               peak = end;
            }
            break;
         }
         int mid = end + (start - end) / 2;
         if (nums[mid] < nums[mid -1]) {
            end = mid;
         } else if (nums[mid] < nums[mid + 1]) {
            start = mid;
         } else {
            peak = mid;
            break;
         }
      }
      return peak;
   }
   @Test
   public void tets1() {
      Assert.assertEquals(2, findPeakElement(new int[]{1,2,3,1}));
      Assert.assertEquals(0, findPeakElement(new int[]{4,3,2,1}));
      Assert.assertEquals(3, findPeakElement(new int[]{1,2,3,4}));
      Assert.assertEquals(4, findPeakElement(new int[]{1,2,3,4,5}));
      Assert.assertEquals(0, findPeakElement(new int[]{5,4,3,2,1}));
      Assert.assertEquals(5, findPeakElement(new int[]{4,5,1,2,3,5}));
      Assert.assertEquals(0, findPeakElement(new int[]{1}));
      Assert.assertEquals(1, findPeakElement(new int[]{1,20}));
   }
}

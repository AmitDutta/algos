package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class Problem163 {
   public List<String> findMissingRanges (int[] nums, int lo, int hi) {
      List<String> lst = new ArrayList<String>();
      String str = "";
      if (nums.length == 0) {
         int a = lo;
         int b = hi;
         str = a == b ? "" + a : a + "->" + b;
         lst.add(str);
         return lst;
      }
      if (nums[0] > lo + 1) {
        int a = lo;
        int b = nums[0] - 1;
        str = a == b ? "" + a : a + "->" + b;
        lst.add(str);
      }
      int len = nums.length;
      for (int i = 1; i < nums.length; ++i) {
         int prev = nums[i - 1];
         int cur = nums[i];
         if (cur > prev + 1) {
            int a = prev + 1;
            int b = cur - 1;
            str = a == b ? "" + a : a + "->" + b;
            lst.add(str);
         }
      }
      if (hi > nums[len - 1] + 1) {
         int a = nums[len - 1] + 1;
         int b = hi;
         str = a == b ? "" + a : a + "->" + b;
         lst.add(str);
      }
      return lst;
   }
   
   @Test
   public void test1() {
      System.out.println(findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
      System.out.println(findMissingRanges(new int[] {0}, 0, 99));
      System.out.println(findMissingRanges(new int[] {1,2,3}, 1,3));
      System.out.println(findMissingRanges(new int[] {}, 1,1));
      System.out.println(findMissingRanges(new int[] {-1}, -1,-1));
   }
}

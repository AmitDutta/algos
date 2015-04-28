package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem69 {
   // This binary search is very special ..
   // Tricky corner cases..devise the condition
   // thinking about 4
   public int mySqrt(int x) {
      if (x <= 0) return 0;
      if (x == 1) return x;
      long start = 0, end = 1  + x/2; /* for 4*/
      long cur = -1, mid = - 1;
      while (true) {
         if (start + 1 == end) {
            break;
         }
         mid = end + (start - end) / 2;
         cur = mid * mid;
         if (cur == x) {
            return (int) mid;
         }else {
            if (cur > x) {
               end = mid;
            }else {
               start = mid;
            }
         }
      }
      return (int)start;
   }
   
   @Test
   public void mySqrtTest1() {
      Assert.assertEquals(6, mySqrt(36));
      Assert.assertEquals(12, mySqrt(144));
      Assert.assertEquals(10, mySqrt(100));
   }
   
   @Test
   public void mySqrtTest2() {
      Assert.assertEquals(2, mySqrt(4));
   }
   
   @Test
   public void mySqrtTest3() {
      Assert.assertEquals(1, mySqrt(1));
   }
   
   @Test
   public void mySqrtTest4() {
      Assert.assertEquals(5, mySqrt(30));
      Assert.assertEquals(7, mySqrt(60));
   }
   
   @Test
   public void mySqrtTest5() {
      Assert.assertEquals(8, mySqrt(65));
   }
   
   @Test
   public void mySqrtTest6() {
      Assert.assertEquals(46339, mySqrt(2147395599));
   }
}

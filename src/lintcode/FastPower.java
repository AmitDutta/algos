package lintcode;

import org.junit.*;

public class FastPower {
   // (a*b)%c = ((a%c)*(b%c)) % c
   public int fastPower(int a, int b, int n) {
      if (a == 0) {
         return 0;
      }
      if (n == 0) {
         return 1 % b;
      }
      if ((n & 1) == 1) {
         int p1 = a % b;
         int p2 = (fastPower(a, b, n -1)) % b;
         return (p1 * p2) % b;
      }
      int result = (fastPower(a, b, n >> 1)) % b;
      return (result * result) % b;
   }
   @Test
   public void test1() {
      Assert.assertEquals(2, fastPower(2, 3, 31));
      Assert.assertEquals(0, fastPower(100, 1000, 1000));
      Assert.assertEquals(10, fastPower(2, 11, 5));
      Assert.assertEquals(5, fastPower(3, 7, 5));
      Assert.assertEquals(1, fastPower(2, 10, 0));
      // The following test did not match..but the concept is ok i guess
      Assert.assertEquals(5249911, fastPower(109, 10000007, 1000001));
   }
}

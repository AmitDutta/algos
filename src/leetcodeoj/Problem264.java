package leetcodeoj;

import org.junit.*;

public class Problem264 {
   public int nthUglyNumber(int n) {
      int[] ugly = new int[n];
      ugly[0] = 1;
      int i2, i3, i5;
      i2 = i3 = i5 = 0;
      for (int i = 1; i < n; ++i) {
         int nexti2 = ugly[i2] * 2;
         int nexti3 = ugly[i3] * 3;
         int nexti5 = ugly[i5] * 5;
         ugly[i] = Math.min(nexti2, Math.min(nexti3, nexti5));
         if (ugly[i] == nexti2) {
            ++i2;
         }
         if (ugly[i] == nexti3) {
            ++i3;
         }
         if (ugly[i] == nexti5) {
            ++i5;
         }
      }
      return ugly[n - 1];
   }
   @Test
   public void test1() {
      Assert.assertEquals(1, nthUglyNumber(1));
      Assert.assertEquals(12, nthUglyNumber(10));
      Assert.assertEquals(10, nthUglyNumber(9));
      Assert.assertEquals(16, nthUglyNumber(12));
   }
}

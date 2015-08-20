package leetcodeoj;

import org.junit.*;

public class P263 {
   public boolean isUgly(int num) {
      if (num == 1) return true;
      while (num % 2 == 0) {
         num = num / 2;
      }
      while (num %3 == 0) {
         num = num / 3;
      }
      while (num % 5 == 0) {
         num = num / 5;
      }
      return num == 1 ? true : false;
      /*int k = 2;
      int orig = num > 0 ? num : -num;
      while (num != 1) {
         if (num/k == 0) {
            num = num/k;
            if (k > 5) {
               return false;
            }
            if (k > orig/2) {
               return false;
            }
         } else {
            k++;
         }
      }*/
   }
   @Test
   public void test1() {
      Assert.assertTrue(isUgly(1));
      Assert.assertFalse(isUgly(14));
      Assert.assertTrue(isUgly(6));
      Assert.assertTrue(isUgly(8));
   }
}

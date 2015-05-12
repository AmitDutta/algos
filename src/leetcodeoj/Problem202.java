package leetcodeoj;

import java.util.HashSet;
import java.util.Set;

import org.junit.*;

public class Problem202 {
   public boolean isHappy(int n) {
      int inp = n;
      Set<Integer> set = new HashSet<Integer>();
      boolean happy = false;
      while (true) {
         int tmp = 0;
         while (inp > 0) {
            int digit = inp % 10;
            inp /= 10;
            tmp += Math.pow(digit, 2);
         }
         if (tmp == 1) {
            happy = true;
            break;
         } else if (set.contains(tmp)) {
            break;
         } else {
            set.add(tmp);
            inp = tmp;
         }
      }
      return happy;
   }
   @Test
   public void happyTest1() {
      Assert.assertTrue(isHappy(19));
      Assert.assertTrue(isHappy(790));
      Assert.assertTrue(isHappy(1000));
      Assert.assertFalse(isHappy(4));
      Assert.assertFalse(isHappy(299));
   }
}

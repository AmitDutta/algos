package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem172 {

   // Theory: http://www.purplemath.com/modules/factzero.htm
   public int trailingZeroes(int n) {
      int zeros = 0;
      long div = 5; 
      // Why long? Since n can be int.maxvalue, we need some div
      // grater than n to break loop
      while (n >= div) {
         zeros += (n / div);
         div *= 5;
      }
      return zeros;
   }

   @Test
   public void trailingZeroes() {
      Problem172 p172 = new Problem172();
      Assert.assertEquals(2, p172.trailingZeroes(10));
      Assert.assertEquals(24, p172.trailingZeroes(101));
      Assert.assertEquals(249, p172.trailingZeroes(1000));
      Assert.assertEquals(1151, p172.trailingZeroes(4617));
      Assert.assertEquals(536870902, p172.trailingZeroes(2147483647));
   }
}

package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem190 {
   public int reverseBits(int n) {
      int result = 0;
      int turn = 0;
      while (turn < 32) {
         result = result << 1;
         int lastbit = n & 1;
         result = result | lastbit;
         n = n >> 1;
         turn++;
      }
      return result;
   }
   
   @Test
   public void reverseBitsTest() {
      Problem190 p190 = new Problem190();
      p190.reverseBits(3);
      Assert.assertEquals(964176192, p190.reverseBits(43261596));
   }
}

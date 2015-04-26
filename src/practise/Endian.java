package practise;

import org.junit.Assert;
import org.junit.Test;

public class Endian {
   public int toLittle16bit(int num) {
      return (num >> 8 | (num & 255) << 8);
   }
   public int toLittle32bit(int num) {
      // can be done in one line though..
      int part1 = num << 24;
      int part2 = (num & 0b00000000000000001111111100000000) << 8;
      int part3 = (num & 0b00000000111111110000000000000000) >> 8;
      int part4 = num >> 24;
      return part1 | part2 | part3 | part4;
   }

   @Test
   public void toLittle16bitTest() {
      int i = Integer.parseInt("90AB", 16);
      Assert.assertEquals("ab90", Integer.toHexString(toLittle16bit(i)));
   }
   
   @Test
   public void toLittle32bit() {
      int i = Integer.parseInt("01ab12cd", 16);
      Assert.assertEquals("cd12ab01", Integer.toHexString(toLittle32bit(i)));
   }
}

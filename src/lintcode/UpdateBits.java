package lintcode;

// setting a particular bit to 1 is easy, but 0?
// we can not just do and, that will cause all bits of target to 0
// take 1, do left shitf, xor with FF.. this is give 111101111, now do and
public class UpdateBits {
   public int updateBits(int n, int m, int i, int j) {
      int x = 1;
      while (i <= j) {
          int last = 1 & m;
          if (last == 1) {
              n |= (last << i);
          } else {
              // can not do and directly
              int mask = (0xFFFFFFFF ^ (1 << i));
              n &= mask;
          }
          m = m >> 1;
          i++;
      }
      return n;
   }
}

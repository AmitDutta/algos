package lintcode;

public class TrailingZeros {
   public long trailingZeros(long n) {
      long k = 5, count = 0;
      while (true) {
          long m = n / k;
          count += m;
          if (m == 0) {
              break;
          }
          k *= 5;
      }
      return count;
  }
}

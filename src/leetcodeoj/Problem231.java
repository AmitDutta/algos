package leetcodeoj;

public class Problem231 {
   public boolean isPowerOfTwo(int n) {
      long k = (long) n;
      if (k == 0) return false;
      return (k & (k - 1)) == 0;
  }
}

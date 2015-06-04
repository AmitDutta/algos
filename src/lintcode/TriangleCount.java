package lintcode;
import org.junit.*;
import java.util.Arrays;

public class TriangleCount {
   public int triangleCount(int S[]) {
      int cnt = 0;
      Arrays.sort(S);
      for (int end = S.length - 1; end > 1; --end) {
         int start = 0, j = end - 1;
         while (start < j) {
            if (S[start] + S[j] <= S[end]) {
               // adjust start to meet triangle requirement
               start++;
            } else {
               // [start......j end], since array is sorted
               // all points in between j and start will satisfy
               // triangle inequality
               cnt += j - start;
               --j;
            }
         }
      }
      return cnt;
   }
   @Test
   public void test1() {
      Assert.assertEquals(4, triangleCount(new int[] {4,4,4,4}));
      Assert.assertEquals(3, triangleCount(new int[] {3,4,6,7}));
   }
}

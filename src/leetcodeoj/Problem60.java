package leetcodeoj;

import org.junit.*;

public class Problem60 {
   private int id = 0;
   private String str;
   // TLE n = 9, k = 138270
   // Is there a good way to generate nth permutation?
   public void getPermutationInt(int n, int k, StringBuffer buffer,
                                   boolean[] used) {
      if (buffer.length() == n) {
         ++id;
         if (id == k) {
            str = buffer.toString();
         }
         return;
      }
      for (int i = 1; i <= n; ++i) {
         if (!used[i]) {
            buffer.append(i);
            used[i] = true;
            getPermutationInt(n, k, buffer, used);
            used[i] = false;
            buffer.setLength(buffer.length() - 1);
         }
      }
   }
   
   public String getPermutation(int n, int k) {
      str = "";
      id = 0;
      getPermutationInt(n, k, new StringBuffer(), new boolean[n + 1]);
      return str;
   }
   
   @Test
   public void getPermutationTest() {
      Assert.assertEquals("123", getPermutation(3, 1));
      Assert.assertEquals("1", getPermutation(1, 1));
      Assert.assertEquals("321", getPermutation(3, 6));
   }
}

package lintcode;

import org.junit.*;

// This algorithm does not work for 254193, 1
// It always tries to remove largest digit
// but here deleting 9 will give 25413
// but smallest 24193 


// One solve:
// If a digit is greater than the next one delete it.
// If the array is increasingly sorted, delete last one.

// This is very tricky !
public class DeleteDigits {
   public String DeleteDigits(String A, int k) {
      while (k > 0) {
         boolean found = false;
         for (int i = 0; i < A.length() - 1; ++i) {
            if (A.charAt(i + 1) < A.charAt(i)) {
               A = A.substring(0, i) + A.substring(i + 1);
               found = true;
               break;
            }
         }
         if (!found) {
            A = A.substring(0, A.length() - 1);
         }
         k--;
      }
      int p = 0;
      while (A.charAt(p) == '0') {
         ++p;
      }
      A = A.substring(p);
      return A;
   }
   @Test
   public void test1() {
      Assert.assertEquals("12", DeleteDigits("178542", 4));
      Assert.assertEquals("1234", DeleteDigits("12345", 1));
      Assert.assertEquals("24193", DeleteDigits("254193", 1));
      Assert.assertEquals("24193", DeleteDigits("254193", 1));
      Assert.assertEquals("24", DeleteDigits("90249", 2));
   }
}

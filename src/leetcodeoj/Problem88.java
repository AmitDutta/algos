package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem88 {
   public void merge(int A[], int m, int B[], int n) {
      int k = m + n - 1;
      int a = m  - 1;
      int b = n - 1;
      while (a >= 0 && b >= 0) {
         if (A[a] > B[b]) {
            A[k] = A[a];
            k--;
            a--;
         }else if (A[a] < B[b]) {
            A[k] = B[b];
            b--;
            k--;
         }else {
            A[k--] = A[a--];
            A[k--] = B[b--];
         }
      }
      
      if (a < 0) {
         while (b >= 0) {
            A[k--] = B[b--]; 
         }
      }
   }
   
   @Test
   public void mergeTest() {
      int A[] = new int[6];
      A[0] = 1;
      A[1] = 2;
      A[2] = 3;
      int B[] = {4,5,6};
      merge(A, 3, B, 3);
      for (int i = 0; i < A.length; ++i) {
         System.out.print(A[i] + " "); 
      }
      System.out.println();
   }
}

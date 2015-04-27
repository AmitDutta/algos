package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem80 {
   // These are tricky in index calculation..
   public int removeDuplicates(int[] A) {
      if (A.length == 0) return 0;
      int j = 0, count = 1;
      for (int i = 1; i < A.length; ++i) {
         if (A[i] == A[j]) {
            count++;
         }else {
            if (count >= 2) {
               A[j + 1] = A[j];
               ++j;
               A[++j] = A[i];
            }else {
               A[++j] = A[i];
            }
            count = 1;
         }
      }
      if (count >= 2) {
         A[j + 1] = A[j];
         ++j;
      }
      return ++j;
   }
   
   @Test
   public void removeDuplicatesTest1() {
      int arr[] = {1,1,1,2,3,3,3};
      int len = removeDuplicates(arr);
      int actual[] = new int[5];
      System.arraycopy(arr, 0, actual, 0, len);
      Assert.assertArrayEquals(new int[] {1,1,2,3,3}, actual);
   }
   
   @Test
   public void removeDuplicatesTest2() {
      int arr[] = {1,1,1,1,3,3};
      int len = removeDuplicates(arr);
      int actual[] = new int[4];
      System.arraycopy(arr, 0, actual, 0, len);
      Assert.assertArrayEquals(new int[] {1,1,3,3}, actual);
   }
   
   @Test
   public void removeDuplicatesTest3() {
      int arr[] = {1,1,1,1,2,2,3};
      int len = removeDuplicates(arr);
      int actual[] = new int[5];
      System.arraycopy(arr, 0, actual, 0, len);
      Assert.assertArrayEquals(new int[] {1,1,2,2,3}, actual);
      
   }
   
   @Test
   public void removeDuplicatesTest4() {
      int arr[] = {1,1,1,1,2,2,3,4,4,4,5,5,5,6};
      int len = removeDuplicates(arr);
      int actual[] = new int[10];
      System.arraycopy(arr, 0, actual, 0, len);
      Assert.assertArrayEquals(new int[] {1,1,2,2,3,4,4,5,5,6}, actual);
      
   }
}

package ib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class numRangeClass {
   public int numRange(ArrayList<Integer> A, int B, int C) {
      int result = 0;
      for (int i = 0; i < A.size(); ++i) {
         int sum = A.get(i);
         if (sum >= B && sum <= C) {
             result++;
         }
         for (int j = i + 1; j < A.size(); ++j) {
            sum += A.get(j);
            if (sum > C) {
               break;
            }
            if (sum >= B && sum <= C) {
              result++;
            }
         }
      }
      return result;
   }
   @Test
   public void test1() {
      List<Integer> a = Arrays.asList(76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66);
      ArrayList<Integer> aa = new ArrayList<Integer>(a);
      Assert.assertEquals(84, numRange(aa, 98, 290));
   }
   @Test
   public void test2() {
      List<Integer> a = Arrays.asList(80, 34, 71, 40, 62, 30, 93, 11, 22, 59, 80, 61, 91, 94, 77, 27, 78, 72, 45, 53, 37);
      ArrayList<Integer> aa = new ArrayList<Integer>(a);
      Assert.assertEquals(154, numRange(aa, 34, 612));
   }
   @Test
   public void test0() {
      List<Integer> a = Arrays.asList(10, 5, 1, 0, 2);
      ArrayList<Integer> aa = new ArrayList<Integer>(a);
      Assert.assertEquals(3, numRange(aa, 6, 8));
   }
   @Test
   public void test3() {
      List<Integer> a = Arrays.asList(1,2,3,4,5);
      ArrayList<Integer> aa = new ArrayList<Integer>(a);
      Assert.assertEquals(8, numRange(aa, 2, 8));
   }
}

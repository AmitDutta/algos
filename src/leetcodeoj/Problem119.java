package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class Problem119 {
   public List<Integer> getRow(int rowIndex) {
      int[] current= new int[rowIndex + 1];
      int[] prev = new int[rowIndex + 1];
      for (int i = 0; i <= rowIndex; ++i) {
         if (i == 0) {
            current[0] = 1;
         }else if (i == 1) {
            current[0] = 1;
            current[1] = 1;
         }else {
            for (int j = 0; j <= i; ++j) {
               if (j == 0 || j == i) {
                  current[j] = 1;
               }else {
                  current[j] = prev[j - 1] + prev[j];
               }
            }
         }
         prev = Arrays.copyOf(current, current.length);
      }
      List<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < prev.length; ++i) {
         result.add(prev[i]);
      }
      return result;
   }
   
   @Test
   public void getRowTest() {
      List<Integer> lst = getRow(5);
      for (Integer i : lst) System.out.print(i + " ");
   }
}

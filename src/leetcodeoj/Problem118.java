package leetcodeoj;

import java.util.*;
import org.junit.*;

public class Problem118 {
   public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> lst = new ArrayList<List<Integer>>();
      if (numRows == 0) return lst;
      for (int i = 1; i <= numRows; i++) {
         List<Integer> items = new ArrayList<Integer>();
         List<Integer> prev = null;
         if (i > 1) {
            prev = lst.get(i - 2);
         }
         for (int j = 1; j <= i; ++j) {
            if (j == 1 || j == i) {
               items.add(1);
            }else {
               items.add(prev.get(j - 2) + prev.get(j - 1));
            }
         }
         lst.add(items);
      }
      return lst;
   }
   
   @Test
   public void generateTest() {
      List<List<Integer>> lst = generate(5);
      for (List<Integer> row : lst) {
         for (Integer i : row) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}

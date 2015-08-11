package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class Problem241 {
   public List<Integer> diffWaysToCompute(String input) {
      List<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < input.length(); ++i) {
         char ch = input.charAt(i);
         if (ch == '+' || ch == '-' || ch == '*') {
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            List<Integer> leftResult = diffWaysToCompute(left);
            List<Integer> rightResult = diffWaysToCompute(right);
            for (int l : leftResult) {
               for (int r : rightResult) {
                  int c = 0;
                  if (ch == '+') {
                     c = l + r;
                  } else if (ch == '-') {
                     c = l - r;
                  } else {
                     c = l * r;
                  }
                  result.add(c);
               }
            }
         }
      }
      if (result.size() == 0) {
         result.add(Integer.valueOf(input));
      }
      return result;
   }
   @Test
   public void test1() {
      List<Integer> result = diffWaysToCompute("2-1-1");
      for (int i : result) {
         System.out.println(i);
      }
   }
}

package leetcodeoj;

import java.util.Stack;
import org.junit.*;

public class Problem150 {
   public boolean isOperator(String str) {
      return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
   }
   public Integer evaluate(String str, Integer i, Integer j) {
      if (str.equals("+")) {
         return i + j;
      }else if (str.equals("-")) {
         return i - j;
      }else if (str.equals("*")) {
         return i * j;
      }
      return i / j;
   }
   public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<Integer>();
      for (String token : tokens) {
         if (!isOperator(token)) {
            stack.push(Integer.parseInt(token));
         }else {
            Integer second = stack.pop();
            Integer first = stack.pop();
            stack.push(evaluate(token, first, second));
         }
      }
      return stack.pop();
   }
   @Test
   public void evalRPNTest() {
      Assert.assertEquals(9, evalRPN(new String[]{"2","1","+","3","*"}));
      Assert.assertEquals(6, evalRPN(new String[]{"4","13","5","/","+"}));
      Assert.assertEquals(3, evalRPN(new String[]{"5","2","-"}));
   }
}

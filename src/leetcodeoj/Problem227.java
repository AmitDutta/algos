package leetcodeoj;

import java.util.Stack;
import org.junit.*;

public class Problem227 {
   private void updateStack(Stack<Integer> stack, char sign, int current) {
      if (sign == '+') {
         stack.push(current);
      } else if (sign == '-') {
         stack.push(-current);
      } else if (sign == '*') {
         stack.push(stack.pop() * current);
      } else {
         stack.push(stack.pop() / current);
      }
   }
   public int calculate(String s) {
      Stack<Integer> stack = new Stack<Integer>();
      int result = 0, current = 0;
      char sign = '+';
      for (int i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch == ' ') {
            continue;
         }
         if (Character.isDigit(ch)) {
            current = 10 * current + (ch - 48);
         } else {
            updateStack(stack, sign, current);
            sign = ch;
            current = 0;
         }
      }
      updateStack(stack, sign, current);
      while (!stack.empty()) {
         result += stack.pop();
      }
      return result;
   }
   
   @Test
   public void test1() {
      Assert.assertEquals(-27, calculate("3-5*2*3"));
      Assert.assertEquals(7, calculate("3+2*2"));
      Assert.assertEquals(1, calculate("  3/2 "));
      Assert.assertEquals(5, calculate(" 3+5 / 2 "));
   }
}

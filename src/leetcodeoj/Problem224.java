package leetcodeoj;

import java.util.Stack;
import org.junit.*;

public class Problem224 {
   // we need operand stack
   //-2-(3-(-5)) need to track operand before braces
   public int calculate(String s) {
      Stack<String> stack = new Stack<String>();
      Stack<Character> opartors = new Stack<Character>();
      int current = 0, val = 0, tmp = 0;
      boolean push = false;
      s = "(" + s + ")";
      for (int i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch == ' ') {
            continue;
         }
         if (Character.isDigit(ch)) {
            current = 10 * current  + (ch - '0');
         } else if (ch == '(') {
            stack.push(Character.toString(ch));
         } else if (ch == '+' || ch == '-') {
            stack.push(Integer.toString(current));
            opartors.push(ch);
            current = 0;
         } else if (ch == ')') {
            while (!stack.peek().equals("(")) {
               if (s.charAt(i - 1) != ')' || s.charAt(i - 1) != ' ') {
                  stack.push(Integer.toString(current));
               }
               char op = opartors.pop();
               int a = Integer.parseInt(stack.pop());
               int b = Integer.parseInt(stack.pop());
               int result = op == '+' ? b + a : b - a;
               val = result;
               if (!stack.peek().equals("(")) {
                  stack.push(Integer.toString(result));
               } else {
                  tmp = result;
                  push = true;
               }
               current = 0;
            }
            stack.pop(); // pop "("
            if (push) {
               stack.push(Integer.toString(tmp));
               push = false;
            }
         }
      }
      return val;
   }
   //@Test
   public void test0() {
      Assert.assertEquals(-4, calculate("1+(2-(3+4))"));
   }
   @Test
   public void test1() {
      //Assert.assertEquals(2, calculate("1 + 1"));
      Assert.assertEquals(3, calculate(" 2-1 + 2 "));
      //Assert.assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)"));
   }
}

package ds;

import java.util.Stack;
import org.junit.*;


public class ExpressionEvaluation {
   /* Prefix evaluation is tricky. Start from right to left, push chars to stack
    * when find a operator, pop 2 char. Here, the first char popped is first
    * digit, second is second..so, if we see -, we pop a, and b..we do a - b,
    * not b - a..then push the result. think (-23) Will require O(n) space,
    *  for a stack*/
   public int evaluatePrefix(String str) {
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = str.length() - 1; i >= 0; --i) {
         char ch = str.charAt(i);
         if (ch >= '0' && ch <= '9') {
            stack.push((int)(ch - '0'));
         } else {
            int a = stack.pop();
            int b = stack.pop();
            if (ch == '+') {
               stack.push(a + b);
            } else if (ch == '-') {
               stack.push(a - b);
            } else if (ch == '*') {
               stack.push(a * b);
            } else {
               stack.push(a / b);
            }
         }
      }
      return stack.pop();
   }
   
   @Test
   public void test1() {
      Assert.assertEquals(17, evaluatePrefix("-+*23*549"));
   }
   
   // One stack, left to right, the item popped first is second, think (23 -)
   /*public int evaluatePostFix(String str) {
      
   }*/
   
   // use two stack method. Can be simpler at times, if only have + and *, 
   // tokenize with + and sum all *
   /*public int evaluateInfix(String str) {
      
   }*/
}

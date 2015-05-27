package misc;

import java.util.Stack;
import org.junit.*;

// Given an array, find maximum j - i where j > i and A[i] < A[j]
// Or find span of all items
public class StockSpan {
   int[] span(int[] nums) {
      int[] s = new int[nums.length];
      Stack<Integer> stack = new Stack<Integer>();
      s[0] = 1;
      stack.push(0);
      for (int i = 1; i < nums.length; ++i) {
         while (!stack.empty()) {
            if (nums[i] > nums[stack.peek()]) {
               stack.pop();
            } else {
               break;
            }
         }
         if (stack.empty()) {
            s[i] =  i + 1;
         } else {
            s[i] = i - stack.peek();
         }
         stack.push(i);
      }
      return s;
   }
   @Test
   public void test1() {
      int[] num1 = {6,4,3,2,5,10};
      int[] exp = {1,1,1,1,4,6};
      Assert.assertArrayEquals(exp, span(num1));
      int[] num2 = {6,3,4,5,2};
      int[] exp2 = {1,1,2,3,1};
      Assert.assertArrayEquals(exp2, span(num2));
   }
}

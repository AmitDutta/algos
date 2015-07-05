package ib;

import java.util.ArrayList;
import org.junit.*;
import java.util.Arrays;
import java.util.Stack;

public class NEXTGREATERCls {
   public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
      if (A.size() == 0) return null;
      Stack<Integer> stack = new Stack<Integer>();
      Integer[] result = new Integer[A.size()];
      for (int i = 0; i < result.length; ++i) {
         result[i] = -1;
      }
      for (int i = 0; i < A.size(); ++i) {
         while (!stack.empty()) {
            int p = stack.peek();
            if (A.get(p) < A.get(i)) {
               stack.pop();
               result[p] = A.get(i);
            } else {
               break;
            }
         }
         stack.push(i);
      }
      return new ArrayList<Integer>(Arrays.asList(result));
   }
   @Test
   public void test1() {
      Integer[] x = {4,5,2,10};
      ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList(x));
      ArrayList<Integer> result = nextGreater(y);
      Integer[] actuals = result.toArray(new Integer[result.size()]);
      Integer[] expecteds = {5,10,10,-1};
      Assert.assertArrayEquals(expecteds, actuals);
   }
   @Test
   public void test2() {
      Integer[] x = {3,2,1};
      ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList(x));
      ArrayList<Integer> result = nextGreater(y);
      Integer[] actuals = result.toArray(new Integer[result.size()]);
      Integer[] expecteds = {-1,-1,-1};
      Assert.assertArrayEquals(expecteds, actuals);
   }
   @Test
   public void test3() {
      Integer[] x = {5,2,3,10,1,20};
      ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList(x));
      ArrayList<Integer> result = nextGreater(y);
      Integer[] actuals = result.toArray(new Integer[result.size()]);
      Integer[] expecteds = {10,3,10,20,20,-1};
      Assert.assertArrayEquals(expecteds, actuals);
   }
}

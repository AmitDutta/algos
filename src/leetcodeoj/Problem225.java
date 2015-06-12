package leetcodeoj;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.*;

public class Problem225 {
   private Queue<Integer> queue = new LinkedList<Integer>();
   // Push element x onto stack.
   public void push(int x) {
       queue.offer(x);
   }

   // Removes the element on top of the stack.
   public void pop() {
      int n = queue.size() - 1;
      while (n > 0) {
         queue.add(queue.poll());
         n--;
      }
      queue.poll();
   }

   // Get the top element.
   public int top() {
      int n = queue.size() - 1;
      while (n > 0) {
         queue.add(queue.poll());
         n--;
      }
      int item = queue.poll();
      queue.offer(item);
      return item;
   }

   // Return whether the stack is empty.
   public boolean empty() {
       return queue.size() == 0;
   }

   @Test
   public void test1() {
      Problem225 p225 = new Problem225();
      Assert.assertTrue(p225.empty());
      for (int i = 1; i <= 10; ++i) {
         p225.push(i);
      }
      Assert.assertFalse(p225.empty());
      for (int i = 10; i >= 1; --i) {
         Assert.assertEquals(i, p225.top());
         p225.pop();
      }
      Assert.assertTrue(p225.empty());
   }
}

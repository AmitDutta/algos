package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem142 {
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
   }
   // Not sure why this is tle, but this should be accepted solution
   public ListNode detectCycle(ListNode head) {
      ListNode slow = head, fast = head;
      if (head == null) return null;
      while (true) {
         if (fast == null || fast.next == null) {
            break;
         }
         ListNode tmp = fast.next;
         //slow = slow.next;
         fast = tmp.next;
         fast = fast.next.next;
         if (fast != null) {
            if (fast.val == slow.val) {
               break;
            }
         }
      }
      if (fast == null || fast.next == null) return null;
      else {
         ListNode cur = head;
         while (cur.val != fast.val) {
            cur = cur.next;
            fast = fast.next;
         }
         return fast;
      }
   }
   
   @Test
   public void detectCycleTest1() {
      ListNode node1 =  new ListNode(1);
      ListNode node2 =  new ListNode(2);
      ListNode node3 =  new ListNode(3);
      ListNode node4 =  new ListNode(4);
      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      //node4.next = node2;
      ListNode result = detectCycle(node1);
      Assert.assertEquals(null, result);
   }
   
   @Test
   public void detectCycleTest2() {
      ListNode node1 =  new ListNode(1);
      ListNode node2 =  new ListNode(2);
      node1.next = node2;
      node2.next = node1;
      //node4.next = node2;
      ListNode result = detectCycle(node1);
      Assert.assertEquals(node1.val, result.val);
   }
}

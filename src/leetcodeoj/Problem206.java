package leetcodeoj;

import org.junit.*;

public class Problem206 {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
   private ListNode newHead = null;
   public ListNode reverseListInt(ListNode head) {
      if (head == null) return head;
      ListNode p = reverseListInt(head.next);
      if (p == null) {
         newHead = head;
         head.next = null;
         return newHead;
      }
      p.next = head;
      head.next = null;
      return head;
   }
   public ListNode reverseList(ListNode head) {
      reverseListInt(head);
      return newHead;
   }
}

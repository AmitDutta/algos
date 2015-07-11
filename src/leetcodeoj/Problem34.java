package leetcodeoj;

import ds.List.ListNode;

public class Problem34 {
   private ListNode reverse(ListNode nd) {
      ListNode cur = nd;
      ListNode p,q = null;
      while (cur != null) {
          p = cur;
          cur = cur.next;
          p.next = q;
          q = p;
      }
      return q;
  }
  public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
          return true;
      }
      ListNode slow, fast;
      slow = fast = head;
      // we can not allow fast to be null, then slow will proceed one step
      // ahead
      while (true) {
          if (fast == null || fast.next == null || fast.next.next == null) {
              break;
          }
          slow = slow.next;
          fast = fast.next.next;
      }
      // slow is in the middle
      ListNode a = slow.next;
      slow.next = null;
      ListNode aa = reverse(a);
      ListNode cur = head;
      while (cur != null && aa != null) {
          if (cur.val != aa.val) {
              return false;
          }
          cur = cur.next;
          aa = aa.next;
      }
      return true;
  }
}

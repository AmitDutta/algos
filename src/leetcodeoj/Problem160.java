package leetcodeoj;

import ds.List.ListNode;

public class Problem160 {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
          return null;
      }
      ListNode result = null;
      int len1 = 0;
      ListNode cur1 = headA;
      while (cur1 != null) {
          len1++;
          cur1 = cur1.next;
      }
      int len2 = 0;
      ListNode cur2 = headB;
      while (cur2 != null) {
          len2++;
          cur2 = cur2.next;
      }
      cur1 = headA;
      cur2 = headB;
      if (len1 > len2) {
          int diff = len1 - len2;
          while (diff > 0) {
              cur1 = cur1.next;
              diff--;
          }
      } else if (len2 > len1) {
          int diff = len2 - len1;
          while (diff > 0) {
              cur2 = cur2.next;
              diff--;
          }
      }
      while (cur1 != null) {
          if (cur1 == cur2) {
              result = cur1;
              break;
          }
          cur1 = cur1.next;
          cur2 = cur2.next;
      }
      return result;
   }
}

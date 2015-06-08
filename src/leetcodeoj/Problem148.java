package leetcodeoj;

import ds.List;
import ds.List.ListNode;

import org.junit.*;

public class Problem148 {
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      ListNode head = null;
      ListNode first = l1;
      ListNode second = l2;
      if (first.val > second.val) {
          ListNode tmp = first;
          first = second;
          second = tmp;
      }
      head = first;
      while (first.next != null) {
          if (first.next.val <= second.val) {
              first = first.next;
          } else {
              ListNode tmp = first.next;
              first.next = second;
              second = tmp;
          }
      }
      if (first.next == null) {
          first.next = second;
      }
      return head;
   }
   private ListNode findMiddle(ListNode head) {
      ListNode slow, fast, prev;
      prev = null;
      slow = fast = head;
      while(true) {
          if (fast == null || fast.next == null) {
              break;
          }
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
      }
      if (prev != null) {
          prev.next = null;
      }
      return slow;
   }
   public ListNode sortList(ListNode head) {
      while (true) {
          ListNode middle = findMiddle(head);
          if (head == middle) {
              break;
          }
          ListNode left = sortList(head);
          ListNode right = sortList(middle);
          return mergeTwoLists(left, right);
      }
      return head;
   }
   @Test
   public void test1() {
      List lst = new List(new int[]{5,4,3,2,1});
      ListNode head = sortList(lst.getHead());
      System.out.println(List.toString(head));
   }
}

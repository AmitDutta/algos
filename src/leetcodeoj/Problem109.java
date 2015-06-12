package leetcodeoj;

import ds.List.ListNode;
import ds.TreeNode;

public class Problem109 {
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
  public TreeNode sortedListToBST(ListNode head) {
      TreeNode node = null;
      ListNode mid = findMiddle(head);
      if (mid == null) return node;
      node = new TreeNode(mid.val);
      // corner case, think we have only one node..
      if (mid == head) {
          node.left = null;
      } else {
          node.left = sortedListToBST(head);
      }
      node.right = sortedListToBST(mid.next);
      return node;
  }
}

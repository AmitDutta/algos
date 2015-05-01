package leetcodeoj;

public class Problem141 {
 
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
   }
   
   public boolean hasCycle(ListNode head) {
      boolean hasCycle = false;
      ListNode slow = head, fast = head;
      while (true) {
         if (fast == null || fast.next == null) {
            break;
         }
         slow = slow.next;
         fast = fast.next.next;
         if (fast != null) {
            if (fast.val == slow.val) {
               hasCycle = true;
               break;
            }
         }
      }
      return hasCycle;
   }
}

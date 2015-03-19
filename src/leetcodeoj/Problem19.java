package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem19 {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

   public ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null) {
         return null;
      }
      ListNode main = head;
      ListNode fast = main;
      ListNode slow = null;
      int k = 0;
      while (fast.next != null) {
         fast = fast.next;
         ++k;
         if (k == n) {
            slow = head;
         }else if (slow != null) {
            slow = slow.next;
         }
      }
      k = k + 1; // total length
      if (n > k) {
         return head;
      } else if (n == k) {
        // Need to delete first item
         ListNode tmp = main;
         main = main.next;
         tmp = null;
      } else {
         if (slow != null) {
            ListNode tmp = slow.next;
            slow.next = tmp.next;
            tmp = null;
         }
      }
      return main;
   }
   
   public boolean assertLinkedListEquals(ListNode head1, ListNode head2) {
      if (head1 == null) return head2 == null;
      if (head2 == null) return head1 == null;
      ListNode cur1 = head1;
      ListNode cur2 = head2;
      while (true) {
         if (cur1 == null) return cur2 == null;
         if (cur2 == null) return cur1 == null;
         Assert.assertEquals(cur1.val, cur2.val);
         // System.out.println(cur1.val + "," + cur2.val);
         cur1 = cur1.next;
         cur2 = cur2.next;
      }
   }
   
   public void print(ListNode node) {
      while (node != null) {
         System.out.print(node.val + "-");
         node = node.next;
      }
      System.out.println();
   }
   
   public ListNode appendAll(int[] data) {
      if (data.length == 0) return null;
      ListNode head = new ListNode(data[0]);
      ListNode cur = head;
      for (int i = 1; i < data.length; ++i) {
         ListNode tmp = new ListNode(data[i]);
         cur.next = tmp;
         cur = tmp;
      }
      return head;
   }
   
   @Test
   public void removeNthFromEndTest() {
      Problem19 p19 = new Problem19();
      ListNode inp = appendAll(new int[] {1, 2, 3, 4, 5});
      ListNode exp = appendAll(new int[] {1, 2, 3, 5});
      assertLinkedListEquals(exp, p19.removeNthFromEnd(inp, 2));
      
      inp = appendAll(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
      exp = appendAll(new int[] {1, 3, 4, 5, 6, 7, 8, 9});
      assertLinkedListEquals(exp, p19.removeNthFromEnd(inp, 8));
      
      inp = appendAll(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
      exp = appendAll(new int[] {2, 3, 4, 5, 6, 7, 8, 9});
      assertLinkedListEquals(exp, p19.removeNthFromEnd(inp, 9));
      
      inp = appendAll(new int[] {1, 2});
      exp = appendAll(new int[] {1, 2});
      assertLinkedListEquals(exp, p19.removeNthFromEnd(inp, 3));
      
      inp = appendAll(new int[] {1});
      assertLinkedListEquals(null, p19.removeNthFromEnd(inp, 1));
      
   }
}

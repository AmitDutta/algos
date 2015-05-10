package leetcodeoj;

import ds.List;
import ds.List.ListNode;

import org.junit.*;

public class Problem83 {
   public ListNode deleteDuplicates(ListNode head) {
      ListNode cur = head, prev = null;
      while (cur != null) {
         if (prev != null) {
            if (prev.val != cur.val) {
               prev.next = cur;
               prev = cur;
            }
         }else {
            prev = head;
         }
         cur = cur.next;
      }
      if (prev != null) {
         prev.next = null;
      }
      return head;
   }
   
   @Test
   public void deleteTest() {
      List list1 = new List();
      list1.addAll(new int[] {1,1,2,2,3,3,4});
      List list2 = new List();
      list1.addAll(new int[] {1,2,3,4});
      Assert.assertTrue(List.areListEquals(list2.getHead(), deleteDuplicates(list1.getHead())));
   }
}

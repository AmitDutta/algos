package leetcodeoj;

import ds.List;
import ds.List.ListNode;

import org.junit.*;

public class Problem203 {
   public ListNode removeElements(ListNode head, int val) {
      ListNode cur = head, prev = null, newHead = null;
      while (cur != null) {
         if (cur.val == val) {
            if (prev != null) {
               prev.next = cur.next;
            }
         }else {
            prev = cur;
            if (newHead == null) {
               newHead = prev;
            }
         }
         cur = cur.next;
      }
      return newHead;
   }
   @Test
   public void deleteTest1() {
      Assert.assertEquals(null, removeElements(null, 6));
   }
   @Test
   public void deleteTest2() {
      List list1 = new List(new int[] {6,6,1,6,2,6});
      List list2 = new List(new int[] {1,2});
      Assert.assertTrue(List.areListEquals(list2.getHead(), removeElements(list1.getHead(), 6)));
      list1 = new List(new int[] {6,6,6});
      Assert.assertEquals(null, removeElements(list1.getHead(), 6));
      list1 = new List(new int[] {6,6,2});
      Assert.assertTrue(List.areListEquals(new List(new int[]{2}).getHead(), removeElements(list1.getHead(), 6)));
   }
   @Test
   public void deleteTest3() {
      List list1 = new List(new int[] {1,2,6,3,4,5,6});
      Assert.assertTrue(List.areListEquals(new List(new int[]{1,2,3,4,5}).getHead(), removeElements(list1.getHead(), 6)));
      list1 = new List(new int[] {1,2,3,4,5});
      Assert.assertTrue(List.areListEquals(new List(new int[]{1,2,3,4,5}).getHead(), removeElements(list1.getHead(), 40)));
   }
}

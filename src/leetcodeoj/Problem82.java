package leetcodeoj;
import ds.List;
import ds.List.ListNode;

import org.junit.*;
public class Problem82 {
   public ListNode deleteDuplicates(ListNode head) {
      ListNode cur = head, prev = null, newHead = null, newCur = null;
      int hop = 0;
      while (cur != null) {
         if (prev != null) {
            if (prev.val != cur.val) {
               if (hop == 1) {
                  if (newHead == null) {
                     newHead = newCur = prev;
                     newHead.next = newCur.next = null;
                  } else {
                     newCur.next = prev;
                     newCur = newCur.next;
                     newCur.next = null;
                  }
               }
               hop = 0;
            }
         }
         prev = cur;
         hop++;
         cur = cur.next;
      }
      if (hop == 1) {
         if (newHead == null) {
            newHead = prev;
            newHead.next = null;
         }else {
            newCur.next = prev;
            if (prev != null) {
               prev.next = null;
            }
         }
      }
      return newHead;
   }
   @Test
   public void deleteDuplicatesTest0() {
      Assert.assertEquals(null, deleteDuplicates(null));
   }
   @Test
   public void deleteDuplicatesTest1() {
      List list = new List();
      list.addAll(new int[]{1,2,3});
      List list2 = new List();
      list2.addAll(new int[] {1,2,3});
      Assert.assertTrue(List.areListEquals(list2.getHead(), deleteDuplicates(list.getHead())));
   }
   @Test
   public void deleteDuplicatesTest2() {
      List list = new List();
      list.addAll(new int[]{1,2,2,3,4,4,5,5,5,5,7});
      List list2 = new List();
      list2.addAll(new int[] {1,3,7});
      ListNode result = deleteDuplicates(list.getHead());
      Assert.assertTrue(List.areListEquals(list2.getHead(), result));
   }
   @Test
   public void deleteDuplicatesTest3() {
      List list = new List();
      list.addAll(new int[]{2,2,3,4,4,5,5,5,5,7});
      List list2 = new List();
      list2.addAll(new int[] {3,7});
      Assert.assertTrue(List.areListEquals(list2.getHead(), deleteDuplicates(list.getHead())));
   }
   @Test
   public void deleteDuplicatesTest4() {
      List list = new List();
      list.addAll(new int[]{1,2,4,4});
      List list2 = new List();
      list2.addAll(new int[] {1,2});
      Assert.assertTrue(List.areListEquals(list2.getHead(), deleteDuplicates(list.getHead())));
   }
}

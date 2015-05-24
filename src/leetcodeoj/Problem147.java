package leetcodeoj;

import org.junit.*;

import ds.List;
import ds.List.ListNode;

public class Problem147 {
   public ListNode insertionSortList(ListNode head) {
      ListNode cur, newHead, prev = head;
      newHead =cur = prev= head;
      while (cur != null && cur.next != null) {
          if (cur.val <= cur.next.val) {
              cur = cur.next;
          } else {
              ListNode tmp = cur.next;
              ListNode oldprev = prev;
              cur.next = cur.next.next;
               if (tmp.val <= prev.val) {
                   tmp.next = prev;
                   prev = tmp;
               } else {
                   ListNode tmpPrev = prev;
                   while (tmpPrev.next.val <= tmp.val) {
                       tmpPrev = tmpPrev.next;
                   }
                   tmp.next = tmpPrev.next; 
                   tmpPrev.next = tmp;
               }
               if (prev.val <= oldprev.val) {
                   newHead = prev;
               } 
          }
      }
      return newHead;
   }
   @Test
   public void test1() {
      ListNode exp = new List(new int[]{1,3,5,6,7}).getHead();
      ListNode actual = insertionSortList(new List(new int[]{6,7,3,5,1}).getHead());
      Assert.assertTrue(List.areListEquals(exp, actual));
   }
   @Test
   public void test2() {
      Assert.assertTrue(insertionSortList(null) == null);
   }
   @Test
   public void test3() {
      ListNode exp = new List(new int[]{-3,4,14,19}).getHead();
      ListNode actual = insertionSortList(new List(new int[]{4,19,14,-3}).getHead());
      Assert.assertTrue(List.areListEquals(exp, actual));
   }
   @Test
   public void test4() {
      ListNode exp = new List(new int[]{-3,1,4,5,5,8,11,14,15,19}).getHead();
      ListNode actual = insertionSortList(new List(new int[]{4,19,14,5,-3,1,8,5,11,15}).getHead());
      Assert.assertTrue(List.areListEquals(exp, actual));
   }
}

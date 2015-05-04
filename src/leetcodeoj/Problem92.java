package leetcodeoj;

import org.junit.*;

import ds.List;
import ds.List.ListNode;

public class Problem92 {

   public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null) return head;
      ListNode cur = head, prev = null;
      int start = 0;
      while (cur != null) {
         start++;
         if (start == m) {
            break;
         }
         prev = cur;
         cur = cur.next;
      }
      ListNode end = cur, p, q;
      p = q = null;
      while (start <= n) {
         p = cur;
         cur = cur.next;
         p.next = q;
         q = p;
         start++;
      }
      if (prev == null) {
         prev = q;
      } else {
         prev.next = q;
      }
      
      if (end != null) {
         end.next = cur;
      }
      return  m > 1 ? head : prev;
   }
   @Test
   public void reverseBetweenTest1() {
      List lst = new List();
      lst.addAll(new int[] {1,4,3,2,5});
      ListNode expected = lst.getHead();

      List lst2 = new List();
      lst2.addAll(new int[] {1,2,3,4,5});
      ListNode actual = reverseBetween(lst2.getHead(), 2, 4);

      Assert.assertTrue(List.areListEquals(expected, actual));
   }
   @Test
   public void reverseBetweenTest2() {
      List lst = new List();
      lst.addAll(new int[] {5,4,3,2,1});
      ListNode expected = lst.getHead();

      List lst2 = new List();
      lst2.addAll(new int[] {1,2,3,4,5});
      ListNode actual = reverseBetween(lst2.getHead(), 1, 5);
      Assert.assertTrue(List.areListEquals(expected, actual));
   }
   @Test
   public void reverseBetweenTest3() {
      List lst = new List();
      lst.addAll(new int[] {3,2,1,4,5});
      ListNode expected = lst.getHead();

      List lst2 = new List();
      lst2.addAll(new int[] {1,2,3,4,5});
      ListNode actual = reverseBetween(lst2.getHead(), 1, 3);
      Assert.assertTrue(List.areListEquals(expected, actual));
   }
   @Test
   public void reverseBetweenTest4() {
      List lst = new List();
      lst.addAll(new int[] {1,2,3});
      ListNode expected = lst.getHead();

      List lst2 = new List();
      lst2.addAll(new int[] {1,2,3});
      ListNode actual = reverseBetween(lst2.getHead(), 3, 3);
      Assert.assertTrue(List.areListEquals(expected, actual));
   }
   @Test
   public void reverseBetweenTest5() {
      List lst = new List();
      lst.addAll(new int[] {1,2,4,3,5});
      ListNode expected = lst.getHead();

      List lst2 = new List();
      lst2.addAll(new int[] {1,2,3,4,5});
      ListNode actual = reverseBetween(lst2.getHead(), 3, 4);
      Assert.assertTrue(List.areListEquals(expected, actual));
   }
}

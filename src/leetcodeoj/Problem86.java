package leetcodeoj;

import ds.List;
import ds.List.ListNode;

import org.junit.*;

public class Problem86 {
   // if else for this problem is very very tricky..
   public ListNode partition(ListNode head, int x) {
      if (head == null) return null;
      ListNode cur, cur_prev, prev;
      cur = head;
      cur_prev = prev = null;
      while (cur != null) {
         if (cur.val >= x) {
            cur_prev = cur;
            cur = cur.next;
         }
         else {
            if (prev == null) {
               // head will change
               if (cur_prev == null) {
                  // cur_prev == null this is the first node
                  
                  /*cur_prev.next = cur.next;
                  head = cur;
                  head.next = cur_prev;
                  prev = head;
                  continue;*/
                  prev = cur;
                  cur_prev = cur;
                  cur = cur.next;
               }else {
                  cur_prev.next = cur.next;
                  cur.next = head;
                  head = cur;
                  prev = cur;
                  cur = cur_prev.next;
               }
            }else{
               if (cur_prev.equals(prev)) {
                  cur_prev = prev = cur;
                  cur = cur.next;
               }else {
                  cur_prev.next = cur.next;
                  cur.next = prev.next;
                  prev.next = cur;
                  prev = cur;
                  cur = cur_prev;
               }
            }
         }
      }
      cur_prev.next = null;
      return head;
   }
   
   @Test
   public void partitionTest0() {
      List lst = new List();
      lst.addAll(new int[] {1,1,4});
      ListNode head = partition(lst.getHead(), 3);
      System.out.println(List.toString(head));
   }
   
   @Test
   public void partitionTest1() {
      List lst = new List();
      lst.addAll(new int[] {1,1,4,3,2,5,2});
      ListNode head = partition(lst.getHead(), 3);
      System.out.println(List.toString(head));
   }
   @Test
   public void partitionTest2() {
      List lst = new List();
      lst.addAll(new int[] {3,2,1});
      ListNode head = partition(lst.getHead(), 3);
      System.out.println(List.toString(head));
   }
   
   @Test
   public void partitionTest3() {
      List lst = new List();
      lst.addAll(new int[] {5,1,4,2,6});
      ListNode head = partition(lst.getHead(), 3);
      System.out.println(List.toString(head));
   }
}

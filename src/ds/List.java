package ds;
public class List {
   public class ListNode {
      public int val;
      public ListNode next;
      public ListNode (int x) {val = x;}
   }
   public ListNode head;
   public void add(int item) {
      if (head == null) {
         head = new ListNode(item);
      }else {
         ListNode tmp = head, prev = null;
         while (tmp != null) {
            prev = tmp;
            tmp = tmp.next;
         }
         if (prev != null) {
            prev.next = new ListNode(item);
         }
      }
   }
   public void addAll(int[] items) {
      for (int item : items) {
         add(item);
      }
   }
   public ListNode getHead() {
      return head;
   }
   @Override
   public String toString() {
      return toString(head);
   }
   public static boolean areListEquals(ListNode node1, ListNode node2) {
      while (true) {
         if (node1 == null) return node2 == null;
         if (node2 == null) return node1 == null;
         if (node1.val != node2.val) return false;
         node1 = node1.next;
         node2 = node2.next;
      }
   }
   public static String toString(ListNode node1) {
      StringBuffer buffer = new StringBuffer();
      ListNode current = node1;
      while (current != null) {
         buffer.append(current.val);
         if (current.next != null) {
            buffer.append("->");
         }
         current = current.next;
      }
      return buffer.toString();

   }
}

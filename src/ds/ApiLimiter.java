package ds;

public class ApiLimiter {
   private class Node {
      private long time;
      private Node next;
      public Node(long time) {
         this.time = time;
         next = null;
      }
   }
   private Node head = null;
   private Node tail = null;
   private int limit, size;
   public ApiLimiter(int limit, int sz) {
      this.limit = limit;
      size = sz;
   }
   // first remove obsolete nodes, if any. then update the list
   // this workflow is v.v. important
   public boolean permit() {
      long time = getCurrentTime();
      while (head != null && head.time < (time - limit)) {
         head = head.next;
         size--;
      }
      if (size == limit) return false;
      Node nd = new Node(time);
      if (head == null) {
         head = tail = nd;
      } else {
         tail.next = nd;
         tail = nd;
      }
      size++;
      return true;
   }
   public static long getCurrentTime() {
      return System.currentTimeMillis();
   }
}

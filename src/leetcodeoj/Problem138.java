package leetcodeoj;
import org.junit.*;
public class Problem138 {
   class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
   }
   public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) return null;
      RandomListNode newHead = null, cur = head, otherCur;
      while (cur != null) {
         RandomListNode node = new RandomListNode(cur.label);
         RandomListNode tmp = cur.next;
         cur.next = node;
         node.next = tmp;
         cur = tmp;
      }
      cur = head;
      while (cur != null) {
         RandomListNode other = cur.next;
         RandomListNode nextcur = other.next;
         //other.next = nextcur == null ? null : nextcur.next;
         // think why can not assign other next
         other.random = cur.random == null ? null : cur.random.next;
         cur = nextcur;
      }
      cur = head;
      newHead = head.next;
      otherCur = newHead;
      RandomListNode temp1, temp2;
      temp1 = temp2 = null;
      // breaking this list is tricky.. careful
      while (true) {
         temp1 = cur.next.next;
         if (temp1 != null) {
            temp2 = cur.next.next.next;
            cur.next = temp1;
            otherCur.next = temp2;
            cur = temp1;
            otherCur = temp2;
         }else {
            cur.next = null; // this the input contains only one node
            break;
         }
      }
      return newHead;
   }
}

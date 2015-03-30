package leetcodeoj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class Problem23 {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }

    static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            int val = 0;
            if (o1.val > o2.val) {
                val = 1;
            }else if (o1.val < o2.val) {
                val = -1;
            }
            return val;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null) return null;
        Queue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
        ListNode head, current;
        head = current = null;
        for (int i = 0; i < lists.size(); ++i) {
            current = lists.get(i);
            if (current != null) {
                pq.offer(lists.get(i));
            }            
        }
        
        while (pq.size() > 0) {
            ListNode tmp = pq.poll();
            if (tmp.next != null) {
                pq.offer(tmp.next);
            }
            
            if (head == null) {
                head = current = tmp;
            } else {
                current.next = tmp;
                current = current.next;
            }
        }
        return head;
    }
    
    @Test
    public void Problem23Test() {
        Problem23 p23 = new Problem23();        
        Assert.assertEquals(null, p23.mergeKLists(null));
        List<ListNode> lst = Arrays.asList(new ListNode(1), new ListNode(0));
        ListNode head = p23.mergeKLists(lst);
        Assert.assertEquals(0, head.val);
        Assert.assertEquals(1, head.next.val);
    }
}

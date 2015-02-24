package leetcodeoj;
import  org.junit.Assert;
import org.junit.Test;

public class Problem4 {
    
    public class ListNode {
        int val;
        ListNode next; 
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        ListNode cur = head;
        int hand = 0;
        int result = 0;
        while (true) {
            if (l1 == null || l2 == null) break;
            result = l1.val + l2.val + hand;
            if (result >= 10) {
                result -= 10;
                hand = 1;
            } else {
                hand = 0;
            }
            
            if (head == null) {
                head = new ListNode(result);
                cur = head;
            }else {
                ListNode node = new ListNode(result);
                cur.next = node;
                cur = node;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode tmp = l1 == null ? l2 : l1;
        while (tmp != null) {
            result = tmp.val + hand;
            if (result >= 10) {
                result = 0;
                hand = 1;
            }else {
                hand = 0;
            }
            ListNode node = new ListNode (result);
            cur.next = node;
            cur = node;
            tmp = tmp.next;
        }
        
        if (hand > 0) {
            ListNode node = new ListNode(hand);
            cur.next = node;
        }
        
        return head;
    }
    
    public void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "-");
            cur = cur.next;
        }
    }
    
    public void assertLinkedListEquals(ListNode expected, ListNode actual) {
        while (true) {
            if(expected == null && actual == null) break;
            if(expected == null) Assert.assertNull(actual);
            if (actual == null) Assert.assertNull(expected);
            Assert.assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }
    
    @Test
    public void addTwoNumbersTest1() {
        ListNode n1 = arrayToList(new int[] {2,4,3});
        ListNode n2 = arrayToList(new int[] {5,6,4});
        ListNode result = arrayToList(new int[] {7,0,8});
        assertLinkedListEquals(result, addTwoNumbers(n1,  n2));    
        
        n1 = arrayToList(new int[] {9,9,9,9});
        n2 = arrayToList(new int[] {9,9,9,9});
        result = arrayToList(new int[] {8,9,9,9,1});
        assertLinkedListEquals(result, addTwoNumbers(n1,  n2));
        
        n1 = arrayToList(new int[]{});
        n2 = arrayToList(new int[]{});
        result = arrayToList(new int[] {});
        assertLinkedListEquals(result, addTwoNumbers(n1,  n2));
        
        n1 = arrayToList(new int[]{});
        n2 = arrayToList(new int[] {1,3});
        result = arrayToList(new int[] {1, 3});
        assertLinkedListEquals(result, addTwoNumbers(n2,  n1));
        
        n1 = arrayToList(new int[]{9});
        n2 = arrayToList(new int[] {9,9,9});
        result = arrayToList(new int[] {8, 0, 0, 1});
        assertLinkedListEquals(result, addTwoNumbers(n2,  n1));
    }
    
    private ListNode arrayToList(int[] array) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < array.length; ++i) {
            ListNode tmp = new ListNode(array[i]);
            if (head == null) {
                head = tmp;
                cur = head;
            }else {
                cur.next = tmp;
                cur = tmp;
            }
        }
        return head;
    }
}

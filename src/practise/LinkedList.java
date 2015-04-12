package practise;

public class LinkedList<T> {
    
    private class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            next =  null;
        }
    }
    
    public void backwards(Node<T> node) {
        if (node == null) return;
        backwards(node.next);
        System.out.println(node.data);
    }
    
    public void create() {
        // for now dummy
        Node<Integer> nd1 = new Node<Integer>(1);
        Node<Integer> nd2 = new Node<Integer>(2);
        Node<Integer> nd3 = new Node<Integer>(3);
        nd1.next = nd2;
        nd2.next = nd3;
        backwards((Node<T>) nd1);
    }
    
    public static void main(String... args) {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        lst.create();
    }

}

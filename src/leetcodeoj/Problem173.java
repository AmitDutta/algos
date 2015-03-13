package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;
import org.junit.Assert;

public class Problem173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    public class BSTIterator {
        private TreeNode node;
        private Stack<TreeNode> stack;
        
        public BSTIterator(TreeNode root) {
            this.node = root;
            stack = new Stack<TreeNode>();
        }
        
        public boolean hasNext() {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return !stack.empty();
        }
        
        public int next() {
            TreeNode result = stack.pop();
            node = result.right;
            return result.val;
        }
    }
    
    public class BST {
        private TreeNode root;
        public void insert(int data) {
            if (root == null) {
                root = new TreeNode(data);
                return;
            }
            TreeNode current = root;
            TreeNode prev = null;
            while (current != null) {
                prev = current;
                if (data > current.val) {
                    current = current.right;
                }else {
                    current = current.left;
                }
            }
            if (prev != null) {
                TreeNode node = new TreeNode(data);
                if (data > prev.val) {
                    prev.right = node;
                }else {
                    prev.left = node;
                }
            }
        }
        
        public void insertRange(int[] data) {
            for (int i = 0; i < data.length; ++i) insert(data[i]);
        }
        
        public TreeNode getRoot() {
            return root;
        }
        
        public List<Integer> toInorder() {
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            boolean done = false;
            TreeNode current = root;
            while (!done) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                if (stack.empty()) {
                    done = true;
                }else {
                    TreeNode item = stack.pop();
                    result.add(item.val);
                    current = item.right;
                }
            }
            return result;
        }
    }
    @Test
    public void BSTIteratorTest()
    {
        BST bst = new BST();
        bst.insertRange(new int[] {10,5,2,7,30,35});
        BSTIterator it = new BSTIterator(bst.getRoot());
        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = Arrays.asList(2,5,7,10,30,35);
        while (it.hasNext()) {
            actual.add(it.next());
        }
        Assert.assertTrue(expected.size() == actual.size() &&
                actual.containsAll(expected));
    }
}

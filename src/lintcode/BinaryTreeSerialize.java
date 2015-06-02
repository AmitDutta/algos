package lintcode;

import java.util.List;
import java.util.Stack;

import org.junit.*;

import ds.TreeNode;

public class BinaryTreeSerialize {
   public String serialize(TreeNode root) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      StringBuffer buffer = new StringBuffer();
      stack.push(root);
      while (stack.size() > 0) {
         TreeNode nd = stack.pop();
         if (nd == null) {
            buffer.append("#,");
         }else {
            buffer.append(nd.val + ",");
            stack.push(nd.right);
            stack.push(nd.left);
         }
      }
      return buffer.substring(0, buffer.length() -1).toString();
   }
   private int index = 0;
   private TreeNode deserializeInt(String[] data) {
      if (index >= data.length || data[index].equals("#")) {
         return null;
      }
      TreeNode node = new TreeNode(Integer.parseInt(data[index]));
      index++;
      node.left = deserializeInt(data);
      index++;
      node.right = deserializeInt(data);
      return node;
    }
   public TreeNode deserialize(String data) {
      index = 0;
      return deserializeInt(data.split(","));
   }
   @Test
   public void test0() {
      TreeNode.AreEqualTree(null, deserialize(serialize(null)));
   }
   @Test
   public void test1() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      node1.left = node2;
      node2.left = node3;
      node3.left = node4;
      TreeNode actual = deserialize(serialize(node1));
      TreeNode.AreEqualTree(node1, actual);
   }
   @Test
   public void test2() {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(4);
      node1.right = node2;
      node2.right = node3;
      node3.right = node4;
      TreeNode actual = deserialize(serialize(node1));
      TreeNode.AreEqualTree(node1, actual);
   }
   @Test
   public void test3() {
      TreeNode node1 = new TreeNode(3);
      TreeNode node2 = new TreeNode(9);
      TreeNode node3 = new TreeNode(20);
      TreeNode node4 = new TreeNode(15);
      TreeNode node5 = new TreeNode(7);
      node1.left = node2;
      node1.right = node3;
      node3.left = node4;
      node3.right = node5;
      TreeNode actual = deserialize(serialize(node1));
      TreeNode.AreEqualTree(node1, actual);
   }
}

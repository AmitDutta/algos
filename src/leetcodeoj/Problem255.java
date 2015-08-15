package leetcodeoj;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.*;

/*
 * 
 * Goal: Verify preorder sequence of Binary Search Tree (BST)
   In general, if we insert all the nodes in given order to bst and take pre order traversal and if they match, that pre order
   is fine. But this require O(nlogn) time and O(n) storage
Problem:
You have an array of preorder traversal of Binary Search Tree ( BST). Your program should verify whether it is a correct sequence or not.

Input: Array of Integer [ Pre-order BST ]
Output: String “Yes” or “No”

To solve above problem, you do not need to construct a Binary Tree from a given pre-order sequence.

The pre-order sequence of binary tree can form a sorted stack. So lets break it in a few “SIMPLE” steps as follows:

Iterate over each element and follow the steps below:

1. Push to stack till you get higher element than the topmost element of the stack. [i.e. you keep pushing till you hit the leftmost leaf]
2. If you find current value which is greater than the TOP of Stack, POP till you hit higher element, and also mark the last poped value, which is your variable (Left_Tree_Highest). This variable is used to check whether the order is correct or not.
3. In all the steps, if you find current element lesser than Left_Tree_Highest, then your tree is not a Binary Search Tree and it should return “NO”.

4. If all the element traversed, and you have not hit “NO”, means given sequence follows the Binary Search Tree rule.
 * 
 * 
 */
public class Problem255 {
   public boolean checkBst(List<Integer> lst) {
      Stack<Integer> stack = new Stack<Integer>();
      Integer leftMax = Integer.MIN_VALUE;
      for (Integer i : lst) {
         if (i < leftMax) {
            return false;
         }
         while (!stack.isEmpty() && stack.peek() < leftMax) {
            leftMax = stack.pop();
         }
         stack.push(i);
      }
      return true;
   }
   @Test
   public void test1() {
      Assert.assertTrue(checkBst(Arrays.asList(100,50,1,79,200,150,170,280)));
   }
}

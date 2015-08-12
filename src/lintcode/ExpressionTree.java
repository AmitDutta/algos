package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExpressionTree {
   public class ExpressionTreeNode {
      public String symbol;
      public ExpressionTreeNode left, right;
         public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
         }
   }
   private Map<Character, Integer> priority;
   public boolean isOperator(String str) {
      return str.length() == 1 && !Character.isDigit(str.charAt(0));
   }
   public List<String> toPostOrder(String[] exp) {
      List<String> result = new ArrayList<String>();
      Stack<Character> stack = new Stack<Character>();
      for (String str : exp) {
         if (str.charAt(0) == '(') {
            stack.push(str.charAt(0));
         } else if (str.charAt(0) == ')') {
            while (!stack.isEmpty()) {
               char ch = stack.pop();
               if (ch == '(') {
                  break;
               } else {
                  result.add(Character.toString(ch));
               }
            }
         } else if (isOperator(str)) {
            int prio = priority.get(str.charAt(0));
            while (!stack.isEmpty() && stack.peek() != '(' && priority.get(stack.peek()) >= prio) {
               result.add(Character.toString(stack.pop()));
            }
            stack.push(str.charAt(0));
         } else {
            result.add(str);
         }
      }
      while (!stack.isEmpty()) {
         result.add(Character.toString(stack.pop()));
      }
      return result;
   }
   public ExpressionTreeNode build(String[] expression) {
      priority = new HashMap<Character, Integer>();
      priority.put('+', 1);
      priority.put('-', 1);
      priority.put('*', 2);
      priority.put('/', 2);
      List<String> lst = toPostOrder(expression);
      Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
      for (String str : lst) {
         ExpressionTreeNode node = new ExpressionTreeNode(str);
         if (isOperator(str)) {
            node.right = stack.pop();
            node.left = stack.pop();
            stack.push(node);
         } else {
            stack.push(node);
         }
      }
      return stack.isEmpty() ? null : stack.pop();
   }
}

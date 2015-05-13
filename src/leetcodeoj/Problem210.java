package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

// This one tells how to find the topo order. If some node does not have
// any 
public class Problem210 {
   private boolean hasCycle = false;
   private List<Integer>[] adj;
   private boolean[] marked;
   private boolean[] onstack;
   private int v;
   List<Integer> order;
   public List<Integer> adj (int v) {
      return adj[v];
   }
   public void addEdge(int from, int to) {
      adj[from].add(to);
   }
   public void dfs(int s) {
      if (hasCycle) {
         return;
      }
      onstack[s] = true;
      marked[s] = true;
      for (int i : adj(s)) {
         if (!marked[i]) {
            dfs(i);
         }else if (onstack[i]) {
            hasCycle = true;
            return;
         }
      }
      onstack[s] = false;
      order.add(s);
   }
   public int[] findOrder(int numCourses, int[][] prerequisites) {
      if (numCourses == 0) return new int[] {};
      if (prerequisites.length == 0) {
         // prerequisits are zero. just put any order
         int[] result = new int[numCourses];
         for (int i = 0; i < numCourses; ++i) {
            result[i] = i;
         }
         return result;
      }
      v = numCourses;
      marked = new boolean[v];
      adj = (ArrayList<Integer> []) new ArrayList[numCourses];
      for (int i = 0; i < numCourses; ++i) {
         adj[i] = new ArrayList<Integer>();
      }
      for (int i = 0; i < prerequisites.length; ++i) {
         int[] pair = prerequisites[i];
         addEdge(pair[0], pair[1]);
      }
      int[] result = new int[numCourses];
      int k = 0;
      for (int i = 0; i < v; ++i) {
         if (adj(i).size() == 0 && !marked[i]) {
            marked[i] = true;
            result[k++] = i;
            continue;
         }
         onstack = new boolean[v];
         order = new ArrayList<Integer>();
         hasCycle = false;
         if (!marked[i]) {
            dfs(i);
            if (hasCycle) {
               result = new int[]{};
               break;
            }else {
               for (int node : order) {
                  result[k++] = node;
               }
            }
         }
      }
      return result;
   }
   @Test
   public void canFinishTest1() {
      Assert.assertArrayEquals(new int[] {0,1}, findOrder(2, new int[][]{}));
      Assert.assertArrayEquals(new int[] {1,0}, findOrder(2, new int[][]{{0,1}}));
      Assert.assertArrayEquals(new int[] {}, findOrder(2, new int[][]{{1,0},{0,1}}));
      Assert.assertArrayEquals(new int[] {0,1,2,3}, findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
   }
   //@Test
   public void canFinishTest2() {
      Assert.assertArrayEquals(new int[] {0,1,2}, findOrder(3, new int[][]{{1,0}}));
      Assert.assertArrayEquals(new int[] {1,2,0,4,3}, findOrder(4, new int[][] {{2,1},{4,0}}));
   }
}
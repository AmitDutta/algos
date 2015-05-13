package leetcodeoj;

import java.util.List;
import java.util.ArrayList;
import org.junit.*;
public class Problem207 {
   private boolean hasCycle = false;
   private List<Integer>[] adj;
   private boolean[] marked;
   private boolean[] onstack;
   private int v;
   public Iterable<Integer> adj (int v) {
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
   }
   public boolean canFinish(int numCourses, int[][] prerequisites) {
      if (numCourses == 0) return true;
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
      for (int i = 0; i < v; ++i) {
         marked = new boolean[v];
         onstack = new boolean[v];
         hasCycle = false;
         dfs(i);
         if (hasCycle) {
            break;
         }
      }
      return !hasCycle;
   }
   @Test
   public void canFinishTest1() {
      Assert.assertTrue(canFinish(2, new int[][]{{1,0}}));
      Assert.assertFalse(canFinish(2, new int[][]{{1,0},{0,1}}));
      Assert.assertFalse(canFinish(3, new int[][]{{1,0},{2,0},{0,1}}));
   }
}

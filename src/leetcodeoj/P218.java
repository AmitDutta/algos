package leetcodeoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.*;

public class P218 {
   public class Edge implements Comparable<Edge>{
      private int x, y;
      private boolean isStart;
      public Edge(int x, int y, boolean start) {
         this.x = x;
         this.y = y;
         isStart = start;
      }
      public int compareTo(Edge that) {
         if (this.x != that.x) {
            return this.x - that.x;
         } else {
            if (this.isStart != that.isStart) {
               // start should be smaller
               return this.isStart ? - 1 : 1;
            } else {
               if (this.isStart == true && that.isStart == true) {
                  return that.y - this.y;
               } else {
                  return this.y - that.y;
               }
            }
         }
      }
      public String toString() {
         return x + ":" + y + ":" + isStart;
      }
   }
   public List<int[]> getSkyline(int[][] buildings) {
      List<int[]> lst = new ArrayList<int[]>();
      List<Edge> edges = new ArrayList<Edge>();
      for (int i = 0; i < buildings.length; ++i) {
         edges.add(new Edge(buildings[i][0], buildings[i][2], true));
         edges.add(new Edge(buildings[i][1], buildings[i][2], false));
      }
      Collections.sort(edges);
      Queue<Integer> queue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
      for (Edge edge : edges) {
         if (queue.isEmpty()) {
            if (edge.isStart) {
               lst.add(new int[]{edge.x, edge.y});
               queue.offer(edge.y);
            }
         } else {
            if (edge.isStart) {
               if (edge.y > queue.peek()) {
                  lst.add(new int[] {edge.x, edge.y});
               }
               queue.offer(edge.y);
            } else {
               queue.remove(edge.y);
               if (queue.isEmpty()) {
                  lst.add(new int[] {edge.x, 0});
               } else if (edge.y > queue.peek()) {
                  lst.add(new int[] {edge.x, queue.peek()});
               }
            }
         }
      }
      return lst;
   }
   @Test
   public void test1() {
      int[][] a = new int[][]{{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
      List<int[]> lst = getSkyline(a);
      for (int[] aa : lst) {
         System.out.println(aa[0] + " " + aa[1]);
      }
      System.out.println("---");
   }
   @Test
   public void test2() {
      int[][] a = new int[][]{{2,9,10}, {9, 15, 10}};
      List<int[]> lst = getSkyline(a);
      for (int[] aa : lst) {
         System.out.println(aa[0] + " " + aa[1]);
      }
      System.out.println("---");
   }
   // this is a critical case, needed to fix my sorting alm..
   @Test
   public void test3() {
      int[][] a = new int[][]{{1,2,1}, {1, 2, 2}, {1,2,3}};
      // we want it to be sorted like this
      // (1,3) (1,2) (1,1), (2,1) (2,2) (2,3)
      List<int[]> lst = getSkyline(a);
      for (int[] aa : lst) {
         System.out.println(aa[0] + " " + aa[1]);
      }
      System.out.println("---");
   }
}

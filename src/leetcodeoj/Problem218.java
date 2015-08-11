package leetcodeoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.*;

public class Problem218 {
   private class Pair implements Comparable<Pair>{
      private int x, height;
      private boolean isStart;
      public Pair(int x, int height, boolean isStart) {
         this.x = x;
         this.height = height;
         this.isStart = isStart;
      }
      @Override
      public int compareTo(Pair o) {
         if (x != o.x) {
            return Integer.compare(x, o.x);
         }
         if (isStart && o.isStart) {
            return Integer.compare(height, o.height);
         }
         if (!isStart && !o.isStart) {
            return Integer.compare(height, o.height);
         }
         return isStart ? -1 : 1;
      }
   }
   public List<int[]> getSkyline(int[][] buildings) {
      List<int[]> result = new ArrayList<int[]>();
      List<Pair> pairs = new ArrayList<Pair>();
      for (int i = 0; i < buildings.length; ++i) {
         int[] item = buildings[i];
         pairs.add(new Pair(item[0], item[2], true));
         pairs.add(new Pair(item[1], item[2], false));
      }
      Collections.sort(pairs);
      PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
      for (Pair pair : pairs) {
         if (pair.isStart) {
            if (maxPq.isEmpty() || maxPq.peek() < pair.height) {
               result.add(new int[] {pair.x, pair.height});
            }
            maxPq.offer(pair.height);
         } else {
            // remove the starting part since this is the end of this line
            maxPq.remove(pair.height);
            if (maxPq.isEmpty()) {
               result.add(new int[] {pair.x, 0});
            } else {
               if (pair.height > maxPq.peek()) {
                  result.add(new int[] {pair.x, maxPq.peek()});
               }
            }
         }
      }
      return result;
   }
   
   // TLE
   public List<int[]> getSkyline1(int[][] buildings) {
      List<int[]> result = new ArrayList<int[]>();
      int[] skyline = new int[100000000];
      int start = 0, end = Integer.MIN_VALUE;
      for (int i = 0; i < buildings.length; ++i) {
         int[] triple = buildings[i];
         if (i == 0) {
            start = triple[0];
         }
         for (int k = triple[0]; k <= triple[1] - 1; ++k) {
            skyline[k] = Math.max(skyline[k], triple[2]);
            end = Math.max(end, triple[1]);
         }
      }
      int cur = skyline[start];
      for (int left = start + 1; left <= end; ++left) {
         if (skyline[left] != cur) {
            int[] pair = new int[2];
            pair[0] = start;
            pair[1] = cur;
            result.add(pair);
            start = left;
         }
         cur = skyline[left];
      }
      int[] pair = new int[2];
      pair[0] = end;
      pair[1] = 0;
      result.add(pair);
      return result;
   }
   @Test
   public void test1() {
      int[][] buildings = new int[][] {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
      List<int[]> result = getSkyline(buildings);
      for (int i = 0; i < result.size(); ++i) {
         System.out.println(result.get(i)[0] + "," + result.get(i)[1] + " ");
      }
      System.out.println();
   }
   @Test
   public void test2() {
      int[][] buildings = new int[][] {{2,20,9}, {5,8,25}};
      List<int[]> result = getSkyline(buildings);
      for (int i = 0; i < result.size(); ++i) {
         System.out.println(result.get(i)[0] + "," + result.get(i)[1] + " ");
      }
      System.out.println();
   }
   @Test
   public void test3() {
      int[][] buildings = new int[][] {{0,2,3}, {2,5,3}};
      List<int[]> result = getSkyline(buildings);
      for (int i = 0; i < result.size(); ++i) {
         System.out.println(result.get(i)[0] + "," + result.get(i)[1] + " ");
      }
      System.out.println();
   }
}

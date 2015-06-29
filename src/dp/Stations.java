package dp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.*;
import org.w3c.dom.ls.LSException;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;

public class Stations {
   public class Distance {
      public int distanceFn(int start, int end) {
         return (int) Math.pow(end - start - 10, 2);
      }
   }
   public void reconstruct_path(int[][] cost, int[] stations, Distance d) {
      List<Integer> result = new ArrayList<Integer>();
      int j = cost[0].length - 1;
      result.add(j);
      while (j > 0) {
         int min = Integer.MAX_VALUE;
         int minIndex = -1;
         for (int i = 0; i < j; ++i) {
            int val = cost[0][i] + d.distanceFn(stations[i], stations[j]);
            if (val < min) {
               min = val;
               minIndex = i;
            }
         }
         j = minIndex;
         result.add(j);
      }
      Collections.reverse(result);
      System.out.print("Optimal Stops:");
      for (int i = 0; i < result.size(); ++i) {
         System.out.print(result.get(i));
         if (i < result.size() -1) {
            System.out.print(", ");
         }
      }
   }
   public int placementCost(int[] stations, Distance dist) {
      int[][] cost = new int[stations.length][stations.length];
      for (int i = 1; i < stations.length; ++i) {
         cost[i - 1][i] = dist.distanceFn(stations[i - 1], stations[i]);
      }
      for (int len = 1; len < stations.length; ++len) {
         for (int i = 0; i < stations.length - len; ++i) {
            int j = i + len;
            // direct cost from i to j
            cost[i][j] = dist.distanceFn(stations[i], stations[j]);
            for (int k = i + 1; k < j; ++k) {
               int val = cost[i][k] + dist.distanceFn(stations[k], stations[j]);
               cost[i][j] = Math.min(cost[i][j], val);
            }
         }
      }
      reconstruct_path(cost, stations, dist);
      return cost[0][stations.length -1];
   }
   public int placeMentCost2(int[] stations, Distance dist) {
      int[] cost = new int[stations.length];
      for (int i = 1; i < stations.length; ++i) {
         // direct cost;
         cost[i] = dist.distanceFn(stations[0], stations[i]);
         for (int k = 1; k < i; ++k) {
            int val = cost[k] + dist.distanceFn(stations[k], stations[i]);
            cost[i] = Math.min(val, cost[i]);
         }
      }
      return cost[stations.length - 1];
   }
   @Test
   public void test1() {
      int[] a = {0,4,7,20,24,30};
      Assert.assertEquals(18, placementCost(a, new Distance()));
   }
   @Test
   public void test2() {
      int[] a = {0,4,7,20,24,30};
      Assert.assertEquals(18, placeMentCost2(a, new Distance()));
   }
}

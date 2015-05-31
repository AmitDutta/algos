package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class Problem218 {
   // TLE
   public List<int[]> getSkyline(int[][] buildings) {
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
   }
}

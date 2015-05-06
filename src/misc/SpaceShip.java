package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

import ds.Pair;

public class SpaceShip {
   private List<Pair<Integer, Integer>> placed = 
         new ArrayList<Pair<Integer, Integer>>();
   private List<Pair<Integer, Integer>> result = 
         new ArrayList<Pair<Integer, Integer>>();
   private int min;
   public void place(int n, char[][] grid, int current) {
      if (current > n) {
         /* We have a valid placement. Just compute distance among
          * placements and keep track of min distance and min placements
          * */
         int distance = 0;
         // We can memoize distance computation. We can have a map whose
         // key is <<pair, pair>, int> which will give us the distance
         // if previously computed
         for (int i = 0; i < placed.size() - 1; ++i) {
            for (int j = i + 1; j < placed.size(); ++j) {
               Pair<Integer, Integer> ship1 = placed.get(i);
               Pair<Integer, Integer> ship2 = placed.get(j);
               distance += Math.abs(ship1.getFirst() - ship2.getFirst()) +
                     Math.abs(ship1.getSecond() - ship2.getSecond());
            }
            if (distance < min) {
               min = distance;
               result = new ArrayList<Pair<Integer, Integer>>(placed);
            }
         }
         return;
      }
      for (int j = 0; j < grid.length; ++j) {
         for (int k = 0; k < grid[0].length; ++k) {
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(j, k);
            if (grid[j][k] != '.' && !placed.contains(pair)) {
               placed.add(pair);
               place(n, grid, current + 1);
               placed.remove(placed.size() - 1);
            }
         }
      }
   }
   public void place(int n, char[][] grid) {
      min = Integer.MAX_VALUE;
      place(n, grid, 1);
      System.out.println("Min distance: " + min);
      for (Pair<Integer, Integer> pair : result) {
         System.out.print(pair + " ");
      }
   }
   
   @Test
   public void placeTest() {
      char[][] array = new char[][]{{' ','.', '.'},
                                    {'.','.', ' '},
                                    {' ','.', ' '}};
      place(3, array);
   }
}

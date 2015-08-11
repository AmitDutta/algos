package lintcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

// This is not accepted yet.. union find problem..need to find total 
// connected component after every addition of connectivity.
public class IslandII {
   private class Point {
      private int x, y;
      public Point (int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   private int[] map;
   private int getId(int row, int col, int rowSize) {
      return row * rowSize + col;
   }
   private boolean inRange(int id, int total) {
      if (id < 0 || id >= total) return false;
      return true;
   }
   // we modify p with q's value
   private void union(int p, int q) {
      int pid = map[p];
      int qid = map[q];
      if (pid == -1) {
         map[p] = qid;
      } else {
      // assign y to x
         for (int i = 0; i < map.length; ++i) {
            if (map[i] == pid) {
               map[i] = qid;
            }
         }
      }
   }
   public List<Integer> numIslands2(int n, int m, Point[] operators) {
      int total = n * m;
      map = new int[n * m];
      List<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < total; ++i) {
         map[i] = - 1;
      }
      if (operators == null) {
         return result;
      }
      for (Point op : operators) {
         int id = getId(op.x, op.y, n);
         int top = getId(op.x - 1, op.y, n);
         int bottom = getId(op.x + 1, op.y, n);
         int left = getId(op.x, op.y - 1, n);
         int right = getId(op.x, op.y + 1, n);
         boolean flag = false;
         if (inRange(top, total) && map[top] != -1) {
            union(id, top);
            flag = true;
         }
         if (inRange(bottom, total) && map[bottom] != -1) {
            union(id, bottom);
            flag = true;
         }
         if (inRange(left, total) && map[left] != -1) {
            union(id, left);
            flag = true;
         }
         if (inRange(right, total) && map[right] != -1) {
            union(id, right);
            flag = true;
         }
         if (!flag) {
            map[id] = id;
         }
         int number = 0;
         for (int i = 0; i < map.length; ++i) {
            if (map[i] == i) {
               number++;
            }
         }
         if (number > 0) {
            result.add(number);
         }
      }
      return result;
   }
  
   @Test
   public void test1() {
      List<Integer> lst = numIslands2(3, 3, null);
      Assert.assertTrue(lst.size() == 0);
   }
   @Test
   public void test2() {
      Point[] p = new Point[] {new Point(0,0), new Point(1,1), new Point(1,0), new Point(0,1)};
      List<Integer> lst = numIslands2(2, 2, p);
      for (Integer i : lst) {
         System.out.println(i);
      }
   }
   @Test
   public void test3() {
      Point[] p = new Point[] {new Point(0,0), new Point(0,1), new Point(2,2), new Point(2,1)};
      List<Integer> lst = numIslands2(3, 3, p);
      for (Integer i : lst) {
         System.out.println(i);
      }
   }
}

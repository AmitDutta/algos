package leetcodeoj;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;

public class Problem149 {
   class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
   }
   public int maxPoints(Point[] points) {
      if (points.length == 0) return 0;
      int max = 0;
      Map<Double, Integer> map = new HashMap<Double, Integer>();
      for (int i = 0; i < points.length - 1; ++i) {
          int dup = 0, cur_max = 0;
          for (int j = i + 1; j < points.length; ++j) {
              if (points[j].x == points[i].x && points[j].y == points[i].y) {
                 dup++;
                 continue;
              }
              double slope = 0.0;
              if ((points[j].x - points[i].x) == 0) slope = Double.MIN_VALUE;
              else if ((points[j].y - points[i].y) == 0) slope = Double.MAX_VALUE;
              else slope = (1.0) * (points[j].y - points[i].y)/(points[j].x - points[i].x);
              if (!map.containsKey(slope)) {
                  map.put(slope, 1);
              } else {
                  map.put(slope, map.get(slope) + 1);
              }
              cur_max = Math.max(cur_max, map.get(slope));
          }
          cur_max += dup;
          max = Math.max(max, cur_max);
          map.clear();
      }
      return max + 1;
   }
   @Test
   public void test1() {
      Point[] p = new Point[] {new Point(0,0),new Point(-1,-1),new Point(2,2)};
      Assert.assertEquals(3, maxPoints(p));
      p = new Point[] {new Point(0,0),new Point(-1,-1),new Point(0,0)};
      Assert.assertEquals(3, maxPoints(p));
   }
   @Test
   public void test2() {
      Point[] p = new Point[] {new Point(2,3),new Point(3,3),new Point(-5,3)};
      Assert.assertEquals(3, maxPoints(p));
      p = new Point[] {new Point(0,0),new Point(1,1),new Point(1,-1)};
      Assert.assertEquals(2, maxPoints(p));
      p = new Point[] {new Point(0,0),new Point(0,0),new Point(0,0),new Point(0,0)};
      Assert.assertEquals(4, maxPoints(p));
   }
}

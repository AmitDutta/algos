package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.*;

// This is an excellent excellent question
// http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
public class Airplanes {
   public class Interval {
      int start, end;
      Interval(int start, int end) {
         this.start = start;
         this.end = end;
      }
   }
   public class Pair {
      private int val;
      private boolean start;
      public Pair(int val, boolean start) {
         this.val = val;
         this.start = start;
      }
   }
   public class PairComparator implements Comparator<Pair> {
      @Override
      public int compare(Pair o1, Pair o2) {
         if (o1.val == o2.val) {
            if (o1.start == false && o2.start == true) {
               // o1 landing, o2 flying, o1 smaller
               return -1;
            } else if (o1.start == true && o2.start == false) {
               // o1 start, o2 land, o2 is smaller
               return 1;
            }
         }
         return o1.val - o2.val;
      }
   }
   public int countOfAirplanes(List<Interval> airplanes) {
      List<Pair> pairs = new ArrayList<Pair>(airplanes.size() * 2);
      for (Interval range : airplanes) {
         pairs.add(new Pair(range.start, true));
         pairs.add(new Pair(range.end, false));
      }
      Collections.sort(pairs, new PairComparator());
      int cur = 0, max = 0;
      for (int i = 0; i < pairs.size(); ++i) {
         Pair pair = pairs.get(i);
         if (pair.start) {
            cur++;
         } else {
            cur--;
         }
         max = Math.max(max, cur);
      }
      return max;
   }
   
   @Test
   public void test1() {
      List<Interval> intervals = Arrays.asList(new Interval(1, 10), new Interval(2, 3), new Interval(5,8), new Interval(4,7));
      Assert.assertEquals(3, countOfAirplanes(intervals));
   }
}

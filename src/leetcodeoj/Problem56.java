package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Problem56 {
   public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      public String toString() {
         return "[" + start + "," + end + "]";
      }
   }
   class IntervalComparator implements Comparator<Interval> {

      @Override
      public int compare(Interval o1, Interval o2) {
         if (o1.start > o2.start) return 1;
         else if (o1.start < o2.start) return -1;
         return 0;
      }
   }
   public List<Interval> merge(List<Interval> intervals) {
      List<Interval> result = new ArrayList<Interval>();
      if (intervals.size() == 0) return result;
      Collections.sort(intervals, new IntervalComparator());
      Interval prev = intervals.get(0);
      for (int i = 1; i < intervals.size(); ++i) {
         Interval cur = intervals.get(i);
         if (cur.start > prev.end) {
            result.add(prev);
            prev = cur;
         }else {
            if (cur.end > prev.end) {
               prev.end = cur.end;
            }
         }
      }
      result.add(prev);
      return result;
   }

   @Test
   public void mergeTest() {
      List<Interval> intervals = Arrays.asList(new Interval(1,100), new Interval(2,6), new Interval(101,500));
      List<Interval> merged = merge(intervals);
      for (Interval interval : merged) {
         System.out.print(interval + " ");
      }
      System.out.println();
   }
}

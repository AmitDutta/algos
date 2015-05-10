package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcodeoj.Problem56.Interval;

import org.junit.Test;

public class Problem57 {
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
         if (o1.start < o2.start) {
            return -1;
         }else if (o1.start > o2.start) {
            return 1;
         }
         return 0;
      }
   }
   private List<Interval> merge(List<Interval> intervals) {
      List<Interval> lst = new ArrayList<Interval>();
      Interval prev = intervals.get(0);
      for (int i = 1; i < intervals.size(); ++i) {
         Interval cur = intervals.get(i);
         if (cur.start <= prev.end) {
            prev.end = Math.max(cur.end, prev.end);
         }else {
            lst.add(prev);
            prev = cur;
         }
      }
      lst.add(prev);
      return lst;
   }
   
   // Add and sort took 401ms
   // Add in appropriate place took 557ms !!
   public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      if (newInterval == null) return intervals;
      if (intervals.size() == 0) {
         intervals.add(newInterval);
      }else {
         boolean added = false;
         for (int i = 0; i < intervals.size(); ++i) {
            if (newInterval.start <= intervals.get(i).start) {
               added = true;
               intervals.add(i, newInterval);
               break;
            }
         }
         if (!added) {
            intervals.add(newInterval);
         }
      }
      return merge(intervals);
   }
   @Test
   public void insertItest() {
      List<Interval> intervals = new ArrayList<Interval>(); //Arrays.asList(new Interval(1,2), new Interval(3,5), new Interval(6,7), new Interval(8,10), new Interval(12,16));
      intervals.add(new Interval(1,5));
      List<Interval> merged = insert(intervals, new Interval(2,7));
      for (Interval interval : merged) {
         System.out.print(interval + " ");
      }
      System.out.println();
   }
}

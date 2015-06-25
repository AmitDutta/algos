package misc;

import java.util.ArrayList;
import java.util.List;

public class RangeRelated {
/**
// * class Range {
//   public int begin;
//   public int end;
//   public Range(int begin, int end) {
//      this.begin = begin;
//      this.end = end;
//   }
//   }
//   The problem: 
//   Intput: 
//   1) list of Ranges that don't overlap (not sorted) 
//   2) newRange that might overlap. 
//   Output: 
//   list of merged Ranges 
//   
//   For example: 
//   Input: [1..5] [9..13] [17..22] 
//   newRange: [4..10] 
//   Output: [1..13] [17..22]
   */
   private class Range {
      public int begin, end;
      public Range(int begin, int end) {
         this.begin = begin;
         this.end = end;
      }
      // The trick is we do not need to return sorted order of ranges..
      // just keep track of overlaping ranges with newRange, and add that to result
      public List<Range> merge(List<Range> ranges, Range newRange) {
         List<Range> result = new ArrayList<Range>();
         int a = newRange.begin;
         int b = newRange.end;
         for (Range range : ranges) {
            if (range.end < a || range.begin > b) {
               // no overlap
               result.add(range);
            } else {
               a = Math.min(a, range.begin);
               b = Math.max(b, range.end);
            }
         }
         result.add(new Range(a, b));
         return result;
      }
   }
}

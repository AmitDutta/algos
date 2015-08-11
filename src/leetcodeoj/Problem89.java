package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem89 {
   int[] items;
   public void format(int start, int end, int half) {
      if (end -  start == 2) {
         if (half == 2) {
            int tmp = items[end - 1];
            items[end - 1] = items[start];
            items[start] = tmp;
         }
         return;
      }
      int mid = (start + end) / 2;
      if (half == 2) {
         // swap mid to end
         int i = start, j = mid;
         while (i < mid) {
            int tmp = items[j];
            items[j] = items[i];
            items[i] = tmp;
            i++;
            j++;
         }
      }
      format(start, mid, 1);
      format(mid, end, 2);
   }
   public List<Integer> grayCode1(int n) {
      if (n == 0) return Arrays.asList(0);
      int last = (int) Math.pow(2, n);
      items = new int[last];
      for (int i = 0; i < last; ++i) {
         items[i] = i;
      }
      format(0, last, 1);
      List<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < items.length; ++i) {
         result.add(items[i]);
      }
      return result;
   }
   // Better way
   private List<Integer> result;
   private void generate(int lo, int hi, int k) {
       if (lo == hi) {
           result.add(lo);
           return;
       }
       int mid = lo + (hi - lo)/2;
       if (k == 1) {
           generate(lo, mid, 1);
           generate(mid + 1, hi, 2);
       } else {
           generate(mid + 1, hi, 1);
           generate(lo, mid, 2);
       }
   }
   public List<Integer> grayCode(int n) {
      result = new ArrayList<Integer>();
      generate(0, (int) Math.pow(2,n) - 1, 1);
      return result;
   }
   @Test
   public void test1() {
      List<Integer> result = grayCode(2);
      for (int i : result) {
         System.out.println(i);
      }
   }
}

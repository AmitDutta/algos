package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class Problem18 {
   public int binarySearch(int[] num, int start, int end, int item) {
      int mid = -1;
      while (true) {
         if (start > end) {
            break;
         }
         mid = start + (end - start) / 2;
         if (num[mid] == item) {
            return mid;
         }else if (num[mid] > item) {
             end--;
         }else {
            start++;
         }
      }
      return -1;
   }

   // O(n^3) //Accepted :)
   public List<List<Integer>> fourSum(int[] num, int target) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      Set<List<Integer>> result = new HashSet<List<Integer>>();
      Arrays.sort(num);
      for (int i = 0; i < num.length - 3; ++i) {
         for (int j = i + 1; j < num.length - 2; ++j) {
            int start = j + 1;
            int end = num.length - 1;
            while (start < end) {
               int tmp = num[i] + num[j] + num[start] + num[end];
               if (tmp == target)  {
                  List<Integer> group = new ArrayList<Integer>();
                  group.add(num[i]);
                  group.add(num[j]);
                  group.add(num[start]);
                  group.add(num[end]);
                  result.add(group);
                  start++;
                  end--;
               }else if (tmp > target) {
                  end--;
               }else {
               start++;
            }
         }
      }
   }
   list.addAll(result);
   return list;
}
   
   // O(n^3logn) //TLE
   public List<List<Integer>> fourSum1(int[] num, int target) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      Set<List<Integer>> result = new HashSet<List<Integer>>();
      Arrays.sort(num);
      for (int i = 0; i < num.length - 3; ++i) {
         for (int j = i + 1; j < num.length - 2; ++j) {
            for (int k = j + 1; k < num.length - 1; ++k) {
               int required = target - (num[i] + num[j] + num[k]);
               int start = k + 1;
               int end = num.length - 1;
               int found = binarySearch(num, start, end, required);
               if (found != - 1) {
                  List<Integer> group = new ArrayList<Integer>();
                  group.add(num[i]);
                  group.add(num[j]);
                  group.add(num[k]);
                  group.add(num[found]);
                  result.add(group);
               }
            }
         }
      }
      list.addAll(result);
      return list;
   }
   
   @Test
   public void binarySerachTest() {
       Problem15 p15 = new Problem15();
       Assert.assertEquals(2, p15.binarySerach(new int[] {1,2,3,10}, 0, 3, 3));
       Assert.assertEquals(2, p15.binarySerach(
               new int[] {1,2,3,10,20}, 0, 4, 3));
       Assert.assertEquals(-1, 
               p15.binarySerach(new int[] {1,2,3,10}, 0, 3, -3));
       Assert.assertEquals(-1, 
               p15.binarySerach(new int[] {}, 0, 0, -3));
   }
   
   @Test
   public void fourSumTest() {
      Problem18 p18 = new Problem18();
      List<List<Integer>> actual = p18.fourSum(
            new int[] {1, 0, -1, 0, -2, 2}, 0);
      List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1,0,0,1),
            Arrays.asList(-2,-1,1,2), Arrays.asList(-2,0,0,2));
      Assert.assertTrue(expected.size() == actual.size() &&
            expected.containsAll(actual));
      actual = p18.fourSum(
            new int[] {0, 0, 0, 0, 0, 0}, 0);
      expected = Arrays.asList(Arrays.asList(0,0,0,0));
      Assert.assertTrue(expected.size() == actual.size() &&
            expected.containsAll(actual));
   }
}

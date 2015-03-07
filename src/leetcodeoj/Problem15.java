package leetcodeoj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Problem15 {
    
    public int binarySerach(int[] array, int start, int end, int item) {
        if (start > end || array.length == 0) return -1;
        int mid = start + (end - start)/2;
        return array[mid] == item ? mid : array[mid] > item ?
                binarySerach(array, start, mid - 1, item)
                : binarySerach(array, mid + 1, end, item);
    }
    
    // O(n^2logn)
    public List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int prev1 = Integer.MIN_VALUE;
        int prev2 = Integer.MIN_VALUE;
        for (int i = 0; i < num.length - 2; ++i) {
            if (prev1 == num[i]) {
                continue;
            }
            prev1 = num[i];
            for (int j = i + 1; j < num.length - 1; ++j) {
                if (prev2 == num[j]) {
                    continue;
                }
                prev2 = num[j];
                int required = (-1) * (num[i] + num[j]);
                int index = binarySerach(num, j + 1, num.length - 1, required);
                if (index != -1) {
                    List<Integer> triplets = new ArrayList<Integer>();
                    triplets.add(num[i]);
                    triplets.add(num[j]);
                    triplets.add(num[index]);
                    result.add(triplets);
                }
            }
        }
        return result;
    }
    
    // A better solution, O(n^2)
    List<List<Integer>> threeSum(int[] num) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        int start, end, current;
        current = 0;
        for (int i = 0; i < num.length - 2; ++i) {
            start = i + 1;
            end = num.length - 1;
            while (start < end) {
                current = num[start] + num[end] + num[i];
                if (current == 0) {
                    List<Integer> triplets = new ArrayList<Integer>();
                    triplets.add(num[i]);
                    triplets.add(num[start]);
                    triplets.add(num[end]);
                    set.add(triplets);
                    start++;
                    end--;
                }else {
                    if (current > 0) {
                        end --;
                    }else {
                        start++;
                    }
                }
            }
        }
        result.addAll(set);
        return result;
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
    public void threeSumTest() {
       Problem15 p15 = new Problem15();
       List<List<Integer>> actual = p15.threeSum(
                new int[] {-1, 0, 1, 2, -1, -4});

       List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));
       Assert.assertTrue(expected.size() == actual.size() &&
                expected.containsAll(actual));
        
       actual = p15.threeSum(new int[] {0, 0, 0, 0});
       expected = Arrays.asList(Arrays.asList(0, 0, 0));
       /*for (int i = 0; i < actual.size(); i++) {
            System.out.println(actual.get(0).get(0) + ", " + actual.get(0).get(1) + ", " + actual.get(0).get(2));
       }*/
       Assert.assertTrue(expected.size() == actual.size() &&
                actual.containsAll(expected));
       
       actual = p15.threeSum(
               new int[] {1,2,-2,-1});
       expected = Arrays.asList();
       Assert.assertTrue(expected.size() == actual.size() &&
               actual.containsAll(expected));
    }
}

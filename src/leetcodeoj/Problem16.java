package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

// http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
public class Problem16 {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int start, end, current, sum;
        int diff = Integer.MAX_VALUE;
        sum = 0;
        current = 0;
        for (int i = 0; i < num.length - 2; ++i) {
            start = i + 1;
            end = num.length - 1;
            while (start < end) {
                current = num[start] + num[end] + num[i];
                int tmp = Math.abs((current -target));
                if (tmp < diff) {
                    diff = tmp;
                    sum = current;
                }else {
                    if (current > target) {
                        end --;
                    }else {
                        start++;
                    }
                }
            }
        }
        return sum;
    }
    
    @Test
    public void threeSumClosestTest(){
        Problem16 p16 = new Problem16();
        Assert.assertEquals(2, p16.threeSumClosest(
                new int[] {-1,2,1,-4 }, 1));
    }
}

package leetcodeoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Problem66 {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<Integer>();
        if (digits.length == 0) return new int[] {};
        int hand = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            int numToAdd = i == digits.length - 1 ? 1 + hand : hand;
            int tmp = digits[i] + numToAdd;
            if (tmp >= 10) {
                hand = 1;
                result.add(tmp - 10);
            }else {
                hand = 0;
                result.add(tmp);
            }
        }
        if (hand > 0) {
            result.add(hand);
        }
        int k = 0;
        int[] out = new int[result.size()];
        for (int i = result.size() - 1; i >= 0; --i) {
            out[k++] = result.get(i);
        }
        for (int i = 0; i < out.length; ++i) System.out.print(out[i] + " ");

        return out;
    }
    
    @Test
    public void plusOneTest() {
        Problem66 p66 = new Problem66();
        Assert.assertArrayEquals(new int[] {1,0,0},
                                 p66.plusOne(new int[] {9,9}));
        Assert.assertArrayEquals(new int[] {9,1,0},
                p66.plusOne(new int[] {9,0,9}));
        Assert.assertArrayEquals(new int[] {},
                p66.plusOne(new int[] {}));
    }
    
}

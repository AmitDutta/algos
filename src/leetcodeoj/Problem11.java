package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem11 {
    // O(n^2) TLE
    public int maxArea1(int[] height) {
        int area = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = 0; j < height.length && j != i; ++j) {
                int dx = Math.abs(i - j);
                int dy = Math.min(height[i], height[j]);
                temp = dx * dy;
                if (temp > area) {
                    area = temp;
                }
            }
        }
        return area;
    }
    
    public int maxArea(int[] height) {
        int area = Integer.MIN_VALUE;
        int low = 0, high = height.length - 1;
        int temp = 0;
        while (low < high) {
            temp = (high - low) * Math.min(height[low], height[high]);
            if (temp > area) {
                area = temp;
            }
            if (height[high] > height[low]) {
                ++low;
            }else {
                --high;
            }
        }
        return area;
    }
    
    @Test
    public void maxAreaTest() {
        Problem11 p11 = new Problem11();
        Assert.assertEquals(20, p11.maxArea(new int[] {5, 10, 15, 20}));
        Assert.assertEquals(1, p11.maxArea(new int[] {1,1}));
    }
}

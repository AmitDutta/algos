package leetcodeoj;
import org.junit.Test;
import  org.junit.Assert;

public class Problem7 {
    public int reverse(int x) {
        int orig = x;
        long result = 0;
        int p = 1;
        if (x < 0) {
            x = (-1) * x;
        }
        while (x > 0) {
            result = p * result + (x % 10);
            if (p == 1) p *= 10;
            x /= 10;
        }
        
        if (result > Integer.MAX_VALUE){
            result = 0;
        }
        
        return (int) (orig < 0 ? (-1) * result : result);
    }
    
    @Test
    public void reverseTest() {
        Problem7 p7 = new Problem7();
        Assert.assertEquals(321, p7.reverse(123));
        Assert.assertEquals(-321, p7.reverse(-123));
        Assert.assertEquals(0001, p7.reverse(1000));
        Assert.assertEquals(0, p7.reverse(1000000003));
        Assert.assertEquals(0, p7.reverse(1534236469));
        
    }
}

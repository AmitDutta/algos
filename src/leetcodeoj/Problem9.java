package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem9 {
    
    public int getTen(int x) {
        int p = 1;
        while (x >= 10) {
            x /= 10;
            p *= 10;
        }
        return p;
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        boolean isPalindrome = true;
        int pFront = getTen(x);
        int xFront = x;
        int pEnd = 10;
        int xEnd = x;
        while (true) {
            if (xFront < 10 && xEnd < 10) {
                break;
            }
            
            int frontDigit = xFront / pFront;
            int endDigit = xEnd % pEnd;
            
            if (frontDigit != endDigit) {
                isPalindrome = false;
                break;
            }
            
            xFront %= pFront;
            xEnd /= pEnd;
            
            pFront /= 10;
        }
        return isPalindrome;
    }
    
    @Test
    public void isPalindromeTest() {
        Problem9 p9 = new Problem9();
        
        Assert.assertFalse(p9.isPalindrome(12));
        Assert.assertFalse(p9.isPalindrome(123));
        Assert.assertFalse(p9.isPalindrome(1231));
        Assert.assertFalse(p9.isPalindrome(Integer.MAX_VALUE));
        Assert.assertFalse(p9.isPalindrome(1784214871));
        Assert.assertFalse(p9.isPalindrome(Integer.MIN_VALUE));
        Assert.assertFalse(p9.isPalindrome(1091));
        
        Assert.assertTrue(p9.isPalindrome(0));
        Assert.assertTrue(p9.isPalindrome(9));
        Assert.assertTrue(p9.isPalindrome(121));
        Assert.assertTrue(p9.isPalindrome(1001));
        Assert.assertTrue(p9.isPalindrome(10001));
        Assert.assertTrue(p9.isPalindrome(10501));
        Assert.assertTrue(p9.isPalindrome(3223));
        Assert.assertTrue(p9.isPalindrome(1784224871));
    }
}

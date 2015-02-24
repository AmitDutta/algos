package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem10 {
    
    /* This problem is tricky. See dynamic solution
    http://wizardrichard.blogspot.com/2013/02/leetcode-regular-expression-matching.html
    http://oj.leetcode.com/problems/regular-expression-matching */
    public boolean match(char p, char s) {
        return (p == s) || (p == '.');
    }
    
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) {
            if (s.length() != 1) return false;
            return match(p.charAt(0), s.charAt(0));
        }
        if (p.charAt(1) != '*') {
            if (s.length() == 0) return false;
            return match(p.charAt(0), s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
        
        int i = 0;
        while (i < s.length() && match(p.charAt(0), s.charAt(i))) {
            /* Why this call is required? Consider string = aaa, pattern = a*a
             * Here, only first two a should match with a*, and the last one
             * should match with last a in pattern. If we do not do the 
             * following call, a* will match will all the a's, and return 
             * false. Here, recursive calls and result will be
             * (aaa, a) = false, (aa, a) = false, (a, a) = true*/
            if (isMatch(s.substring(i), p.substring(2))) {
                return true;
            }
            ++i;
        }
        return isMatch(s.substring(i), p.substring(2));
    }

    @Test
    public void isMatchTest() {
        Problem10 p10 = new Problem10();
        
        Assert.assertFalse(p10.isMatch("", ".."));
        Assert.assertFalse(p10.isMatch("a", "..a"));
        
        Assert.assertFalse(p10.isMatch("a", ".*..a*"));
        
        Assert.assertTrue(p10.isMatch("aaa", "a*a"));
        
        Assert.assertTrue(p10.isMatch("aa", "a*"));
        Assert.assertTrue(p10.isMatch("aa", ".*"));
        Assert.assertTrue(p10.isMatch("ab", ".*"));
        Assert.assertTrue(p10.isMatch("aab", "c*a*b"));
        
        Assert.assertFalse(p10.isMatch("aa","a"));
        Assert.assertFalse(p10.isMatch("aaa","aa"));
        Assert.assertFalse(p10.isMatch("aaa","aa"));
    }
}

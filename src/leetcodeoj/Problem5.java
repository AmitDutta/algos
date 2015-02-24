package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem5 {
    public String longestPalindrome(String s) {
        if (s == "") return s;
        int i, j, length, startIndex, endIndex;
        startIndex = endIndex = 0;
        boolean cost[][] = new boolean[s.length()][s.length()];
        for (i = 0; i < s.length(); ++i) {
            cost[i][i] = true;
            startIndex = i;
            endIndex = i + 1;
        }
        for (i = 0; i < s.length() - 1; ++i) {
            if ( s.charAt(i) == s.charAt(i + 1)) {
                cost[i][i + 1] = true;
                startIndex = i;
                endIndex = i + 2;
            }
        }
        
        // Why length <= ? We need to try all length. Later for j, we are doing
        // - 1 to get proper index
        for (length = 3; length <= s.length(); ++length) {
            for (i = 0;  i < s.length(); ++i) {
                j = i + length - 1;
                if (j < s.length()) {
                    if (s.charAt(i) == s.charAt(j) && cost[i + 1][j - 1]) {
                        cost[i][j] = true;
                        startIndex = i;
                        endIndex =  i + length;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex);
    }
    
    @Test
    public void longestPalindromeTest() {
        Assert.assertEquals("abba", longestPalindrome("abba"));
        Assert.assertEquals("aba", longestPalindrome("caba"));
        Assert.assertEquals("b", longestPalindrome("cdab"));
        Assert.assertEquals("geeksskeeg", longestPalindrome("forgeeksskeegfor"));
    }
}

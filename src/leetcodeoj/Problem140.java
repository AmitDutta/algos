package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

// Find all path, dfs is a valid try

public class Problem140 {
    private List<String> lst = new ArrayList<String>();
    private List<String> result = new ArrayList<String>();

    // TLE
    private void dfs(String str, Set<String> dict, int start, int len) {
        if (len == str.length()) {
            StringBuffer buffer = new StringBuffer();
            int i = 0;
            for (i = 0; i < lst.size() - 1; ++i) {
                buffer.append(lst.get(i) + " ");
            }
            buffer.append(lst.get(i));
            result.add(buffer.toString());
            return;
        }
        for (int i = start; i < str.length(); ++i) {
            String sub = str.substring(start, i + 1);
            if (dict.contains(sub)) {
                lst.add(sub);
                len += sub.length();
                dfs(str, dict, i + 1, len);
                len -= sub.length();
                lst.remove(lst.size() - 1);
            }
        } 
    }
    
    // dfs alone was tle, but after this check, not tle..basically if there
    // is possible solution, we should not proceed for dfs. This solution
    // just checks that
    public List<String> wordBreak(String s, Set<String> dict) {
        boolean cost[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                String subStr = s.substring(i, j + 1);
                if (dict.contains(subStr)) {
                    cost[i][j] = true;
                }
            }
        }
        
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int k = i; k < j; ++k) {
                boolean val = cost[i][k] && cost[k + 1][j];
                if (val) {
                    cost[i][j] = val;
                }
            }
        }
        if (!cost[0][s.length() - 1]) return result;
        dfs(s, dict, 0, 0);
        return result;
    }
    
    @Test
    public void Problem140Test1() {
        Problem140 p140 = new Problem140();
        Set<String> dict = new HashSet<>(Arrays.asList("am"
                , "it", "amit", "a", "m", "i", "t" ));
        List<String> result = p140.wordBreak("amit", dict);
        Assert.assertEquals(result,
                Arrays.asList("a m i t", "a m it", "am i t", "am it", "amit"));
    }
    
    @Test
    public void Problem140Test2() {
        Problem140 p140 = new Problem140();
        Set<String> dict = new HashSet<>(Arrays.asList("cat", "cats", "and",
                "sand", "dog" ));
        List<String> result = p140.wordBreak("catsanddog", dict);
        List<String> actual = Arrays.asList("cats and dog", "cat sand dog");
        Assert.assertTrue(result.containsAll(actual) && actual.containsAll(result));
    }
    
    @Test
    public void Problem140Test3() {
        Problem140 p140 = new Problem140();
        Set<String> dict = new HashSet<>(Arrays.asList("ca", "cts", "and",
                "sand", "dog" ));
        List<String> result = p140.wordBreak("catsanddog", dict);
        List<String> actual = Arrays.asList();
        Assert.assertTrue(result.containsAll(actual) && actual.containsAll(result));
    }
}

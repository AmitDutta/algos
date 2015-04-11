package leetcodeoj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.Assert;

public class Problem139 {
    // bruteforce and TLE + stackoverflow
    public boolean wordBreak1(String s, Set<String> dict) {
        if (dict.contains(s)) {
            return true;
        }else if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            boolean result = wordBreak1(left, dict) && wordBreak1(right, dict);
            if (result) {
                return true;
            }
        }
        return false;
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        boolean cost[][] = new boolean[s.length()][s.length()];
        //Integer path[][]= new Integer[s.length()][s.length()];
        Integer path[]= new Integer[s.length()]; // We only need first row
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                String subStr = s.substring(i, j + 1);
                if (dict.contains(subStr)) {
                    cost[i][j] = true;
                }
            }
        }
        for(int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < s.length(); j++) {
                for (int k = i; k < j; ++k) {
                    boolean val = cost[i][k] && cost[k + 1][j];
                    if (val) {
                        cost[i][j] = val;
                        if (i == 0) {
                            path[j] = k;
                        }
                    }
                }
            }
        }

        // Helper.print2DArray(path);
        // printResult(cost, path , s);

        return cost[0][s.length() - 1];
    }
    
    void printResult(boolean cost[][], Integer path[], String s) {
        int prev = 0;
        int i = 0;
        if (cost[0][s.length() - 1]) {
            for (i = 0; i < s.length(); ++i) {
                if (path[i] != null) {
                    System.out.println(s.substring(prev, path[i] + 1));
                    prev = path[i] + 1;
                }
            }
            System.out.println(s.substring(prev));
        }
    }


    @Test
    public void Problem139Test() {
        Problem139 p139 = new Problem139();
        Set<String> dict = new HashSet<>(Arrays.asList("a", "m", "i", "t"));
        /*Assert.assertTrue(p139.wordBreak("amit", dict));
        dict = new HashSet<>(Arrays.asList("t", "lee", "code"));
        Assert.assertTrue(p139.wordBreak("leetcode", dict));*/
        
        dict = new HashSet<>(Arrays.asList("t", "co", "d", "e", "et", "le"));
        Assert.assertTrue(p139.wordBreak("leetcode", dict));
        
        dict = new HashSet<>(Arrays.asList("leet", "cod1"));
        Assert.assertFalse(p139.wordBreak("leetcode", dict));
        dict = new HashSet<>(Arrays.asList("l", "e", "et", "c", "o1", "e"));
        Assert.assertFalse(p139.wordBreak("leetcode", dict));
        dict = new HashSet<>(Arrays.asList("l", "e", "", "c", "o1", "e"));
        Assert.assertFalse(p139.wordBreak("leetcode", dict));
    }
}

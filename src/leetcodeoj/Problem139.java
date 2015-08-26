package leetcodeoj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    
    // Runtime: O(n^2)
    
    public boolean wordBreak(String s, Set<String> dict) {
        Boolean cost[][] = new Boolean[s.length()][s.length()];
        for (int i = 0; i < cost.length; ++i) {
            for (int j = 0; j < cost.length; ++j) {
                cost[i][j] = false;
            }
        }
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
        // Basically we only care if a[0..len] can be partitoned..therefore,
        // only calculation for first row will suffice..replace str.length with
        // 1 in following code and will work
        //for(int i = 0; i < 1; ++i) {
            int i = 0;
            for (int j = 0; j < s.length(); j++) {
                for (int k = i; k < j; ++k) {
                    boolean val = cost[i][k] && cost[k + 1][j];
                    if (val) {
                        cost[i][j] = val;
                        path[j] = k;
                    }
                }
            }
        //}

         //Helper.print1DArray(path);
         //Helper.print2DArray(cost);
        // printResult(cost, path , s);

        return cost[0][s.length() - 1];
    }
    
    // This is O(n^2) as well
    private Map<String, Boolean> map;
    private boolean canBreak2(String str) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        for (int i = 0; i < str.length(); ++i) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);
            if (map.containsKey(left) && map.get(left) && canBreak2(right)) {
                return true;
            }
        }
        map.put(str, false);
        return false;
    }
    public boolean wordBreak2(String s, Set<String> wordDict) {
        map = new HashMap<String, Boolean>();
        for (String str : wordDict) {
            map.put(str, true);
        }
        return canBreak2(s);
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
        Set<String> dict = new HashSet<>(Arrays.asList("am", "it"));
        Assert.assertTrue(p139.wordBreak("amit", dict));

        dict = new HashSet<>(Arrays.asList("t"));
        Assert.assertFalse(p139.wordBreak("a", dict));
        
        dict = new HashSet<>(Arrays.asList("t", "lee", "code"));
        Assert.assertTrue(p139.wordBreak("leetcode", dict));
        
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

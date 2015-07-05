package misc;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;

public class SlidingWindow {
 /*
  * Question: Given a sequence of positive integers A and an integer T,
  * return whether there is a continuous sequence of A that sums up to exactly T 
  * Example 
  * [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20 
  * [1, 3, 5, 23, 2], 8. Return True because 3 + 5 = 8 
  * [1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
  */
   
   public boolean findSum2(int[] a, int T) {
      int sum = 0, start = 0;
      for (int i = 0; i < a.length; ++i) {
         sum += a[i];
         while (sum - a[start] >= T) {
            sum -= a[start++];
         }
         if (sum == T) return true;
      }
      return false;
   }
   
   public boolean findSum(int[] a, int T) {
      int j = 0, sum = 0;
      for (int i = 0; i < a.length; ++i) {
         while (j < a.length && sum < T) {
            sum += a[j];
            ++j;
         }
         if (sum == T) {
            return true;
         }
         sum -= a[i];
      }
      return false;
   }
   @Test
   public void findSumTest1() {
      Assert.assertTrue(findSum2(new int[] {23,5,4,7,2,11}, 20));
      Assert.assertTrue(findSum2(new int[] {1, 3, 5, 23, 2}, 8));
      Assert.assertFalse(findSum2(new int[] {1, 3, 5, 23, 2}, 7));
   }
   
   public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int maxLen = 0, start = 0;
      for (int i = 0; i < s.length(); ++i) {
          if (map.containsKey(s.charAt(i))) {
              maxLen = Math.max(maxLen, i - start);
              start = Math.max(start, map.get(s.charAt(i)) + 1);
          }
          map.put(s.charAt(i), i);
      }
      maxLen = Math.max(maxLen, s.length() - start);
      return maxLen;
   }
   @Test
   public void test1() {
      Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
      Assert.assertEquals(3, lengthOfLongestSubstring("abc"));
      Assert.assertEquals(1, lengthOfLongestSubstring("bbb"));
      Assert.assertEquals(5, lengthOfLongestSubstring("abcdbcade"));
      Assert.assertEquals(0, lengthOfLongestSubstring(""));
   }
   
   // leetcode prob 76..best sliding window example
   public String minWindow(String s, String t) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); ++i) {
         char ch = t.charAt(i);
         if (map.containsKey(ch)) {
            map.put(t.charAt(i), map.get(ch) + 1);
         } else {
            map.put(ch, 1);
         }
      }
      int len = 0, start = 0;
      String result = "";
      Map<Character, Integer> tmp = new HashMap<Character, Integer>();
      for (int i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (!map.containsKey(ch)) {
            continue;
         }
         if (tmp.containsKey(ch)) {
            tmp.put(ch, tmp.get(ch) + 1);
         } else {
            tmp.put(ch, 1);
         }
         if (tmp.get(ch) <= map.get(ch)) {
            len++;
         }
         if (len >= t.length()) {
            while (start <= i) {
               char ch2 = s.charAt(start);
               if (!map.containsKey(ch2)) {
                  start++;
                  continue;
               }
               if (tmp.get(ch2) > map.get(ch2)) {
                  tmp.put(ch2, tmp.get(ch2) - 1);
                  start++;
               } else {
                  break;
               }
            }
            if (result == "" || result.length() > i - start) {
               result = s.substring(start, i + 1);
            }
         }
      }
      return result;
   }
   
   @Test
   public void test2() {
      Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
      Assert.assertEquals("cba", minWindow("abbcbcba", "abc"));
      Assert.assertEquals("aa", minWindow("aa", "aa"));
      Assert.assertEquals("ba", minWindow("bba", "ab"));
   }
}

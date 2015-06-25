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
      Assert.assertTrue(findSum(new int[] {23,5,4,7,2,11}, 20));
      Assert.assertTrue(findSum(new int[] {1, 3, 5, 23, 2}, 8));
      Assert.assertFalse(findSum(new int[] {1, 3, 5, 23, 2}, 7));
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
}

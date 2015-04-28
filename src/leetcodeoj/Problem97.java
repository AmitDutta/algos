package leetcodeoj;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;

public class Problem97 {

   // without using the map, got tle..cache s1, s2 and s2, s1 pair which
   // does not result valid result.
   // http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-combine-two-strings/
   private Map<String, String> cache = new HashMap<String, String>();

   public boolean isInterleave(String s1, String s2, String s3) {
      if (cache.containsKey(s1) && cache.get(s1).equals(s2)) {
         return false;
      }
      if (cache.containsKey(s2) && cache.get(s2).equals(s1)) {
         return false;
      }

      if (s3.length() != (s1.length() + s2.length())){
         return false;
      }

      if (s1.equals("")) return s2.equals(s3);

      if (s2.equals("")) return s1.equals(s3);

      char ch1 = s1.charAt(0);
      char ch2 = s2.charAt(0);
      char ch3 = s3.charAt(0);
      if (ch1 != ch3 && ch2 != ch3) {
         return false;
      }
      if (ch1 == ch3 && isInterleave(s1.substring(1), s2, s3.substring(1))) {
         return true;
      }
      if (ch2 == ch3 && isInterleave(s1, s2.substring(1), s3.substring(1))) {
         return true;
      }

      cache.put(s1, s2);
      cache.put(s2, s1);

      return false;
   }

   @Test
   public void isInterleaveTest1() {
      Assert.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
   }

   @Test
   public void isInterleaveTest2() {
      Assert.assertFalse(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
   }
}

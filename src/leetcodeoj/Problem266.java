package leetcodeoj;

import java.util.HashSet;
import java.util.Set;
import org.junit.*;

public class Problem266 {
   // palindrome permutation
   public boolean canPermutePalindrome(String s) {
      Set<Character> set = new HashSet<Character>();
      for (int i = 0; i < s.length(); ++i) {
         if (set.contains(s.charAt(i))) {
            set.remove(s.charAt(i));
         } else {
            set.add(s.charAt(i));
         }
      }
      return set.size() <= 1;
   }
   @Test
   public void test1() {
      Assert.assertTrue(canPermutePalindrome("civic"));
      Assert.assertTrue(canPermutePalindrome("ivicc"));
      Assert.assertFalse(canPermutePalindrome("aabedd"));
   }
}

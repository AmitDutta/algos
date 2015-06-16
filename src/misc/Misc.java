package misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.*;

public class Misc {
   public static boolean isPangram(String s) {
      Set<Character> set = new HashSet<Character>();
      s = s.toLowerCase();
      for (int  i = 0; i < s.length(); ++i) {
         if (s.charAt(i) != ' ') {
            set.add(s.charAt(i));
         }
      }
      return set.size() == 26 ? true : false;
   }
   public static int numDigits(int num) {
      int digits = 0;
      for (long i  = 1; num / i > 0; i *= 10){
         digits++;
      }
      return  num == 0 ? 1 : digits;
   }
   public static String removeAllSpaces(char[] chars) {
      int i = -1;
      for (int j = 0; j < chars.length; ++j) {
         if (chars[j] != ' ') {
            ++i;
            chars[i] = chars[j];
         }
         
      }
      int len = i + 1;
      return new String(chars, 0, len);  
   }
   /* This is difficult, even though it may sound simple
    * http://stackoverflow.com/questions/5561138/interview-question-trim-multiple-consecutive-spaces-from-a-string
    * Just loop over all the characters with j, and whenever you see a letter, 
    * copy it to index i, then increment i. If you see a space that was not
    * preceded by a space, also copy the space.
    * */
   public static String removeAllSpacesButOne(char[] chars) {
      int i = -1;
      for (int j = 0; j < chars.length; ++j) {
         if (chars[j] != ' ') {
            ++i;
            chars[i] = chars[j];
         } else {
            if (j > 0 && chars[j - 1] != ' ') {
               i++;
               chars[i] = chars[j];
            }
         }
      }
      return new String(chars, 0, i + 1);
   }
   /*String: "hello", order: lh, outout: group  char in order
    * together and keep the other chars intact. Here: llheo*/
   public static void orderSort(char[] nums, char[] order) {
      // Add all the order items in a map
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      for (char ch : order) {
         map.put(ch, 0);
      }
      // count frequencies of each order items, and at same time, group all
      // other items which are not in order at the end of string. Just fix
      // the tail first.
      /*int i = -1;
      for (int j = 0; j < nums.length; ++j) {
         if (!map.containsKey(nums[j])) {
            nums[++i] = nums[j];
         }
         if (map.containsKey(nums[j])) {
            map.put(nums[j], map.get(nums[j]) + 1);
         }
      }*/
      int i = nums.length;
      for (int j = nums.length - 1; j >= 0; --j) {
         if (!map.containsKey(nums[j])) {
            nums[--i] = nums[j];
         }
         if (map.containsKey(nums[j])) {
            map.put(nums[j], map.get(nums[j]) + 1);
         }
      }
      // now all the non order items are in 0 to i
      // since order items will come first, lets move these to end
      /*for (int j = i, k = nums.length - 1; j >= 0; --j, --k) {
         nums[k] = nums[j];
      }*/
      int start = 0;
      for (char ch : order) {
         int cnt = map.get(ch);
         int end = start + cnt;
         for (; start < end; ++start) {
            nums[start] = ch;
         }
      }
   }
   @Test
   public void numDigitsTest() {
      Assert.assertEquals(1, numDigits(0));
      Assert.assertEquals(1, numDigits(5));
      Assert.assertEquals(4, numDigits(1599));
      Assert.assertEquals(10, numDigits(Integer.MAX_VALUE));
   }
   @Test
   public void test1() {
      Assert.assertEquals("", removeAllSpaces("   ".toCharArray()));
      Assert.assertEquals(
            "abcdefgh",
            removeAllSpaces("   a  b  cde f g h    ".toCharArray()));
      Assert.assertEquals("abdc", removeAllSpaces("abdc".toCharArray()));
   }
   @Test
   public void test2() {
      Assert.assertEquals("a bc d", removeAllSpacesButOne("a  bc   d".toCharArray()));
      Assert.assertEquals("a b c d", removeAllSpacesButOne("a b c   d".toCharArray()));
      
      // Corner cases..may end up with a space.
      
      Assert.assertEquals("a b c d ", removeAllSpacesButOne(" a b c   d   ".toCharArray()));
      Assert.assertEquals("a b c d ", removeAllSpacesButOne("  a b c   d   ".toCharArray()));
   }
   @Test
   public void test3() {
      char[] items = {'h','e','h','l','l','o', 'q'};
      char[] key = {'l', 'h'};
      char[] expecteds = {'l', 'l', 'h', 'h', 'e', 'o', 'q'};
      orderSort(items, key);
      Assert.assertArrayEquals(expecteds, items);
   }
   @Test
   public void test4() {
      char[] items = {'f','e','h','g','a','o', 'o'};
      char[] key = {'o', 'a'};
      char[] expecteds = {'o', 'o', 'a', 'f', 'e', 'h', 'g'};
      orderSort(items, key);
      Assert.assertArrayEquals(expecteds, items);
   }
}

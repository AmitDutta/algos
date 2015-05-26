package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Problem17 {
   
   // Using stringbuffer and returning list takes more time
   public List<Character> getChars(char ch) {
     if (ch == '2') {
        return Arrays.asList('a', 'b', 'c');
     } else if (ch =='3') {
        return Arrays.asList('d', 'e', 'f');
     } else if (ch == '4') {
        return Arrays.asList('g', 'h', 'i');
     } else if (ch == '5') {
        return Arrays.asList('j', 'k', 'l');
     } else if (ch == '6') {
        return Arrays.asList('m', 'n', 'o');
     } else if (ch == '7') {
        return Arrays.asList('p', 'q', 'r', 's');
     }else if (ch == '8') {
        return Arrays.asList('t', 'u', 'v');
     }
     return Arrays.asList('w', 'x', 'y', 'z');
   }
   
   public char getCh(char ch) {
      if (ch == '2') return 'a';
      if (ch == '3') return 'd';
      if (ch == '4') return 'g';
      if (ch == '5') return 'j';
      if (ch == '6') return 'm';
      if (ch == '7') return 'p';
      if (ch == '8') return 't';
      else return 'w';
   }
   
   public List<String> letterCombinationsInt(String digits, int index,
                                             char[] item, int start) {
      if (digits.length() == 0) return Arrays.asList();
      List<String> result = new ArrayList<String>();
      if (start == digits.length() - 1) {
         /*List<Character> chars = getChars(digits.charAt(start));
         for (Character ch : chars) {
            //result.add(buffer.toString() + ch);
            item[index] = ch;
            result.add(String.valueOf(item));
         }*/
         char ch = getCh(digits.charAt(start));
         int limit = (digits.charAt(start) == '7' || digits.charAt(start) == '9') ?
               4 : 3;
         for (char i = ch; i < (ch + limit); ++i) {
            item[index] = i;
            result.add(String.valueOf(item));
         }
      }
      else {
         //List<Character> chars = getChars(digits.charAt(start));
         char ch1 = getCh(digits.charAt(start));
         int limit = (digits.charAt(start) == '7' || digits.charAt(start) == '9') ?
               4 : 3;
         for (char ch = ch1; ch < (ch1 + limit); ++ch) {
            item[index++] = ch;
            //buffer.append(ch);
            List<String> tmp = letterCombinationsInt(digits, index, item, start + 1);
            result.addAll(tmp);
            //buffer.setLength(buffer.length() - 1);
            --index;
         }
      }
      return result;
   }
      
   public List<String> letterCombinations(String digits) {
      //return letterCombinationsInt(digits, new StringBuffer(), 0);
      return letterCombinationsInt(digits, 0, new char[digits.length()], 0);
   }
   
   private List<String> result;
   public List<Character> getLetters(char ch) {
      if (ch == '2') {
         return Arrays.asList('a', 'b', 'c');
      } else if (ch == '3') {
         return Arrays.asList('d', 'e', 'f');
      } else if (ch == '4') {
         return Arrays.asList('g', 'h', 'i');
      } else if (ch == '5') {
         return Arrays.asList('j', 'k', 'l');
      } else if (ch == '6') {
         return Arrays.asList('m', 'n', 'o');
      } else if (ch  == '7') {
         return Arrays.asList('p', 'q', 'r', 's');
      } else if (ch == '8') {
         return Arrays.asList('t', 'u', 'v');
      }
      return Arrays.asList('w', 'x', 'y', 'z');
   }
   public void letterInt(String digits, int current, StringBuffer buffer) {
       if (current == digits.length()) {
           result.add(buffer.toString());
           return;
       }
       List<Character> chars = getLetters(digits.charAt(current));
       for (Character ch : chars) {
           buffer.append(ch);
           letterInt(digits, current + 1, buffer);
           buffer.setLength(buffer.length() - 1);
       }
   }
   public List<String> letterCombinations1(String digits) {
      result = new ArrayList<String>();
      if (digits.length() == 0) return result;
      letterInt(digits, 0, new StringBuffer());
      return result;
   }

   @Test
   public void letterCombinationsTest() {
      long a = System.nanoTime();
      Problem17 p17 = new Problem17();
      List<String> actual = p17.letterCombinations("23");
      List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf",
            "cd", "ce", "cf");
      Assert.assertTrue(expected.size() == actual.size() &&
            actual.containsAll(expected));
      
      actual = p17.letterCombinations("");
      expected = new ArrayList<String>();
      Assert.assertTrue(expected.size() == actual.size() &&
            actual.containsAll(expected));
      
      actual = p17.letterCombinations("234");
      expected = Arrays.asList("adg", "adh", "adi", "aeg", "aeh", "aei", "afg",
            "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh",
            "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"
            );
      Assert.assertTrue(expected.size() == actual.size() &&
            actual.containsAll(expected));
      long b = System.nanoTime();
      System.out.println(b - a);
   }
}

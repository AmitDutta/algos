package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.junit.*;

public class Problem187 {
   // A=00,C=01,G=10,T=11
   public int getCode(String str) {
      int code = 0;
      for (int i = 0; i < str.length(); ++i) {
         if (str.charAt(i) == 'C') {
            code |= 1;
         } else if (str.charAt(i) == 'G') {
            code |= 2;
         } else if (str.charAt(i) == 'T') {
            code |= 3;
         }
         if (i < str.length() - 1) {
            code = code << 2;
         }
      }
      return code;
   }
   public String getString(int code) {
      char[] chars = new char[10];
      for (int i = 1; i <= 10; ++i) {
         int val = code & 3;
         char ch = 'X';
         if (val == 0) {
            ch = 'A';
         } else if (val == 1) {
            ch = 'C';
         } else if (val == 2) {
            ch = 'G';
         } else {
            ch = 'T';
         }
         chars[chars.length - i] = ch;
         code = code >> 2;
      }
      return new String(chars);
   }
   public List<String> findRepeatedDnaSequences(String s) {
      List<String> result = new ArrayList<String>();
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i <= s.length() - 10; ++i) {
         String str = s.substring(i, i + 10);
         int code = getCode(str);
         if (map.containsKey(code)) {
            map.put(code, map.get(code) + 1);
         } else {
            map.put(code, 1);
         }
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if (entry.getValue() > 1) {
            result.add(getString(entry.getKey()));
         }
      }
      return result;
   }
   @Test
   public void test1() {
      List<String> items = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
      for (String str : items) {
         System.out.println(str);
      }
   }
   @Test
   public void test2() {
      Assert.assertEquals("AAAAGGGTTT",getString(getCode("AAAAGGGTTT")));
      Assert.assertEquals("AAAAACCCCC",getString(getCode("AAAAACCCCC")));
      Assert.assertEquals("CCCCCAAAAA",getString(getCode("CCCCCAAAAA")));
   }
}

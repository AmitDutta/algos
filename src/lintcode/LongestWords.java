package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestWords {
   ArrayList<String> longestWords(String[] dictionary) {
      if (dictionary == null) return null;
      if (dictionary.length == 0) return new ArrayList<String>();
      int max = Integer.MIN_VALUE;
      ArrayList<String> lst = null;
      for (String str : dictionary) {
          if (str.length() > max) {
             max = str.length();
             lst = new ArrayList<String>();
             lst.add(str);
          } else if (str.length() == max) {
             lst.add(str);
          }
      }
      return lst;
   }
}

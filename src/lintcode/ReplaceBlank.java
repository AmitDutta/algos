package lintcode;

public class ReplaceBlank {
   public int replaceBlank(char[] string, int length) {
      if (string == null) return 0;
      // Write your code here
      int i = string.length;
      for (int j = length - 1; j >= 0; --j) {
          if (string[j] != ' ') {
              string[--i] = string[j];
          } else {
              string[--i] = '0';
              string[--i] = '2';
              string[--i] = '%';
          }
      }
      int k = 0;
      for (; i < string.length; ++i, ++k) {
          string[k] = string[i];
          string[i] = ' ';
      }
      return k;
   }
}

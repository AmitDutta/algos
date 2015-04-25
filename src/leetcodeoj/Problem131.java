package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


// with ispal 309ms
// with map 267 ms
public class Problem131 {
   public boolean isPalindrome(String str) {
      boolean isPal = true;
      for (int i = 0, j = str.length() -1; i <= j ; ++i,--j) {
         if (str.charAt(i) != str.charAt(j)) {
            isPal = false;
         }
      }
      return isPal;
   }

   private List<List<String>> result = new ArrayList<List<String>>();
   private boolean[][] map;
   public void partitionInt(String s, int start, List<String> lst) {
      if (start >= s.length()) {
         List<String> item = new ArrayList<String>(lst);
         result.add(item);
         return;
      }
      if (start < s.length()) {
         for (int len = 1; len + start <= s.length(); len++) {
            int end = start + len;
            //String str = s.substring(start, end);
            // map is 0 to length - 1, where charAt[end-1] is inclusive
            // for substring to include len - 1, need to go upto len exclusive
            //if (isPalindrome(str)) {
            if (map[start][end - 1]) {
               lst.add(s.substring(start, end));
               partitionInt(s, end, lst);
               lst.remove(lst.size() - 1);
            }
         }
      }
   }
   public void buildMap(String s) {
      map = new boolean[s.length()][s.length()];
      for (int i = 0; i < s.length(); ++i) {
         map[i][i] = true;
         if (i < s.length() - 1) {
            map[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false;
         }
      }

      for (int len = 2; len < s.length(); ++len) {
         for (int j = 0; (j + len) < s.length(); ++j) {
            map[j][j + len] = map[j + 1][j + len - 1] && (s.charAt(j) == s.charAt(j + len));
         }
      }
   }

   public List<List<String>>  partition(String s) {
      buildMap(s);
      partitionInt(s, 0, new ArrayList<String>());
      return result;
   }
   
   @Test
   public void partitionTest() {
      Problem131 p131 = new Problem131();
      List<List<String>> result = p131.partition("abxba");
      /*for (List<String> itm : result) {
         for (String str : itm) {
            System.out.print(str + " ");
         }
         System.out.println();
      }*/
   }
}

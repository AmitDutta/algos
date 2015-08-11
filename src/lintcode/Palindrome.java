package lintcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class Palindrome {
   private boolean[][] mat;
   private List<List<String>> lst;
   private void dfs(String s, int start, List<String> result) {
      if (start >= s.length()) {
         List<String> item = new ArrayList<String>(result);
         lst.add(item);
         return;
      }
      for (int i = start; i < s.length(); ++i) {
         if (mat[start][i]) {
            result.add(s.substring(start, i + 1));
            dfs(s, i + 1, result);
            result.remove(result.size() - 1);
         }
      }
   }
   public List<List<String>> partition(String s) {
      lst = new ArrayList<List<String>>();
      mat = new boolean[s.length()][s.length()];
      for (int i = 0; i < s.length(); ++i) {
         mat[i][i] = true;
         if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
            mat[i][i + 1] = true;
         }
      }
      for (int len = 3; len <= s.length(); ++len) {
         for (int i = 0; i <= s.length(); ++i) {
            int j = i + len - 1;
            if (j < s.length()) {
               if (s.charAt(i) == s.charAt(j) && mat[i + 1][j - 1]) {
                  mat[i][j] = true;
               }
            }
         }
      }
      dfs(s, 0, new ArrayList<String>());
      return lst;
   }
   //@Test
   public void test1() {
      List<List<String>> lst = partition("ccaa");
      for (List<String> l : lst) {
         for (String s : l) {
            System.out.println(s);
         }
      }
   }
   @Test
   public void test2() {
      List<List<String>> lst = partition("ccaacabacb");
      for (List<String> l : lst) {
         for (String s : l) {
            System.out.print(s + " ");
         }
         System.out.println();
      }
   }
}

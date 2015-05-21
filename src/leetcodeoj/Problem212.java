package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

// Few optimizations done
// 1. Mark trie leaf node false, once found. So no need to store words in hash
// 2. See how visited is tackled without extra array, we can do this always!
// without dfs flat 584 ms
// with flat dfs 644 ms! Why?
public class Problem212 {
   private class TrieNode {
      private boolean value;
      private TrieNode[] lst;
      public TrieNode() {
         value = false;
         lst = new TrieNode[26];
      }
   }
   private void insert(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); ++i) {
         int index = word.charAt(i) - 97;
         if (cur.lst[index] == null) {
            cur.lst[index] = new TrieNode();
         }
         cur = cur.lst[index];
      }
      cur.value = true;
   }
   private boolean search(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); ++i) {
         int index = word.charAt(i) - 97;
         cur = cur.lst[index];
         if (cur == null) {
            break;
         }
      }
      if (cur == null || !cur.value) {
         return false;
      }
      cur.value = false;
      return true;
   }
   private boolean startsWith(String prefix) {
      TrieNode cur = root;
      int i = 0;
      for (; i < prefix.length(); ++i) {
         int index = prefix.charAt(i) - 97;
         cur = cur.lst[index];
         if (cur == null) {
            break;
         }
      }
      return cur != null;
   }
   private class Pair {
      private int a, b;
      public Pair(int x, int y) {
         this.a = x;
         this.b = y;
      }
      public String toString() {
         return "(" + a + "," + b + ")";
      }
   }
   private List<String> result;
   private TrieNode root;
   private char[][] board;
   private boolean isInRange(int x, int y) {
      if (x < 0 || x >= board.length) return false;
      if (y < 0 || y >= board[0].length) return false;
      return true;
   }
   /*private List<Pair> getNeighbours(int x, int y) {
      List<Pair> lst = new ArrayList<Pair>();
      if (isInRange(x - 1, y)) lst.add(new Pair(x - 1, y));
      if (isInRange(x + 1, y)) lst.add(new Pair(x + 1, y));
      if (isInRange(x, y - 1)) lst.add(new Pair(x, y - 1));
      if (isInRange(x, y + 1)) lst.add(new Pair(x, y + 1));
      return lst;
   }*/
   private void dfs(int x, int y, StringBuffer buffer) {
      if (!isInRange(x, y) || board[x][y] == 'X') return;
      String current = buffer.toString() + board[x][y];
      if (!startsWith(current)) {
         return;
      }
      buffer.append(board[x][y]);
      if (search(buffer.toString())) {
         result.add(buffer.toString());
      }
      //List<Pair> neighbours = getNeighbours(x, y);
      char ch = board[x][y];
      board[x][y] = 'X';
      /*for (Pair neighbour : neighbours) {
         if (board[neighbour.a][neighbour.b] != 'X') {
            dfs(neighbour.a, neighbour.b, buffer);
         }
      }*/
      dfs(x - 1, y, buffer);
      dfs(x + 1, y, buffer);
      dfs(x, y - 1, buffer);
      dfs(x, y + 1, buffer);
      board[x][y] = ch;
      buffer.setLength(buffer.length() - 1);
   }
   public List<String> findWords(char[][] board, String[] words) {
      result = new ArrayList<String>();
      if (board.length == 0) return new ArrayList<String>();
      root = new TrieNode();
      for (int i = 0; i < words.length; ++i) {
         insert(words[i]);
      }
      this.board = board;
      for (int i = 0; i < board.length; ++i) {
         for (int j = 0; j < board[0].length; ++j) {
            dfs(i, j, new StringBuffer());
         }
      }
      return result;
   }
   @Test
   public void test1() {
      char[][] array =   {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
      String[] words = {"oath","pea","eat","rain"};
      List<String> result = findWords(array, words);
      List<String> expected = Arrays.asList("eat", "oath");
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
   @Test
   public void test2() {
      char[][] array =   {{'o','a','a','n', 'o'}};
      String[] words = {"o","oa","oaa","oaan"};
      List<String> result = findWords(array, words);
      List<String> expected = Arrays.asList("o","oa","oaa","oaan");
      Assert.assertTrue(result.containsAll(expected) && expected.containsAll(result));
   }
}

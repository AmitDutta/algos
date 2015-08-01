package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;



/* This code gives TLE. could not find reason
* Well, previously was doing
* for (Pair child : children)
* Now doing
* List<Pair> children = getNeighbours(x, y);
* for (Pair child : children)
* got acceptance
*/
public class Problem79 {
   
   private boolean found;
   private boolean isInRange(int i, int j, int rows, int cols) {
       if (i < 0 || i >= rows) return false;
       if (j < 0 || j >= cols) return false;
       return true;
   }
   private void dfs(char[][] board, String word, int i, int row, int col) {
       int rows = board.length;
       int cols = board[0].length;
       // why put later? think ["a"], "a"
       // if (!isInRange(row, col, rows, cols)) return;
       if (i == word.length()) {
           found = true;
           return;
       }
       if (!isInRange(row, col, rows, cols)) return;
       if (board[row][col] == '$') return;
       if (word.charAt(i) != board[row][col]) return;
       char ch = board[row][col];
       board[row][col] = '$';
       // top
       dfs(board, word, i + 1, row - 1, col);
       if (!found) {
          // bottom
          dfs(board, word, i + 1, row + 1, col);
       }
       if (!found) {
          // left
          dfs(board, word, i + 1, row, col - 1);
       }
       if (!found) {
          // right
          dfs(board, word, i + 1, row, col + 1);
       }
       board[row][col] = ch;
   }
   public boolean exist(char[][] board, String word) {
       found = false;
       if (board.length == 0) {
           return false;
       }
       for (int i = 0; i < board.length; ++i) {
           for (int j = 0; j < board[0].length; ++j) {
                found = false;
                dfs(board, word, 0, i, j);
                if (found) {
                    return found;
                }
           }
       }
       return false;
   }
   
   private int m, n;
   private char[][] board;
   private String str;
   //private boolean found;
   private boolean visited[][];

   private class Pair {
      int x;
      int y;
      public Pair (int x, int y) {
         this.x = x;
         this.y = y;
      }
   }

   private boolean isInRange(int x, int y) {
      if (x < 0 || x >= m) return false;
      if (y < 0 || y >= n) return false;
      return true;
   }
   
   private List<Pair> getNeighbours(int x, int y) {
      List<Pair> neighbours = new ArrayList<Pair>();
      if (isInRange(x - 1, y)) neighbours.add(new Pair(x -1, y));
      if (isInRange(x + 1, y)) neighbours.add(new Pair(x + 1, y));
      if (isInRange(x, y + 1)) neighbours.add(new Pair(x, y + 1));
      if (isInRange(x, y - 1)) neighbours.add(new Pair(x, y - 1));
      return neighbours;
   }

   public void dfs(int x, int y, int index) {
      if (index >= str.length()) {
         found = true;
         return;
      }
      if (str.charAt(index) != board[x][y]) return;
      if (index == str.length() - 1) {
         found = true;
         return;
      }
      visited[x][y] = true;
      List<Pair> children = getNeighbours(x, y);
      for (Pair child : children) {
         if (!visited[child.x][child.y]) {
            dfs (child.x, child.y, index + 1);
            if (found) return;
         }
      }
      visited[x][y] = false;
   }

   public boolean exist1(char[][] board, String word) {
      if (word.length() == 0 && board.length == 0) return true;
      if (word.length() > board.length * board[0].length) return false;
      this.board = board;
      m = board.length;
      n= board[0].length;
      this.str = word;
      found = false;
      visited = new boolean[m][n];
      for (int i = 0; i < board.length; ++i) {
         for (int j = 0; j < board[0].length; ++j) {
            visited = new boolean[m][n];
            if (board[i][j] == word.charAt(0)) {
               dfs(i, j, 0);
               if (found) return found;
            }
         }
      }
      return found;
   }

   @Test
   public void existTest0(){
      Problem79 p79 = new Problem79();
      char[][] board = {{'A', 'B'},{'B', 'C'}};
      Assert.assertTrue(p79.exist(board, "ABCB"));
   }
   
   @Test
   public void existTest1() {
      Problem79 p79 = new Problem79();
      char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
      Assert.assertTrue(p79.exist(board, "ABCCED"));
      Assert.assertTrue(p79.exist(board, "SEE"));
      Assert.assertFalse(p79.exist(board, "ABCB"));
   }
   
   @Test
   public void existTest2() {
      Problem79 p79 = new Problem79();
      char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
      Assert.assertTrue(p79.exist(board, "AAB"));
   }
   
   @Test
   public void existTest3() {
      Problem79 p79 = new Problem79();
      char[][] board = {{'A','B','C', 'E'}, {'S','F','E', 'S'}, {'A','D','E', 'E'}};
      Assert.assertTrue(p79.exist(board, "ABCESEEEFS"));
   }
}
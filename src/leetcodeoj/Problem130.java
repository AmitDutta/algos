package leetcodeoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

// With recursive dfs, got stack overflow.
// So better use iterative dfs always
public class Problem130 {
   private boolean visited[][];
   private char[][] board;
   private int m, n;
   private class Pair {
      int x,y;
      public Pair(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   private boolean isInRange(int i, int j) {
      boolean inRange = true;
      if (i < 0 || i >= m) inRange = false;
      if (j < 0 || j >= n) inRange = false;
      return inRange;
   }
   
   private List<Pair> getNeighbours(int i, int j) {
      List<Pair> neighbour = new ArrayList<Pair>();
      if (isInRange(i - 1, j)) neighbour.add(new Pair(i - 1, j));
      if (isInRange(i, j + 1)) neighbour.add(new Pair(i, j + 1));
      if (isInRange(i + 1, j)) neighbour.add(new Pair(i + 1, j));
      if (isInRange(i, j - 1)) neighbour.add(new Pair(i, j - 1));
      return neighbour;   
   }
   
   public void dfs(int i, int j) {
      if (board[i][j] != 'O') return;
      if (visited[i][j]) return;
      board[i][j] = '$'; // mark 0's as $
      List<Pair> neighbours = getNeighbours(i, j);
      for (Pair neighbour : neighbours) {
         if(board[neighbour.x][neighbour.y] == 'O') {
            dfs(neighbour.x, neighbour.y);
         }
      }
   }
   
   public void dfsI(int i, int j) {
      Stack<Pair> stack = new Stack<Pair>();
      Pair root = new Pair(i, j);
      stack.push(root);
      while (!stack.empty()) {
         Pair pair = stack.pop();
         visited[pair.x][pair.y] = true;
         board[pair.x][pair.y] = '$'; // mark 0's as $
         List<Pair> neighbours = getNeighbours(pair.x, pair.y);
         for (Pair neighbour : neighbours) {
            if(board[neighbour.x][neighbour.y] == 'O' &&
               !visited[neighbour.x][neighbour.y]) {
               stack.push(new Pair(neighbour.x, neighbour.y));
            }
         }
      }
   }
   
   public void solve(char[][] board) {
      if (board.length == 0) return;
      visited = new boolean[board.length][board[0].length];
      this.board = board;
      m = board.length;
      n= board[0].length;
      for (int i = 0; i < board.length; ++i) {
         for (int j = 0; j < board[0].length; ++j) {
            if (i > 0 && i < board.length - 1) {
               if (j > 0 && j < board[0].length - 1) {
                  continue;
               }
            }
            if (board[i][j] == 'O' && !visited[i][j]) {
               dfsI(i, j);
            }
         }
      }
      
      // mark all remaining 0's as X, and $'s as 0
      for (int i = 0; i < board.length; ++i) {
         for (int j = 0; j < board[0].length; ++j) {
            if (board[i][j] == 'O') {
               board[i][j] = 'X';
            }
            else if (board[i][j] == '$') {
               board[i][j] = 'O';
            }
         }
      }
   }

   /*@Test
   public void solveTest1() {
      char[][] board = {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
      solve(board);
      for (int i = 0; i < board.length; ++ i) {
         for (int j = 0; j < board[0].length; ++j) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println("");
      }
      System.out.println("---");
   }
   
   @Test
   public void solveTest2() {
      char[][] board = {{'X', 'X', 'X', 'X'},
                        {'O', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
      solve(board);
      for (int i = 0; i < board.length; ++ i) {
         for (int j = 0; j < board[0].length; ++j) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("---");
   }
   @Test
   public void solveTest3() {
      char[][] board = {{'X', 'O', 'O'}};
      solve(board);
      for (int i = 0; i < board.length; ++ i) {
         for (int j = 0; j < board[0].length; ++j) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("---");
   }
   
   @Test
   public void solveTest4() {
      char[][] board = {};
      solve(board);
      for (int i = 0; i < board.length; ++ i) {
         for (int j = 0; j < board[0].length; ++j) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("---");
   }
   
   @Test
   public void solveTest5() {
      char[][] board = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
      solve(board);
      for (int i = 0; i < board.length; ++ i) {
         for (int j = 0; j < board[0].length; ++j) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("---");
   }*/
   
   @Test
   public void solveTest6() {
      char[][] board = {{'X','O','X','O','X','O'},
                        {'O','X','O','X','O','X'},
                        {'X','O','X','O','X','O'},
                        {'O','X','O','X','O','X'}};
      solve(board);
      for (int i = 0; i < board.length; ++ i) {
         for (int j = 0; j < board[0].length; ++j) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println("---");
   }
}

package leetcodeoj;


import org.junit.Test;
import org.junit.Assert;;

public class Problem37 {

   public int get(int i) {
      return i < 3 ? 0 : (i < 6 ? 3 : 6 );
   }
   public boolean canPlace(char[][] board, char item, int i, int j) {
      for (int k = 0; k < board[0].length; ++k) {
         if (board[i][k] == item) return false;
      }
      for (int k = 0; k < board.length; ++k) {
         if (board[k][j] == item) return false;
      }
      int row_start = get(i);
      int col_start = get(j);
      for (int k = row_start; k < row_start + 3; ++k) {
         for (int l = col_start; l < col_start + 3; ++l) {
            if (board[k][l] == item) return false;
         }
       }
      return true;
   }
   // This is just plain brute force, can do a lot of heuristic
   // As did in level 3/2 buet :)
   public boolean canSolve(char[][] board) {
      for (int i = 0; i < board.length; ++i) {
         for (int j = 0; j < board[0].length; ++j) {
            if (board[i][j] == '.') {
               boolean found = false;
               for (char ch = '1'; ch <= '9'; ++ch) {
                  if (canPlace(board, ch, i, j)) {
                     board[i][j] = ch;
                     boolean result = canSolve(board);
                     if (result) {
                        found = true;
                        return result;
                     }else {
                        board[i][j] = '.';
                     }
                  }
               }
               if (!found) return false; // Important
            }
         }
      }
      return true;
   }
   public void solveSudoku(char[][] board) {
      canSolve(board);
   }

   @Test
   public void solveSudokuTest() {
      Problem37 p37 = new Problem37();
      char[][] board =
         {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
         };
      Assert.assertTrue(p37.canSolve(board));
   }
   
   @Test
   public void getTest() {
      Problem37 p37 = new Problem37();
      int row = 4, col = 4;
      Assert.assertEquals(3,  p37.get(row));
      Assert.assertEquals(3,  p37.get(col));
   }
   
   @Test
   public void canPlaceTest() {
      char[][] board =
         {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','7','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','5','.','.','6','.','.','.','3'},
            {'4','2','.','8','.','3','.','.','1'},
            {'7','1','.','.','2','.','.','.','6'},
            {'9','.','1','5','3','7','2','8','4'},
            {'2','8','7','4','1','9','.','.','5'},
            {'3','4','5','.','8','.','.','7','9'},
         };
      Problem37 p37 = new Problem37();
      Assert.assertFalse(p37.canPlace(board, '4', 6, 1));
      Assert.assertFalse(p37.canPlace(board, '1', 6, 1));
      Assert.assertTrue(p37.canPlace(board, '6', 6, 1));
      Assert.assertFalse(p37.canPlace(board, '3', 6, 1));
   }
}

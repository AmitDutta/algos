package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem74 {
   public boolean searchMatrix(int[][] matrix, int target) {
      int row = 0, col = matrix[0].length - 1;
      boolean found = false;
      while (row < matrix.length && col >= 0) {
         if (matrix[row][col] == target) {
            found = true;
            break;
         }
         if (target > matrix[row][col]) {
            row++;
         }else {
            col--;
         }
      }
      return found;
   }

   @Test
   public void searchMatrixTest() {
      Problem74 p74 = new Problem74();
      int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
      Assert.assertTrue(p74.searchMatrix(matrix, 23));
      Assert.assertFalse(p74.searchMatrix(matrix, 230));
   }
}

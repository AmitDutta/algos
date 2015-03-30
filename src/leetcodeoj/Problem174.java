package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

public class Problem174 {
    public int calculateMinimumHP1(int[][] dungeon) {  
        if(dungeon.length==0||dungeon[0].length==0)  
          return 0;  
        int m=dungeon.length;  
        int n=dungeon[0].length;  
        int[][] dp=new int[m][n];  
        dp[m-1][n-1]=Math.max(1, 1- dungeon[m-1][n-1]);  
        for(int j=n-2;j>=0;j--)  
          dp[m-1][j]=maxOfThree(1, 1-dungeon[m-1][j],-dungeon[m-1][j]+dp[m-1][j+1]);  
        for(int i=m-2;i>=0;i--)  
          dp[i][n-1]=maxOfThree(1, 1-dungeon[i][n-1],-dungeon[i][n-1]+dp[i+1][n-1]);  
        for(int i=m-2;i>=0;i--)  
        {  
          for(int j=n-2;j>=0;j--)  
          {       
            dp[i][j]=maxOfThree(1, 1-dungeon[i][j], Math.min(-dungeon[i][j]+dp[i+1][j], -dungeon[i][j]+dp[i][j+1]));  
          }  
           }  
           return dp[0][0];  
      }  
      public int maxOfThree(int a, int b, int c)  
      {  
        return Math.max(Math.max(a,b),c);  
      }    
   public int calculateMinimumHP(int[][] dungeon) {
       if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
      int[][] cost = new int[dungeon.length][dungeon[0].length];
      cost[0][0] = dungeon[0][0];
      for (int i = 1; i < dungeon[0].length; ++i) {
          int p = cost[0][i - 1] + dungeon[0][i];
         cost[0][i] = cost[0][i - 1] + dungeon[0][i];
      }
      for (int i = 1; i < dungeon.length; ++i) {
         cost[i][0] = cost[i - 1][0] + dungeon[i][0];
      }
      for (int i = 1; i < dungeon.length; ++i) {
         for (int j = 1; j < dungeon[0].length; ++j) {
             int c1 = cost[i-1][j] + dungeon[i][j];
             int c2 = cost[i][j-1] + dungeon[i][j];
             if (c1 < 0 && c2 < 0) {
                 cost[i][j] = Math.max(c1, c2);
             }else {
                 cost[i][j] = Math.min(c1, c2);
             }
         }
      }
      int result = cost[dungeon.length-1][dungeon[0].length - 1];
      return result >  0 ? 1 : Math.abs(result) + 1 ;
   }
   
   public void print(int[][] array) {
      System.out.println("--");
      for (int i = 0; i < array.length; ++i) {
         for (int j = 0; j < array[0].length; ++j) {
            System.out.print(array[i][j] + " ");
         }
         System.out.println();
      }
   }
   
   @Test
   public void calculateMinimumHPTest() {
      Problem174 p174 = new Problem174();
      int[][] game = new int[][] {
            {-2,-3,3},
            {-5,-10,1},
            {10,30,-5}
      };
      Assert.assertEquals(7, p174.calculateMinimumHP(game));
      game = new int[][] {{0,0}};
      Assert.assertEquals(1, p174.calculateMinimumHP(game));
      game = new int[][] {{0},{0}};
      Assert.assertEquals(1, p174.calculateMinimumHP(game));
      game = new int[][] {{100}};
      Assert.assertEquals(1, p174.calculateMinimumHP(game));
      game = new int[][] {{-3, 5}};
      Assert.assertEquals(4, p174.calculateMinimumHP(game));
   }
}

package leetcodeoj;

import org.junit.Test;
import org.junit.Assert;

// http://yucoding.blogspot.com/2014/02/leetcode-question-candy.html
// Need to study this theory, greedy

// the new one with dp http://rleetcode.blogspot.com/2014/01/candy-java.html
public class Problem135 {
   
   public int candy(int[] ratings) {
      if (ratings.length == 0 || ratings == null) return 0;
      int[] cost = new int[ratings.length];
      // everyone gets 1
      for (int i = 0; i < cost.length; ++i) {
          cost[i] = 1;
      }
      // left to  right
      for (int i = 1; i < cost.length; ++i) {
          if (ratings[i] > ratings[i - 1]) {
              cost[i] = cost[i - 1] + 1;
          }
      }
      // right to left [1,5,2,1] // correct 2
      for (int i = cost.length - 2; i >= 0; --i) {
          if (ratings[i] > ratings[i + 1] && cost[i] <= cost[i + 1]) {
              cost[i] = cost[i + 1] + 1;
          }
      }
      int result = 0;
      for (int i = 0; i < cost.length; ++i) result += cost[i];
      return result;
   }
   public int candy1(int[] ratings) {
     if (ratings.length == 0) return 0;
     if (ratings.length == 1) return 1;
     int[] left = new int[ratings.length];
     int[] right = new int[ratings.length];
     int needed = 0;
     for (int i = 0; i < ratings.length; ++i) {
        left[i] = 1;
        right[i] = 1;
     }
     
     for (int i = 1; i < ratings.length; ++i) {
        if (ratings[i] > ratings[i - 1]) {
           left[i] = left[i - 1] + 1;
        }
     }
     
     for (int i = ratings.length - 2; i >= 0; --i) {
        if (ratings[i] > ratings[i + 1]) {
           right[i] = right[i + 1] + 1;
        }
     }
     
     for (int i = 0; i < ratings.length; ++i) {
        needed += Math.max(left[i], right[i]);
     }
     
     return needed;
   }
   
   @Test
   public void candyTest() {
      Problem135 p135 = new Problem135();
      Assert.assertEquals(8,  p135.candy(new int[] {5,4,1,6}));
   }
 }

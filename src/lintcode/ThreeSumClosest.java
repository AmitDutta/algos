package lintcode;

import java.util.Arrays;

public class ThreeSumClosest {
   // This one is not very trivial..But keep basics corrct.
   // Sum .... X .... Sum; if (sum > targer, end--; else start++
   // keep track of diff, and record sum when diff is minimum
   public int threeSumClosest(int[] numbers ,int target) {
      // write your code here 
      int prev = Integer.MAX_VALUE, result = 0;
      Arrays.sort(numbers);
      for (int i = 0; i < numbers.length - 2; ++i) {
          int start = i + 1;
          int end = numbers.length - 1;
          while (start < end) {
              int sum = numbers[i] + numbers[start] + numbers[end];
              int diff = Math.abs(target - sum);
              if (diff < prev) {
                  prev = diff;
                  result = sum;
              }
              if (sum == target) {
                  return result;
              } else if (sum > target) {
                  end--;
              } else {
                  start++;
              }
          }
      }
      return result;
  }
}

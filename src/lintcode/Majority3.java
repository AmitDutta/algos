package lintcode;

import java.util.ArrayList;

public class Majority3 {
   public int majorityNumber(ArrayList<Integer> nums) {
      int c1 = 0, c2 = 0, num1 = 0, num2 = 0;
      for (int i = 0; i < nums.size(); ++i) {
          if (c1 == 0) {
              num1 = nums.get(i);
              c1++;
          } else if (nums.get(i) == num1) {
              c1++;
          } else if (c2 == 0) {
              num2 = nums.get(i);
              c2++;
          } else if (nums.get(i) == num2) {
              c2++;
          } else {
              c1--;
              c2--;
          }
      }
      // now num1 and num2 are candidate..lets find who has more count
      int fc1 = 0, fc2 = 0;
      for (int i = 0; i < nums.size(); ++i) {
          if (nums.get(i) == num1) fc1++;
          else if (nums.get(i) == num2) fc2++;
      }
      return fc1 > fc2 ? num1 : num2;
  }
}

package leetcodeoj;

import java.util.ArrayList;
import java.util.List;

public class Problem229 {
   public List<Integer> majorityElement(int[] nums) {
      int c1 = 0, c2 = 0, num1 = 0, num2 = 0;
      for (int i = 0; i < nums.length; ++i) {
          if (c1 == 0) {
              num1 = nums[i];
              c1++;
          } else if (nums[i] == num1) {
              c1++;
          } else if (c2 == 0) {
              num2 = nums[i];
              c2++;
          } else if (nums[i] == num2) {
              c2++;
          } else {
              c1--;
              c2--;
          }
      }
      List<Integer> result = new ArrayList<Integer>();
      int fc1 = 0, fc2 = 0;
      for (int i = 0; i < nums.length; ++i) {
          if (nums[i] == num1) fc1++;
          else if (nums[i] == num2) fc2++;
      }
      int k = (int) Math.floor(nums.length/3) + 1;
      if (fc1 >= k) result.add(num1);
      if (fc2 >= k) result.add(num2);
      return result;
    }
}

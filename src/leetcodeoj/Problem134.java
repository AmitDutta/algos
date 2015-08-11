package leetcodeoj;

import org.junit.Assert;
import org.junit.Test;

public class Problem134 {
   public int canCompleteCircuit(int[] gas, int[] cost) {
      int result = -1;
      int j = 0;
      for (int turn = 0; turn < gas.length; ++turn) {
         int prev = 0;
         int k = gas.length - 1;
         for (; k >= 0; --k) {
            prev += gas[j];
            if (prev < cost[j]) {
               break;
            }
            prev -= cost[j];
            j = (j + 1) % gas.length;
         }
         if (k < 0) {
            result = j;
            break;
         } else if (k == gas.length - 1) {
            // k did not change..proceed j
            j = (j + 1) % gas.length;
         }
      }
      return result;
   }
   
   @Test
   public void test1() {
      int[] gas = new int[]{4,6,7,4};
      int[] cost = new int[] {6,5,3,5};
      Assert.assertEquals(1, canCompleteCircuit(gas, cost));
   }
   @Test
   public void test2() {
      int[] gas = new int[]{2,4};
      int[] cost = new int[] {3,4};
      Assert.assertEquals(-1, canCompleteCircuit(gas, cost));
   }
   @Test
   public void test3() {
      int[] gas = new int[]{2};
      int[] cost = new int[] {5};
      Assert.assertEquals(-1, canCompleteCircuit(gas, cost));
   }
   @Test
   public void test4() {
      int[] gas = new int[]{5};
      int[] cost = new int[] {4};
      Assert.assertEquals(0, canCompleteCircuit(gas, cost));
   }
}

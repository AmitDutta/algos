package ds;
public class Sorts {
   public static void insertionsort(int[] nums) {
      for (int i = 1; i < nums.length; ++i){
         if (nums[i] < nums[i - 1]) {
            int tmp =nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
               nums[j + 1] = nums[j];
               --j;
            }
            nums[++j] = tmp;
         }
      }
   }
}

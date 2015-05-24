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
   public static void swap(int nums[], int i, int j) {
      int tmp = nums[i];
      nums[j] = nums[i];
      nums[i] = tmp;
   }
   public static void partition(int nums[]) {
      int lo = 0, high = nums.length - 1;
      int lt = lo, gt = high;
      int i = lt;
      int pivot = nums[high];
      while (i <= gt) {
         if (nums[i] > pivot) {
            swap(nums, i, gt);
            gt--;
         } else if (nums[i] < pivot) {
            swap (nums, i, lt);
            ++i;
            ++lt;
         } else {
            ++i;
         }
      }
   }
}

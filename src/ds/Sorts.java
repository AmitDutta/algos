package ds;

import java.util.Comparator;

import org.junit.*;

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
      nums[i] = nums[j];
      nums[j] = tmp;
   }
   
   public class IntegerComparator implements Comparator<Integer> {

      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1.equals(o2)) return 0;
        if (o1 <  o2) return -1;
        return 1;
      }
   }

   // Based on the comparator, zeros will move left or right
   public static void moveZeros(int nums[], IntegerComparator cmp) {
      int pivot = 0;
      int lt = -1;
      int gt = nums.length - 1;
      for (int j = 0; j <= gt; ) {
         if (cmp.compare(nums[j], pivot) > 0) {
            swap(nums, j, gt);
            gt--;
         } else if (cmp.compare(nums[j], pivot) < 0) {
            swap(nums, j, ++lt);
            ++j;
         } else {
            ++j;
         }
      }
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

   public static void bubblesort(int[] nums) {
      // at each iteration, one items bubbles to its destination
      for (int i = 0; i < nums.length; ++i) {
         for (int j = i + 1; j < nums.length; ++j) {
            if (nums[i] > nums[j]) {
               int tmp = nums[j];
               nums[j] = nums[i];
               nums[i] = tmp;
            }
         }
      }
   }
   @Test
   public void moveZerosLeft1() {
      int[] num = {5,6,9,20,100,0};
      moveZeros(num, new IntegerComparator());
      for (int i = 0; i < num.length; ++i) {
         System.out.println(num[i]);
      }
   }
   @Test
   public void test1() {
      int[] num = {1,5,4,3,2,1};
      bubblesort(num);
      for (int k = 0; k < num.length; ++k) {
         System.out.print(num[k]);
         if (k < num.length - 1) {
            System.out.print(",");
         }
      }
      System.out.println();
   }
}

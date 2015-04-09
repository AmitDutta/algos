package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {
   private List<List<Integer>> result;
   private void permuteUniqueInt(int[] num, List<Integer> cur,
         boolean[] used) {
      if (cur.size() == num.length) {
         // This new is required
         result.add(new ArrayList<Integer>(cur));
         return;
      }
      for (int i = 0; i < num.length; ++i) {
         if (!used[i]) {
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
               continue;
            }
            used[i] = true;
            cur.add(num[i]);
            permuteUniqueInt(num, cur, used);
            used[i] = false;
            cur.remove(cur.size() - 1);
         }
      }
   }
   public List<List<Integer>> permuteUnique(int[] num) {
      result = new ArrayList<List<Integer>>();
      Arrays.sort(num);
      permuteUniqueInt(num, new ArrayList<Integer>(), new boolean[num.length]);
      return result;
   }
}
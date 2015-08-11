package leetcodeoj;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
/*
 * Given a List of words and Two words  word1  and  word2 , return the Shortest Distance BETWEEN THESE Two words in the List.

   For Example, 
   Assume That words =  ["Practice", "Makes", "Perfect", "Coding", "Makes"] .

   Given  word1  = "Coding" ,  word2  =  "Practice" , return 3. 
   Given  word1  =  "Makes" ,  word2  =  "Coding" , return 1.

   Note: 
   You May ASSUME That  word1  does not equal to  word2 , and  word1  and  word2  Both are in the List.
 */
public class Problem243 {
   public int shortest(List<String> lst, String word1, String word2) {
      int dist = Integer.MAX_VALUE;
      int a, b;
      a = b = -1;
      for (int i = 0; i < lst.size(); ++i) {
         if (lst.get(i).equals(word1)) {
             a = i;
         } else if (lst.get(i).equals(word2)) {
            b = i;
         }
         if (a != - 1 && b != -1) {
            dist = Math.min(dist, Math.abs(a - b));
         }
      }
      return dist;
   }
   @Test
   public void test1() {
      List<String> words = Arrays.asList("Practice", "Makes", "Perfect", "Coding", "Makes");
      Assert.assertEquals(3, shortest(words, "Coding", "Practice"));
      Assert.assertEquals(1, shortest(words, "Makes", "Coding"));
   }
   @Test
   public void test2() {
      List<String> words = Arrays.asList("Practice", "Makes", "Perfect", "Coding", "Makes");
      Problem244 p244 = new Problem244(words);
      Assert.assertEquals(3, p244.shortest("Coding", "Practice"));
      Assert.assertEquals(1, p244.shortest("Makes", "Coding"));
   }
}

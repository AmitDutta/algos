package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

/*
 * This is a Follow up of  Shortest Distance Word . The only Difference is you are now Given the List of words 
 * and your Method Will be Called  Repeatedly  many Times with Different parameters. How Would you optimize it?

 Design a class Which Receives a List of words in the constructor, and implements a Method That Takes Two words 
  word1  and  word2  and return the Shortest Distance BETWEEN THESE Two words in the List.

      For Example, 
   Assume That words =  ["Practice", "Makes", "Perfect", "Coding", "Makes"] .

   Given  word1  =  "Coding" ,  word2  =  "Practice" , return 3. 
   Given  word1  =  "Makes" ,  word2  =  "Coding" , return 1.

   Note: 
   You May ASSUME That  word1  does not equal to  word2 , and  word1  and  word2  Both are in the List.
 * */

// This one is interesting..
public class Problem244 {
   Map<String, List<Integer>> map;
   public Problem244(){}
   public Problem244(List<String> words) {
      map = new HashMap<String, List<Integer>>();
      for (int i = 0; i < words.size(); ++i) {
         if (!map.containsKey(words.get(i))) {
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(i);
            map.put(words.get(i), lst);
         } else {
            map.get(words.get(i)).add(i);
         }
      }
   }
   
   // Finding minimum distance between 2 sorted array
   public int shortest(String word1, String word2) {
      int min = Integer.MAX_VALUE;
      List<Integer> lst1 = map.get(word1);
      List<Integer> lst2 = map.get(word2);
      int i = 0, j = 0;
      while (true) {
         if (i == lst1.size() || j == lst2.size()) {
            break;
         }
         if (lst1.get(i) > lst2.get(j)) {
            min = Math.min(min, lst1.get(i) - lst2.get(j));
            ++j;
         } else if (lst1.get(i) < lst2.get(j)) {
            min = Math.min(min, lst2.get(j) - lst1.get(i));
            i++;
         }
      }
      // the following code is not required at all..
      // {4}, {1,5,6} OR {1,5,6}, {4}
      /*if (i == lst1.size() && j == lst2.size()) {
         return min;
      }
      if (i == lst1.size()) {
         min = Math.min(min, Math.abs(lst1.get(i - 1) - lst2.get(j)));
      } else {
         min = Math.min(min, Math.abs(lst2.get(j - 1) - lst1.get(i)));
      }*/
      return min;
   }
}

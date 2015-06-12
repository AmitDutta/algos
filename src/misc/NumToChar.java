package misc;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

   /*Given that: '1' mapped to--> 'a', '2' -->'b' , '3'--> 'c'...like wise... '26'-->'z'.
   
   Output should be in the following pattern :
   Ex.1) if we input f="111", the output should be: aaa, ak, ka
   //(111)->aaa, (1, 11)->ak, (11,1)->ka
   
   Ex. 2) f="131" output: aca, ma
   //(131)->aca, (13,1)->ma
   
   Ex. 3) f="101", output: ja
   //(10,1)->ja  */
public class NumToChar {
   List<String> result;
   private char getStr(String str) {
      int n = Integer.parseInt(str);
      return (char) (96 + n);
   }
   private void parseInt(String number, StringBuffer buffer) {
      if (number.length() == 0) {
         result.add(buffer.toString());
         return;
      }
      for (int i = 1; i <= Math.min(2, number.length()); ++i) {
         buffer.append(getStr(number.substring(0, i)));
         parseInt(number.substring(i), buffer);
         buffer.setLength(buffer.length() - 1);
      }
   }
   public List<String> parse(String number) {
      result = new ArrayList<String>();
      parseInt(number, new StringBuffer());
      return result;
   }
   @Test
   public void test1() {
      List<String> result = parse("111");
      for (String str : result) {
         System.out.println(str);
      }
   }
   
   /*Given a set of strings, return the smallest subset that contains prefixes for every string.

   If the list is ['foo', 'foog', 'food', 'asdf'] return ['foo', 'asdf']*/
   // Solve: just throw all data in trie, from root level, find all the prefixes
   // from trie
   
   /*Binary tree vertical sum, hashmap left -1 right + 1 root 0*/
}

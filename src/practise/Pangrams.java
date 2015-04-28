package practise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {
   public static boolean isPangram(String s) {
      Set<Character> set = new HashSet<Character>();
      s = s.toLowerCase();
      for (int  i = 0; i < s.length(); ++i) {
         if (s.charAt(i) != ' ') {
            set.add(s.charAt(i));
         }
      }
      return set.size() == 26 ? true : false;
   }
   
   public static void main(String... s) {
      Scanner in = new Scanner(System.in);
      String str1 = in.nextLine();
      if (isPangram(str1)) {
         System.out.println("pangram");
      }else {
         System.out.println("not pangram");
      }
   }
}

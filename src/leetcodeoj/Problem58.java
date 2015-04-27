package leetcodeoj;

public class Problem58 {
   public int lengthOfLastWord(String s) {
      s = s.trim();
      if (s.length() == 0) return 0;
      int len = 0;
      for (int i = s.length() - 1; i >= 0; --i) {
         if (s.charAt(i) == ' ') {
            break;
         }
         len++;
      }
      return len;
   }
}

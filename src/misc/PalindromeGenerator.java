package misc;

public class PalindromeGenerator {
   public String generate(int len) {
      if (len == 0) return "";
      char letter =  (char) ((int) Math.random() * (('Z' - 'A' + 1) + 'A'));
      if (len == 1) Character.toString(letter);
      return letter + generate(len - 2) + letter;
   }
}

package practise;

public class Pyramid {
   public void print(int howMany, String str) {
      for (int i = 1; i <= howMany; ++i) {
         System.out.print(str);
      }
   }
   public void draw(int depth) {
      for (int level = 1; level <= depth; ++level) {
         /* First print spaces. Each level has (depth - level) 
          * number of pair spaces.
          */
         int spaces = depth - level;
         print(spaces, "  ");

         /* Each level has 2 *level - 1 number of starts */
         int stars = 2 * level - 1;
         print(stars, "* ");

         System.out.println();
      }
      
      /*  Now the bottom part, exactly opposite */
      for (int level = depth - 1; level >= 1; --level) {
         int spaces = depth - level;
         print(spaces, "  ");
         int stars = 2 * level - 1;
         print(stars, "* ");
         System.out.println();
      }
   }
   public static void main(String... args) {
      Pyramid pyramid = new Pyramid();
      pyramid.draw(5);
   }
}

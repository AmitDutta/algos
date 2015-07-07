package collections;

import java.util.Iterator;

import org.junit.Test;

public class TextFileTest {
   @Test
   public void test1() {
      TextFile file = new TextFile("/Users/amitd/Documents/workspace/test.cpp");
      Iterator<String> it = file.iterator();
      it.hasNext();
      it.hasNext();
      System.out.println(it.next());
      System.out.println(it.next());
      /*while (it.hasNext()) {
         System.out.println(it.next());
      }*/
   }
}

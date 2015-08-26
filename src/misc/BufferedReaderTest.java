package misc;

import org.junit.*;

public class BufferedReaderTest {
   @Test
   public void test1()  throws Exception{
      String src = "amitdashitamitd";
      BufferedReader reader = new BufferedReader(src.toCharArray());
      Assert.assertEquals("amitd", reader.Read(5));
      Assert.assertEquals("ashit", reader.Read(5));
      Assert.assertEquals("amitd", reader.Read(5));
   }
   @Test
   public void test2() throws Exception {
      String src = "amitdashitamitd";
      BufferedReader reader = new BufferedReader(2, src.toCharArray());
      Assert.assertEquals("amitd", reader.Read(5));
      Assert.assertEquals("ashit", reader.Read(5));
      Assert.assertEquals("amitd", reader.Read(5));
   }
}

package ds;
import org.junit.*;
public class BVTest {
   @Test
   public void BVTest1() {
      BV bv = new BV(50);
      bv.add(5);
      bv.add(0);
      bv.add(45);
      Assert.assertTrue(bv.containsKey(5));
      Assert.assertTrue(bv.containsKey(0));
      Assert.assertTrue(bv.containsKey(45));
      Assert.assertFalse(bv.containsKey(20));
      bv.remove(5);
      bv.remove(45);
      bv.remove(0);
      Assert.assertFalse(bv.containsKey(5));
      Assert.assertFalse(bv.containsKey(0));
      Assert.assertFalse(bv.containsKey(45));
   }
   @Test
   public void BVTest2() {
      BV bv = new BV();
      bv.add(99);
      bv.add(Integer.MAX_VALUE - 1);
      Assert.assertTrue(bv.containsKey(Integer.MAX_VALUE - 1));
      Assert.assertTrue(bv.containsKey(99));
      Assert.assertFalse(bv.containsKey(0));
   }
}

package ds;
import org.junit.*;
public class CacheTest {
   @Test
   public void test1() {
      LRUCache cache = new LRUCache(1);
      cache.set(2, 1);
      Assert.assertEquals(1, cache.get(2));
      cache.set(3, 2);
      Assert.assertEquals(2, cache.get(3));
      Assert.assertEquals(-1, cache.get(2));
      Assert.assertEquals(2, cache.get(3));
   }
   @Test
   public void test2() {
      LRUCache cache = new LRUCache(3);
      Assert.assertEquals(-1, cache.get(2));
      cache.set(1, 1);
      cache.set(2, 2);
      cache.set(3, 3);
      Assert.assertEquals(2, cache.get(2));
      Assert.assertEquals(1, cache.get(1));
      cache.set(4, 4);
      Assert.assertEquals(-1, cache.get(3));
      Assert.assertEquals(4, cache.get(4));
      Assert.assertEquals(2, cache.get(2));
      Assert.assertEquals(1, cache.get(1));
   }
   @Test
   public void test3() {
      LRUCache cache = new LRUCache(4);
      Assert.assertEquals(-1, cache.get(2));
      cache.set(1, 1);
      cache.set(2, 2);
      cache.set(3, 3);
      cache.set(4, 4);
      Assert.assertEquals(2, cache.get(2));
      Assert.assertEquals(1, cache.get(1));
      Assert.assertEquals(4, cache.get(4));
      cache.set(4, 4);
      cache.set(5, 5);
      cache.set(6, 6);
      cache.set(7, 7);
      Assert.assertEquals(-1, cache.get(3));
      Assert.assertEquals(4, cache.get(4));
      Assert.assertEquals(-1, cache.get(2));
      Assert.assertEquals(-1, cache.get(1));
   }
   @Test
   public void test4() {
      LRUCache cache = new LRUCache(2);
      cache.set(2, 1);
      cache.set(1, 1);
      cache.set(2, 3);
      cache.set(4, 1);
      Assert.assertEquals(-1, cache.get(1));
      Assert.assertEquals(3, cache.get(2));
   }
   @Test
   public void test5() {
      LRUCache cache = new LRUCache(3);
      cache.set(1,1);
      cache.set(2,2);
      cache.set(3,3);
      cache.set(4,4);
      Assert.assertEquals(4, cache.get(4));
      Assert.assertEquals(3, cache.get(3));
      Assert.assertEquals(2, cache.get(2));
      Assert.assertEquals(-1, cache.get(1));
      cache.set(5,5);
      Assert.assertEquals(-1, cache.get(1));
      Assert.assertEquals(2, cache.get(2));
      Assert.assertEquals(3, cache.get(3));
      Assert.assertEquals(-1, cache.get(4));
      Assert.assertEquals(5, cache.get(5));
   }
}

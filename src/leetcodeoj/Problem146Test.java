package leetcodeoj;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Problem146Test {
    @Test
    public void Test1() {
        Problem146 lru = new Problem146(1);
        Assert.assertEquals(-1, lru.get(50));
        lru.set(5, 45);
        lru.set(6, 46);
        Assert.assertEquals(-1, lru.get(5));
        Assert.assertEquals(46, lru.get(6));
    }
    
    @Test
    public void Test2() {
        Problem146 lru = new Problem146(5);
        lru.set(4, 20);
        lru.set(3, 21);
        Assert.assertEquals(20, lru.get(4));
        Assert.assertEquals(21, lru.get(3));
    }
    
    @Test
    public void Test3() {
        Problem146 lru = new Problem146(3);
        lru.set(0, 5);
        lru.set(1, 10);
        lru.set(2, 15);
        lru.set(4, 20);
        Assert.assertEquals(-1, lru.get(0));
        Assert.assertEquals(10, lru.get(1));
        Assert.assertEquals(15, lru.get(2));
        Assert.assertEquals(20, lru.get(4));
        
    }
    
    @Test
    public void Test4() {
        Problem146 lru = new Problem146(3);
        lru.set(0, 5);
        lru.set(1, 10);
        lru.set(2, 15);
        lru.get(0);
        lru.get(1);
        lru.set(4, 20);
        Assert.assertEquals(-1, lru.get(2));
        Assert.assertEquals(5, lru.get(0));
        Assert.assertEquals(10, lru.get(1));
        Assert.assertEquals(20, lru.get(4));
        
    }
    
    @Test
    public void Test5() {
        Problem146 lru = new Problem146(3);
        lru.set(0, 5);
        lru.set(1, 10);
        lru.set(2, 15);
        lru.get(0);
        lru.get(1);
        lru.set(4, 20);
        Assert.assertEquals(-1, lru.get(2));
        Assert.assertEquals(5, lru.get(0));
        Assert.assertEquals(10, lru.get(1));
        Assert.assertEquals(20, lru.get(4));
        
    }

    @Test
    public void Test6() {
        Problem146 lru = new Problem146(2);
        Assert.assertEquals(-1, lru.get(2));
        lru.set(2, 6);
        Assert.assertEquals(-1, lru.get(1));
        lru.set(1, 5);
        lru.set(1, 2);
        Assert.assertEquals(2, lru.get(1));
        Assert.assertEquals(6, lru.get(2));
        
    }

    @Test
    public void Test7() {
        Problem146 lru = new Problem146(2);
        lru.set(2, 1);
        lru.set(1, 1);
        lru.set(2, 3);
        lru.set(4, 1);
        Assert.assertEquals(-1, lru.get(1));
        Assert.assertEquals(3, lru.get(2));
        Assert.assertEquals(1, lru.get(4));
    }
}

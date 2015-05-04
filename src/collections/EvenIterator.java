package collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


// Need to refactor..
public class EvenIterator implements Iterator<Integer> {
    private Iterator<Integer> it = null;
    private boolean flag = false;
    private Integer item;
    public void SetIterator(Iterator<Integer> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        boolean val = false;
        if (!it.hasNext()) {
            return val;
        }

        if (!flag) {
            Integer cur = null;
            while (it.hasNext()) {
                cur = it.next();
                if ((cur % 2) == 0) {
                    item = cur;
                    break;
                }
            }
        }

        if (item != null) {
            val = true;
        }
        flag = true;
        return val;
    }

    @Override
    public Integer next() {
        Integer ret = null;
        if (flag) {
            ret = item;
        }else {
            Integer cur = null;
            while (it.hasNext()) {
                cur = it.next();
                if ((cur % 2) == 0) {
                    ret = cur;
                    break;
                }
            }
        }
        flag = false;
        item = null;
        return ret;
        
    }
    
    @Test
    public void EvenIteratorTest() {
        List<Integer> items = Arrays.asList(1,3,5,7,2,9,4);
        EvenIterator it = new EvenIterator();
        it.SetIterator(items.iterator());
        List<Integer> expecteds = Arrays.asList(2, 4);
        Assert.assertEquals(expecteds, getList(it));
        
        it = new EvenIterator();
        items = Arrays.asList(1);
        it.SetIterator(items.iterator());
        Assert.assertFalse(it.hasNext());
        
        it = new EvenIterator();
        items = Arrays.asList(2);
        it.SetIterator(items.iterator());
        expecteds = Arrays.asList(2);
        Assert.assertEquals(expecteds, getList(it));
        
        it = new EvenIterator();
        items = Arrays.asList(2,4,9);
        it.SetIterator(items.iterator());
        expecteds = Arrays.asList(2,4);
        Assert.assertEquals(expecteds, getList(it));
    }
    
    private List<Integer> getList(Iterator<Integer> it) {
        List<Integer> result = new ArrayList<Integer>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }
}

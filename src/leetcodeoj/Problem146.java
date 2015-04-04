package leetcodeoj;

import java.util.LinkedHashMap;
import java.util.Map;

/* This can be done with doubly lined list and a map. However, LinkedHashMap
 * gives us exactly that feature.
 * http://www.programcreek.com/2013/03/hashmap-vs-treemap-vs-hashtable-vs-linkedhashmap/ */
public class Problem146 {
    private int capactiy;
    private Map<Integer, Integer> map;
    public Problem146(int capacity) {
        this.capactiy = capacity;
        map = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int item = map.get(key);
        map.remove(key);
        map.put(key, item);
        return item;
    }

    public void set(int key, int value) {
        if (map.size() >= capactiy) {
            if (!map.containsKey(key)) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    map.remove(entry.getKey());
                    break;
                }
            }    
        }

        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }else {
            map.put(key, value);
        }
    }
}

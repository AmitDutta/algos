package leetcodeoj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


// beware of self loops and cycles :)
// test is bad, but for the time, so be it

public class Problem133 {
    private Set<Integer> map;
    private Map<Integer, UndirectedGraphNode> cloneMap;
    public UndirectedGraphNode cloneGraphInt(UndirectedGraphNode node, 
          UndirectedGraphNode clonedRoot) {
       if (node == null) return null;
       map.add(node.label);
       UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
       cloneMap.put(cloned.label, cloned);
       if (clonedRoot != null) {
          if (clonedRoot.label == node.label) {
             // self link
             clonedRoot.neighbors.add(clonedRoot);
          } else{
             clonedRoot.neighbors.add(cloned);
          }
       }
       for (UndirectedGraphNode child : node.neighbors) {
          if (!map.contains(child.label)) {
             cloneGraphInt(child, cloned);
          }else {
             // find cloned nodes and those it it's neighbor
             // why the other map? when we visit 3, we already visited 1 and 2
             // therefore no recursive call to them..we still need to add 1 and 
             // 2 to 3's neighbor list. We can get cloned nodes from cloned map
             /*         
              *     1 -- 3
              *      \  /
              *       2     
              * */
             UndirectedGraphNode tmp = cloneMap.get(child.label);
             cloned.neighbors.add(tmp);
          }
       }
       return cloned;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashSet<Integer>();
        cloneMap = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphInt(node, null);
    }
    
    private class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
    
    @Test
    public void cloneGraphTest1() {
        UndirectedGraphNode nd = new UndirectedGraphNode(0);
        nd.neighbors.add(nd);
        nd.neighbors.add(nd);
        UndirectedGraphNode cloned = cloneGraph(nd);
        Assert.assertEquals(2, cloned.neighbors.size());
    }

    @Test
    public void cloneGraphTest2() {
        UndirectedGraphNode nd1 = new UndirectedGraphNode(1);
        UndirectedGraphNode nd2 = new UndirectedGraphNode(2);
        UndirectedGraphNode nd3 = new UndirectedGraphNode(3);
        nd1.neighbors.add(nd2);
        nd2.neighbors.add(nd1);
        
        nd2.neighbors.add(nd3);
        nd3.neighbors.add(nd2);
        
        nd3.neighbors.add(nd1);
        nd1.neighbors.add(nd3);
        UndirectedGraphNode cloned = cloneGraph(nd1);
        
        Assert.assertEquals(2, cloned.neighbors.size());
        Assert.assertEquals(2, cloned.neighbors.get(0).neighbors.size());
        Assert.assertEquals(2, cloned.neighbors.get(1).neighbors.size());
    }
}

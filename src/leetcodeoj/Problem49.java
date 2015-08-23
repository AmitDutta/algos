package leetcodeoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Problem49 {
   public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      Arrays.sort(strs);
      for (int i = 0; i < strs.length; ++i) {
          char[] chars = strs[i].toCharArray();
          Arrays.sort(chars);
          String s = new String(chars);
          if (!map.containsKey(s)) {
              List<String> lst = new ArrayList<String>();
              lst.add(strs[i]);
              map.put(s, lst);
          }else {
              map.get(s).add(strs[i]);
          }
      }
      List<List<String>> result = new ArrayList<List<String>>();
      for (Map.Entry<String, List<String>> e : map.entrySet()) {
          result.add(e.getValue());
      }
      return result;
   }
}

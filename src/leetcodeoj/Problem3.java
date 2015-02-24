package leetcodeoj;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class Problem3 {

	/* We keep a map with each character of the string and the last index of 
	 * that character in string. The variable last keeps track of last 
	 * occurrence of latest duplicated character. Therefore, current substring
	 * into consideration is always of length i - last. Because, at last current
	 * character is duplicated. Why last is initialized with -1? We process 
	 * first char manually. Last contains index of previous occurrence of 
	 * current char. When we process first char, there is no duplicacy seen
	 * so far, So -1*/
	public int lengthOfLongestSubstring(String s) {
	    if (s.length() == 0) return 0;
		int last = -1;
		int maxLength = 1;
		int start = 0, end = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(s.charAt(0), 0);
		
		for (int i = 1; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) > last) {
					last = map.get(s.charAt(i));
				}
			}
			int currentLength = i - last;
			if (currentLength > maxLength) {
				start = last + 1;
				end = i;
				maxLength = currentLength;
			}
			map.put(s.charAt(i), i);
		}
		//System.out.println(s.substring(start, end + 1));
		return maxLength;
	}

	@Test
	public void lengthOfLongestSubstringTest() {
		Problem3 sln = new Problem3();
		assertEquals(0, sln.lengthOfLongestSubstring(""));
		assertEquals(5, sln.lengthOfLongestSubstring("abcde"));
		assertEquals(1, sln.lengthOfLongestSubstring("bbb"));
		assertEquals(3, sln.lengthOfLongestSubstring("ababc"));
	}	
}

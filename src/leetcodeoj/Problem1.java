package leetcodeoj;
import static org.junit.Assert.assertArrayEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class Problem1 {

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] out = new int[2];
		for (int i = 0; i < numbers.length; ++i) {
			if (map.containsKey(numbers[i])) {
				out[0] = map.get(numbers[i]) + 1;
				out[1] = i + 1;
				break;
			}
			map.put(target - numbers[i], i);
		}
		return out;
	}
	
	@Test
	public void twoSumTest()
	{
		Problem1 sln = new Problem1();
		int[] actual = sln.twoSum(new int[] {2, 7, 11, 15}, 9);
		assertArrayEquals(new int[] {1,  2}, actual); 
	}
}

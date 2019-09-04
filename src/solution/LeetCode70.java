package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode70 {
	public static void main(String[] args) {
		LeetCode70 leetCode70 = new LeetCode70();
		System.out.print(leetCode70.climbStairs(44));
	}

	private Map<Integer, Integer> index2Value = new HashMap<Integer, Integer>();

	public int climbStairs(int n) {
		if (n == 2) {
			return 2;
		}
		if (n == 1) {
			return 1;
		}
		if (!index2Value.containsKey(n)) {
			int value = climbStairs(n - 1) + climbStairs(n - 2);
			index2Value.put(n, value);
			return value;
		} else {
			return index2Value.get(n);
		}
	}
}

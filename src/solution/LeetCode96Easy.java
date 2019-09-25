package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode96Easy {
	public static void main(String[] args) {
		LeetCode96Easy leetCode96 = new LeetCode96Easy();
		System.out.print(leetCode96.numTrees(3));
	}

	public int numTrees(int n) {
		List<Integer> results = new ArrayList<Integer>();
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; i++) {
			results.add(treeNum(1, i - 1, cache) * treeNum(i + 1, n, cache));
		}
		int result = 0;
		for (Integer tmp : results) {
			result += tmp;
		}
		return result;
	}

	public int treeNum(int start, int end, Map<Integer, Integer> cache) {
		if (start >= end) {
			return 1;
		}
		int key = end - start;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		List<Integer> results = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			results.add(treeNum(start, i - 1, cache) * treeNum(i + 1, end, cache));
		}
		int result = 0;
		for (Integer tmp : results) {
			result += tmp;
		}
		cache.put(key, result);
		return result;
	}
}

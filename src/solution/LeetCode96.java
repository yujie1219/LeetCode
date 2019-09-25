package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode96 {
	public static void main(String[] args) {
		LeetCode96 leetCode96 = new LeetCode96();
		System.out.print(leetCode96.numTrees(19));
	}

	public int numTrees(int n) {
		List<Integer> results = new ArrayList<Integer>();
		Map<Range, Integer> cache = new HashMap<LeetCode96.Range, Integer>();
		for (int i = 1; i <= n; i++) {
			results.add(treeNum(1, i - 1, cache) * treeNum(i + 1, n, cache));
		}
		int result = 0;
		for (Integer tmp : results) {
			result += tmp;
		}
		return result;
	}

	public int treeNum(int start, int end, Map<Range, Integer> cache) {
		if (start >= end) {
			return 1;
		}
		Range range = new Range(start, end);
		if (cache.containsKey(range)) {
			return cache.get(range);
		}
		List<Integer> results = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			results.add(treeNum(start, i - 1, cache) * treeNum(i + 1, end, cache));
		}
		int result = 0;
		for (Integer tmp : results) {
			result += tmp;
		}
		cache.put(range, result);
		return result;
	}

	private class Range {
		private int start;
		private int end;

		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Range other = (Range) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		private LeetCode96 getEnclosingInstance() {
			return LeetCode96.this;
		}
	}
}

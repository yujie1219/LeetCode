package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LeetCode56 {
	public static void main(String[] args) {
		LeetCode56 leetCode56 = new LeetCode56();
		int[][] intervals = new int[][] { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		leetCode56.merge(intervals);
	}

	public int[][] merge(int[][] intervals) {
		int length = intervals.length;
		if (length <= 1) {
			return intervals;
		}

		return parse(length, intervals);
	}

	private int[][] parse(int length, int[][] intervals) {
		int[] usedIndex = new int[length];
		List<Integer[]> cache = new ArrayList<Integer[]>();

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int i = 0; i < length; i++) {
			if (usedIndex[i] == 1)
				continue;

			start = intervals[i][0];
			end = intervals[i][1];

			for (int j = i + 1; j < length; j++) {
				if (usedIndex[j] != 1) {
					int tmpStart = intervals[j][0];
					int tmpEnd = intervals[j][1];

					if (tmpStart >= start && tmpEnd <= end) {
						usedIndex[j] = 1;
					}
					if (tmpStart <= start && tmpEnd >= start) {
						start = tmpStart;
						usedIndex[j] = 1;
					}
					if (tmpEnd >= end && tmpStart <= end) {
						end = tmpEnd;
						usedIndex[j] = 1;
					}
				}
			}

			cache.add(new Integer[] { start, end });
			usedIndex[i] = 1;
		}

		int[][] result = new int[cache.size()][2];
		IntStream.range(0, cache.size()).forEach(i -> {
			Integer[] wrapper = cache.get(i);
			result[i] = new int[] { wrapper[0], wrapper[1] };
		});

		if (result.length != intervals.length) {
			return parse(result.length, result);
		} else {
			return result;
		}
	}
}

package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {
	public List<Integer> grayCode(int n) {
		List<Integer> resuList = new ArrayList<Integer>();
		if (n == 0) {
			resuList.add(0);
			return resuList;
		}

		int[] arr = new int[n];
		changeToOne(arr, resuList);

		return resuList;
	}

	private void changeToOne(int[] arr, List<Integer> result) {
		int latest = 0;
		for (int i = 0; i < arr.length; i++) {
			latest += Math.pow(2, i);
		}
		result.add(latest);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 1) {
				arr[i] = 1;
				changeToOne(arr.clone(), result);
			}
		}
	}
}

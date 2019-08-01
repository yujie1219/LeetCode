package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode40 {
	public static void main(String[] args) {
		LeetCode40 leetCode40 = new LeetCode40();
		System.out.print(leetCode40.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> candidatesList = new ArrayList<Integer>();
		int length = candidates.length;
		for (int i = 0; i < length; i++) {
			candidatesList.add(candidates[i]);
		}

		for (int i = 0; i < candidatesList.size(); i++) {
			List<Integer> tmpIntegers = new ArrayList<Integer>();
			tmpIntegers.add(i);
			findTarget(candidatesList, target - candidatesList.get(i), i, result, tmpIntegers);
		}

		return result;
	}

	private void findTarget(List<Integer> candidates, int target, int index, List<List<Integer>> result,
			List<Integer> tmpResult) {
		if (target == 0) {
			List<Integer> element = tmpResult.stream().map(i -> candidates.get(i)).collect(Collectors.toList());
			if (!isExist(result, element))
				result.add(element);
		} else if (target < 0) {

		} else if (target > 0) {
			for (int i = index + 1; i < candidates.size(); i++) {
				List<Integer> tmpIntegers = new ArrayList<Integer>(tmpResult);
				tmpIntegers.add(i);
				findTarget(candidates, target - candidates.get(i), i, result, tmpIntegers);
			}
		}
	}

	private boolean isExist(List<List<Integer>> result, List<Integer> element) {
		boolean exist = false;
		for (int i = 0; i < result.size(); i++) {
			List<Integer> existElement = result.get(i);
			Collections.sort(existElement);
			Collections.sort(element);
			int length = existElement.size();
			if (length == element.size()) {
				int j = 0;
				for (; j < length; j++) {
					if (existElement.get(j) != element.get(j)) {
						break;
					}
				}
				if (j == length) {
					exist = true;
					break;
				}
			}
		}

		return exist;
	}
}

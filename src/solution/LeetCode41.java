package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode41 {
	public static void main(String[] args) {
		LeetCode41 leetCode41 = new LeetCode41();
		System.out.print(leetCode41.firstMissingPositive(new int[] { 1, 2, 3, 10, 2147483647, 9 }));
	}

	public int firstMissingPositive(int[] nums) {
		int max = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		int MaxAddOne = max + 1 > 0 ? max + 1 : max;
		int result = 1;
		Map<Integer, Integer> indexExist = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (nums[i] > 0) {
				indexExist.put(nums[i], 1);
			}
		}
		for (int i = 1; i <= MaxAddOne; i++) {
			if (indexExist.get(i) == null) {
				result = i;
				break;
			}
		}
		return result;
	}
}

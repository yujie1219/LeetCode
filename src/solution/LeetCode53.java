package solution;

public class LeetCode53 {
	public static void main(String[] args) {
		LeetCode53 leetCode53 = new LeetCode53();
		System.out.print(leetCode53.maxSubArray(new int[] { -2, 1, -5, 3 }));
	}

	public int maxSubArray(int[] nums) {
		int elementMax = nums[0];
		int partSum = nums[0] > 0 ? nums[0] : 0;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > elementMax) {
				elementMax = nums[i];
			}

			partSum += nums[i];
			if (partSum > 0) {
				max = max > partSum ? max : partSum;
			} else {
				partSum = 0;
			}
		}

		if (elementMax <= 0) {
			return elementMax;
		}

		return max;
	}
}

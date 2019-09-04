package solution;

public class LeetCode75 {
	public static void main(String[] args) {
		LeetCode75 leetCode75 = new LeetCode75();
		int[] arg = new int[] { 0 };
		leetCode75.sortColors(arg);
		for (int i = 0; i < 2; i++) {
			System.out.print(arg[i] + " ");
		}
	}

	public void sortColors(int[] nums) {
		int length = nums.length;
		int zeroRight = 0;
		int twoLeft = length - 1;
		int current = 0;
		while (current <= twoLeft) {
			if (current < zeroRight) {
				current++;
			} else {
				if (nums[current] == 0) {
					nums[current] = nums[zeroRight];
					nums[zeroRight] = 0;
					zeroRight++;
				} else if (nums[current] == 1) {
					current++;
				} else if (nums[current] == 2) {
					nums[current] = nums[twoLeft];
					nums[twoLeft] = 2;
					twoLeft--;
				}
			}
		}
	}
}

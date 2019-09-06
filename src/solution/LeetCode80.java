package solution;

public class LeetCode80 {
	public static void main(String[] args) {
		LeetCode80 leetCode80 = new LeetCode80();
		System.out.println(leetCode80.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int showTime = 0;
		int currentItem = nums[0];
		int currentEnd = nums.length - 1;
		int start = 0;
		for (int i = start; i <= currentEnd; i++) {
			if (nums[i] == currentItem) {
				showTime++;
				if (showTime > 2) {
					currentEnd = moveToLeft(nums, i, currentEnd);
					currentItem = nums[i];
					showTime = 1;
				}
			} else {
				currentItem = nums[i];
				showTime = 1;
			}
		}

		return currentEnd + 1;
	}

	private int moveToLeft(int[] nums, int receiver, int currentEnd) {
		int start = -1;
		for (int i = receiver + 1; i <= currentEnd; i++) {
			if (nums[i] != nums[receiver]) {
				start = i;
				break;
			}
		}
		if (start == -1) {
			return receiver - 1;
		}
		for (int i = 0; i + start <= currentEnd; i++) {
			nums[receiver + i] = nums[start + i];
		}
		return currentEnd - (start - receiver);
	}
}

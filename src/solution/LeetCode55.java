package solution;

public class LeetCode55 {
	public static void main(String[] args) {
		LeetCode55 leetCode55 = new LeetCode55();
		System.out.print(leetCode55.canJump(new int[] { 0 }));
	}

	int length;
	int[] boomIndex;
	boolean can = false;

	public boolean canJump(int[] nums) {
		this.length = nums.length;
		boomIndex = new int[length];
		for (int i = nums[0]; i >= 0; i--) {
			if (!can) {
				jump(nums, i);
			}
		}

		return can;
	}

	private void jump(int[] nums, int currentIndex) {
		if (can || (currentIndex < length && boomIndex[currentIndex] == 1)) {
			return;
		}
		if (currentIndex >= length - 1 || currentIndex + nums[currentIndex] >= (length - 1)) {
			can = true;
			return;
		}
		for (int i = nums[currentIndex]; i >= 1; i--) {
			if (!this.can) {
				jump(nums, currentIndex + i);
			} else {
				break;
			}
		}
		if (!this.can) {
			boomIndex[currentIndex] = 1;
		}
	}
}

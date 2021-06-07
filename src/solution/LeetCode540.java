package solution;

public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    private int singleNonDuplicate(int[] nums, int start, int end) {
        int length = end - start + 1;

        if (length == 1) {
            return nums[end];
        }

        int half = (start + end) / 2;
        if (half % 2 == 0) {       // 0 - half 长度为奇数
            if (nums[half] == nums[half - 1]) {
                return singleNonDuplicate(nums, start, half - 2);
            } else if (nums[half] == nums[half + 1]) {
                return singleNonDuplicate(nums, half + 2, end);
            } else {
                return nums[half];
            }
        } else {        // 0 - half  长度为偶数
            if (nums[half] == nums[half - 1]) {
                return singleNonDuplicate(nums, half + 1, end);
            } else if (nums[half] == nums[half + 1]) {
                return singleNonDuplicate(nums, start, half - 1);
            } else {
                return nums[half];
            }
        }
    }
}

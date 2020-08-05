package solution;

public class LeetCode153 {
    public int findMin(int[] nums) {
        return findFromInorder(nums, 0, nums.length - 1);
    }

    private int findFromInorder(int[] nums, int begin, int end) {
        if (begin - end == 0) {
            return nums[begin];
        }

        int mid = (begin + end) / 2;

        if (mid == begin) {
            return Math.min(nums[begin], nums[end]);
        }

        if (nums[mid] > nums[begin]) {
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            } else {
                return findFromInorder(nums, mid + 1, end);
            }
        } else {
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else {
                return findFromInorder(nums, begin, mid - 1);
            }
        }
    }
}

package solution;

public class LeetCode81Re {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (target == nums[mid]) {
            return true;
        } else {
            // 右边有序
            if (nums[start] > nums[mid]) {
                return findBinary(nums, mid + 1, end, target) || search(nums, start, mid - 1, target);
            } else if (nums[mid] > nums[end]) {     // 左边有序
                return findBinary(nums, start, mid - 1, target) || search(nums, mid + 1, end, target);
            } else {
                if (nums[start] < nums[mid] && nums[mid] < nums[end]) { // 两边有序
                    return findBinary(nums, start, mid - 1, target) || findBinary(nums, mid + 1, end, target);
                } else {    // 认为两边无序
                    return search(nums, start, mid - 1, target) || search(nums, mid + 1, end, target);
                }
            }
        }
    }

    private boolean findBinary(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return true;
        } else if (target < nums[mid]) {
            return findBinary(nums, start, mid - 1, target);
        } else {
            return findBinary(nums, mid + 1, end, target);
        }
    }
}

package solution;

public class LeetCode153Re {
    public static void main(String[] args) {
        new LeetCode153Re().findMin(new int[]{3, 4, 5, 1, 2});
    }

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start == end || end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }

        int mid = (start + end) / 2;

        if (nums[mid] > nums[start] && nums[mid] < nums[end]) {     // 两边有序
            return nums[start];
        } else if (nums[mid] > nums[start]) {       // 右边无序
            return findMin(nums, mid, end);
        } else {        // 左边有序
            return findMin(nums, start, mid);
        }
    }
}

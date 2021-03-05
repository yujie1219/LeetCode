package solution;

public class LeetCode215 {
    public static void main(String[] args) {
        new LeetCode215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9);
    }

    public int findKthLargest(int[] nums, int k) {
        return nums[sort(nums, 0, nums.length - 1, k)];
    }

    private int sort(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && nums[right] >= nums[left]) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            while (left < right && nums[left] <= nums[right]) {
                left++;
            }

            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }

        int position = nums.length - k;
        if (position == left) {
            return position;
        } else if (position > left) {
            return sort(nums, left + 1, end, k);
        } else {
            return sort(nums, start, left - 1, k);
        }
    }
}

package solution;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums != null) {
            if (nums[0] == target) {
                result[0] = 0;
            }
            if (nums[nums.length - 1] == target) {
                result[1] = nums.length - 1;
            }

            binarySearch(nums, 0, nums.length - 1, result, target);
        }

        return result;
    }

    private void binarySearch(int[] nums, int begin, int end, int[] result, int target) {
        if (end - begin <= 1) {
            return;
        }

        int currentIndex = (begin + end) / 2;
        if (nums[currentIndex] > target) {
            binarySearch(nums, begin, currentIndex - 1, result, target);
        } else if (nums[currentIndex] < target) {
            binarySearch(nums, currentIndex + 1, end, result, target);
        } else {
            int min = currentIndex, max = currentIndex;
            while (min >= 0 && nums[min] == target) {
                min--;
            }
            result[0] = result[0] == -1 ? ++min : result[0];

            while (max < nums.length && nums[max] == target) {
                max++;
            }
            result[1] = result[1] == -1 ? --max : result[1];
        }
    }
}

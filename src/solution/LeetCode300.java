package solution;

public class LeetCode300 {
    public static void main(String[] args) {
        new LeetCode300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }

    public int lengthOfLIS(int[] nums) {
        int result = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result = Math.max(result, maxLengthOfLIS(nums, i, new int[nums.length]));

            if (result == nums.length) {
                break;
            }
        }

        return result;
    }

    private int maxLengthOfLIS(int[] nums, int currentIndex, int[] cache) {
        if (currentIndex == 0) {
            return 1;
        }

        if (cache[currentIndex] != 0) {
            return cache[currentIndex];
        }

        int result = 1;
        for (int i = currentIndex - 1; i >= 0; i--) {
            if (nums[currentIndex] > nums[i]) {
                result = Math.max(result, maxLengthOfLIS(nums, i, cache) + 1);
            }
        }

        cache[currentIndex] = result;

        return result;
    }
}

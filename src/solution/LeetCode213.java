package solution;

public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }

        if (allZero) {
            return 0;
        }

        int maxMoney = 0;
        int[][] cache = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentMax = 0;
            if (i == 0) {
                currentMax = arrangeRob(nums, i, nums.length - 2, cache);
            } else if (i == nums.length - 1) {
                currentMax = arrangeRob(nums, 1, i, cache);
            } else {
                currentMax = Math.max((arrangeRob(nums, 0, i - 2, cache) + arrangeRob(nums, i + 2, nums.length - 2, cache) + nums[i]),
                        (arrangeRob(nums, 1, i - 2, cache) + arrangeRob(nums, i + 2, nums.length - 1, cache) + nums[i]));
            }

            if (currentMax > maxMoney) {
                maxMoney = currentMax;
            }
        }

        return maxMoney;
    }

    private int arrangeRob(int[] nums, int start, int end, int[][] cache) {
        if (start == end) {
            return nums[end];
        } else if (start > end) {
            return 0;
        }

        if (cache[start][end] != 0) {
            return cache[start][end];
        }

        int maxMoney = 0;
        for (int i = start; i <= end; i++) {
            int currentMax = arrangeRob(nums, i + 2, end, cache) + arrangeRob(nums, start, i - 2, cache) + nums[i];
            if (currentMax > maxMoney) {
                maxMoney = currentMax;
            }
        }

        cache[start][end] = maxMoney;

        return maxMoney;
    }
}

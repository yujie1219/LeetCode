package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, nums.length - 1, target);
    }

    private int findTargetSumWays(int[] nums, int index, int target) {
        if (index == 0) {
            if (Math.abs(nums[index]) == Math.abs(target)) {
                return nums[index] == 0 ? 2 : 1;
            } else {
                return 0;
            }
        }

        int num = findTargetSumWays(nums, index - 1, target - nums[index])
                + findTargetSumWays(nums, index - 1, target + nums[index]);

        return num;
    }
}

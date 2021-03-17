package solution;

import java.util.List;

public class LeetCode45 {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            return jumpToLast(nums, 0, new int[nums.length]);
        }
    }

    private int jumpToLast(int[] nums, int currentIndex, int[] cache) {
        int current = nums[currentIndex];
        if (current + currentIndex >= nums.length - 1) {
            return 1;
        }

        if (cache[currentIndex] != 0) {
            return cache[currentIndex];
        }

        int minRoad = Integer.MAX_VALUE;
        for (int i = 1; i <= current && i + currentIndex < nums.length; i++) {
            int index = currentIndex + i;
            int result = jumpToLast(nums, index, cache);
            if (result != Integer.MAX_VALUE) {
                minRoad = Math.min(minRoad, result + 1);
            }
        }

        cache[currentIndex] = minRoad;
        return minRoad;
    }
}

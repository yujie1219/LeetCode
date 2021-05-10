package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int summary = Arrays.stream(nums).sum();

        if (summary % 2 == 0) {
            Arrays.sort(nums);
            int half = summary / 2;

            return findTarget(nums, new ArrayList<>(), half);
        }

        return false;
    }

    private boolean findTarget(int[] nums, List<Integer> used, int target) {
        if (target == 0) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i) && target - nums[i] >= 0) {
                used.add(i);
                if (findTarget(nums, used, target - nums[i])) {
                    return true;
                }

                used.remove(used.size() - 1);
            }
        }

        return false;
    }
}

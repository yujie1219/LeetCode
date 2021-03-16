package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode698 {
    public static void main(String[] args) {
        new LeetCode698().canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k == 0) {
            Arrays.sort(nums);
            int eachBlock = sum / k;
            List<Integer> used = new ArrayList<>();

            return findBlock(nums, eachBlock, used, new int[k]);
        } else {
            return false;
        }
    }

    private boolean findBlock(int[] nums, int target, List<Integer> used, int[] group) {
        if (used.size() == nums.length) {
            return true;
        }

        for (int j = 0; j < group.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (!used.contains(i) && group[j] + nums[i] <= target) {
                    used.add(i);
                    group[j] = group[j] + nums[i];
                    if (findBlock(nums, target, used, group)) {
                        return true;
                    }
                    used.remove(used.size() - 1);
                    group[j] = group[j] - nums[i];
                }
            }
        }
        return false;
    }
}

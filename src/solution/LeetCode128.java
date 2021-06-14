package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int tempMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                tempMax++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                max = Math.max(max, tempMax);
                tempMax = 1;
            }
        }

        return max;
    }
}

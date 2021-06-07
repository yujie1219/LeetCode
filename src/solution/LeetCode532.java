package solution;

import javafx.scene.chart.AreaChartBuilder;

import java.util.Arrays;

public class LeetCode532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; ) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == current) {
                    if (k == 0) {
                        result++;
                    }

                    while (j < nums.length && nums[j] == current) {
                        j++;
                    }

                }

                if (j < nums.length) {
                    current = nums[j];
                    if (nums[j] - nums[i] == k) {
                        result++;
                        break;
                    } else if (nums[j] - nums[i] > k) {
                        break;
                    }
                }
            }

            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return result;
    }
}

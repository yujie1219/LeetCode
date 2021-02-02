package solution;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode198 {
    public static void main(String[] args) {
        new LeetCode198().rob(new int[]{2, 1, 1, 2});
    }

    public int rob(int[] nums) {
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

        Integer maxProfit = 0;
        int[][] record = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxProfit = Math.max(maxProfit, planRob(nums, 0, i - 2, record) + planRob(nums, i + 2, nums.length - 1, record) + nums[i]);
        }

        return maxProfit;
    }


    private int planRob(int[] nums, int start, int end, int[][] record) {
        if (start >= nums.length || end < 0 || start > end) {
            return 0;
        }

        if (start == end) {
            return nums[start];
        }


        if (record[start][end] != 0) {
            return record[start][end];
        }

        Integer maxProfit = 0;
        for (int i = start; i <= end; i++) {
            maxProfit = Math.max(maxProfit, planRob(nums, start, i - 2, record) + planRob(nums, i + 2, end, record) + nums[i]);
        }

        record[start][end] = maxProfit;
        return maxProfit;
    }
}

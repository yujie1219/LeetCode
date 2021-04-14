package solution;

public class LeetCode376 {
    // dp[0][i]  代表 nums[i] 与上一个数的差值为负数时，最长的情况
    // dp[1][i]  代表 nums[i] 与上一个数的差值为正数时，最长的情况
    // if nums[i] - nums[j] > 0   => dp[1][i] = dp[0][j] + 1
    // else if nums[i] - nums[j] < 0 => dp[0][i] = dp[1][j] +1
    // else => dp[0][i] = 1

    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 1;
        dp[1][0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            dp[0][i] = 1;
            dp[1][i] = 1;

            for (int j = 0; j < i; j++) {
                if (current - nums[j] > 0) {
                    dp[1][i] = Math.max(dp[1][i], dp[0][j] + 1);
                } else if (current - nums[j] < 0) {
                    dp[0][i] = Math.max(dp[0][i], dp[1][j] + 1);
                }
            }

            max = Math.max(max, Math.max(dp[1][i], dp[0][i]));
        }

        return max;
    }
}

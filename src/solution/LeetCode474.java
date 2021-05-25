package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode474 {
    public static void main(String[] args) {
        System.out.println(new LeetCode474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m + 1][n + 1][strs.length];

        return findMaxForm(dp, strs, m, n, 0);
    }

    private int findMaxForm(int[][][] dp, String[] strs, int m, int n, int current) {
        if ((m == 0 && n == 0) || current >= strs.length) {
            return 0;
        }

        if (dp[m][n][current] != 0) {
            return dp[m][n][current];
        }

        int temp = 0;
        if (current != 0) {
            dp[m][n][current] = dp[m][n][current - 1];
        }
        for (int i = current; i < strs.length; i++) {
            int[] nums = getZeroOneNum(strs[i]);
            if (nums[0] <= m && nums[1] <= n) {
                temp = Math.max(temp, findMaxForm(dp, strs, m - nums[0], n - nums[1], i + 1) + 1);

            }
        }

        dp[m][n][current] = temp;
        return temp;
    }

    private int[] getZeroOneNum(String str) {
        int[] nums = new int[2];
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                nums[0]++;
            } else {
                nums[1]++;
            }
        }

        return nums;
    }
}

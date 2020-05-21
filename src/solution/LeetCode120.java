package solution;

import java.util.List;

public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int i = triangle.size();
        if (i == 0) {
            return 0;
        }

        int j = triangle.get(i - 1).size();
        if (j == 0) {
            return 0;
        }

        int[][] dp = new int[i][j];
        dp[0][0] = triangle.get(0).get(0);

        minTotal(triangle, 1, 0, dp);
        minTotal(triangle, 1, 1, dp);

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < j; k++) {
            min = Math.min(dp[i - 1][k], min);
        }

        return min;
    }

    // dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j)
    private void minTotal(List<List<Integer>> triangle, int tIndex, int index, int[][] dp) {
        if (triangle.size() == tIndex || dp[tIndex][index] != 0) {
            return;
        }

        List<Integer> current = triangle.get(tIndex);

        if (index == 0) {
            dp[tIndex][index] = dp[tIndex - 1][index] + current.get(index);
        } else if (index == current.size() - 1) {
            dp[tIndex][index] = dp[tIndex - 1][index - 1] + current.get(index);
        } else {
            dp[tIndex][index] = Math.min(dp[tIndex - 1][index], dp[tIndex - 1][index - 1]) + current.get(index);
        }

        minTotal(triangle, tIndex + 1, index, dp);
        if (index == current.size() - 1) {
            minTotal(triangle, tIndex + 1, index + 1, dp);
        }
    }
}

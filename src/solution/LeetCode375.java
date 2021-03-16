package solution;

public class LeetCode375 {
    public int getMoneyAmount(int n) {
        int[][] cache = new int[n][n];
        return findMoneyAmount(1, n, cache);
    }

    private int findMoneyAmount(int i, int j, int[][] cache) {
        if (i >= j) {
            return 0;
        }

        if (j - i == 1) {
            return i;
        }

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int result = Integer.MAX_VALUE;
        for (int k = (i + j) / 2; k <= j; k++) {
            int temp = k + Math.max(findMoneyAmount(k + 1, j, cache), findMoneyAmount(i, k - 1, cache));
            result = Math.min(result, temp);
        }

        cache[i][j] = result;

        return result;
    }
}

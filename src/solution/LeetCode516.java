package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode516 {

    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s, 0, s.length() - 1, new int[s.length()][s.length()]);
    }

    private int longestPalindromeSubseq(String s, int start, int end, int[][] dp) {
        if (start == end) {
            return 1;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int max = 0;
        for (int i = start; i <= end; i++) {
            int j = end;
            while (i < j && s.charAt(j) != s.charAt(i)) {
                j--;
            }

            if (i < j) {
                if (j - i + 1 > max) {
                    max = Math.max(max, longestPalindromeSubseq(s, i + 1, j - 1, dp) + 2);
                }
            } else {
                max = Math.max(max, 1);
            }
        }

        dp[start][end] = max;
        return max;
    }
}

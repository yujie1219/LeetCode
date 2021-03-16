package solution;

public class LeetCode995 {
    // 思想是 以 A[i-k]的值代表当前位置是否反转过，如果反转过，则>1, 而每次反转currentRevCount 和 result都会+1
    // 如果i-K反转过，那么当前i的反转次数就是currentRevCount - 1, 如果A[i] + currentRevCount 为奇数，则代表A[i]实际的值为1
    public int minKBitFlips(int[] A, int K) {
        int result = 0;
        int currentRevCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (i >= K && A[i - K] > 1) {
                currentRevCount--;
                A[i - K] -= 2;
            }
            if ((A[i] + currentRevCount) % 2 == 0) {
                if (i + K - 1 >= A.length) {
                    return -1;
                }
                result++;
                currentRevCount++;
                A[i] += 2;
            }
        }

        return result;
    }
}

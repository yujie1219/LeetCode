package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1011 {
    public int shipWithinDays(int[] weights, int D) {
        int length = weights.length;
        int[] cache = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                cache[i] = weights[0];
            } else {
                cache[i] = weights[i] + cache[i - 1];
            }
        }

        return shipWithinDays(weights, 0, D, cache, new int[length][D + 1]);
    }

    private int shipWithinDays(int[] weights, int start, int D, int[] cache, int[][] foo) {
        if (D == 1) {
            int sum = 0;
            for (int i = start; i < weights.length; i++) {
                sum += weights[i];
            }

            return sum;
        }

        if (foo[start][D] != 0) {
            return foo[start][D];
        }

        int sum = Integer.MAX_VALUE;
        for (int i = start; i <= weights.length - D; i++) {
            int temp = Math.max(cache[i] - cache[start] + weights[start], shipWithinDays(weights, i + 1, D - 1, cache, foo));

            sum = Math.min(temp, sum);
        }

        foo[start][D] = sum;
        return sum;
    }
}

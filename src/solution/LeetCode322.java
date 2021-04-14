package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int result = find(coins, amount, new HashMap<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int find(int[] coins, int remain, Map<Integer, Integer> cache) {
        if (remain == 0) {
            return 0;
        }

        if (cache.containsKey(remain)) {
            return cache.get(remain);
        }

        int result = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (remain - coins[i] >= 0) {
                int temp = find(coins, remain - coins[i], cache);
                if (temp != Integer.MAX_VALUE) {
                    result = Math.min(temp + 1, result);
                }
            }
        }

        cache.put(remain, result);
        return result;
    }
}

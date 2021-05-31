package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode518 {
    int result = 0;

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        change(amount, 0, coins, new HashMap<>());

        return result;
    }

    private int change(int target, int start, int[] coins, Map<String, Integer> cache) {
        String key = target + "+" + start;
        if (cache.containsKey(key)) {
            result += cache.get(key);
            return cache.get(key);
        }

        if (target < 0) {
            return 0;
        }

        if (target == 0) {
            result++;
            return 1;
        }

        int sum = 0;
        for (int i = start; i < coins.length; i++) {
            sum += change(target - coins[i], i, coins, cache);
        }

        cache.put(key, sum);
        return sum;
    }
}

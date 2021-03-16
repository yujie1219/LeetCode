package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        int result = 1;
        int[] cache = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            result = Math.max(result, findMax(envelopes, i, cache));
        }

        return result;
    }

    private int findMax(int[][] envelopes, int currentIndex, int[] cache) {
        if (cache[currentIndex] != 0) {
            return cache[currentIndex];
        }

        int currentWide = envelopes[currentIndex][0];
        int currentHeight = envelopes[currentIndex][1];

        int tempResult = 0;
        for (int i = 0; i < envelopes.length; i++) {
            if (currentWide < envelopes[i][0] && currentHeight < envelopes[i][1]) {
                tempResult = Math.max(tempResult, findMax(envelopes, i, cache));
            }
        }

        cache[currentIndex] = tempResult + 1;
        return tempResult + 1;
    }
}

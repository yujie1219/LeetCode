package solution;

public class LeetCode746Re {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length >= 2) {
            int[] cache = new int[cost.length];
            return Math.min(minCost(cost, cost.length - 1, cache), minCost(cost, cost.length - 2, cache));
        }

        return 0;
    }

    private int minCost(int[] cost, int currentIndex, int[] cache) {
        if (currentIndex < 0) {
            return Integer.MAX_VALUE;
        }

        if (currentIndex == 0 || currentIndex == 1) {
            return cost[currentIndex];
        }

        if (cache[currentIndex] != 0) {
            return cache[currentIndex];
        }

        int minCost = Math.min(minCost(cost, currentIndex - 1, cache), minCost(cost, currentIndex - 2, cache)) + cost[currentIndex];

        cache[currentIndex] = minCost;
        return minCost;
    }
}

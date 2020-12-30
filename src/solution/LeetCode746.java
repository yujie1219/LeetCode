package solution;

public class LeetCode746 {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length >= 2) {
            int[] d = new int[cost.length];
            d[0] = cost[0];
            d[1] = cost[1];

            for (int i = 2; i < cost.length; i++) {
                d[i] = Math.min(d[i - 1] + cost[i], d[i - 2] + cost[i]);
            }

            return Math.min(d[cost.length - 2], d[cost.length - 1]);
        }

        return 0;
    }
}

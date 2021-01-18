package solution;

public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        int[] haveMax = new int[prices.length];
        int[] notHaveMax = new int[prices.length];
        findMaxProfit(prices, fee, 0, haveMax, notHaveMax);
        return Math.max(haveMax[prices.length - 1], notHaveMax[prices.length - 1]);
    }

    private static void findMaxProfit(int[] prices, int fee, int index, int[] haveMax, int[] notHaveMax) {
        if (index >= prices.length) {
            return;
        }

        if (index == 0) {
            haveMax[index] = 0 - prices[index];
            notHaveMax[index] = 0;
        } else {
            haveMax[index] = Math.max(haveMax[index - 1], notHaveMax[index - 1] - prices[index]);
            notHaveMax[index] = Math.max(notHaveMax[index - 1], haveMax[index - 1] + prices[index] - fee);
        }

        findMaxProfit(prices, fee, ++index, haveMax, notHaveMax);
    }
}

package solution;

public class LeetCode309 {
    public int maxProfit(int[] prices) {
        int[] keep = new int[prices.length];
        int[] unKeep = new int[prices.length];
        int[] unKeepButFreezing = new int[prices.length];

        keep[0] = -prices[0];
        unKeep[0] = 0;
        unKeepButFreezing[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            keep[i] = Math.max(keep[i - 1], unKeep[i - 1] - prices[i]);
            unKeep[i] = Math.max(unKeep[i - 1], unKeepButFreezing[i - 1]);
            unKeepButFreezing[i] = keep[i - 1] + prices[i];
        }

        return Math.max(unKeep[prices.length - 1], unKeepButFreezing[prices.length - 1]);
    }
}

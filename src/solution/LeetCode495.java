package solution;

public class LeetCode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;

        if (timeSeries.length > 0) {
            int start = timeSeries[0];
            int end = timeSeries[0] + duration - 1;

            for (int i = 1; i < timeSeries.length; i++) {
                if (timeSeries[i] > end) {
                    sum += end - start + 1;
                    start = timeSeries[i];
                }
                end = timeSeries[i] + duration - 1;
            }

            sum += end - start + 1;
        }

        return sum;
    }
}

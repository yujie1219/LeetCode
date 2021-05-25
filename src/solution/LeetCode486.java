package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode486 {
    public static void main(String[] args) {
        new LeetCode486().PredictTheWinner(new int[]{1, 5, 233, 7});
    }

    public boolean PredictTheWinner(int[] nums) {
        int[] preSum = getPreSum(nums);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append('0');
        }

        return PredictTheWinner(nums, preSum, 0, nums.length - 1, 0, 0, stringBuilder.toString(), new HashMap<>());
    }

    public boolean PredictTheWinner(int[] nums, int[] preSum, int leftBorder, int rightBorder, int sum1, int sum2, String currentChoice, Map<String, Boolean> cache) {
        if (cache.containsKey(currentChoice)) {
            return cache.get(currentChoice);
        }

        if (leftBorder + 1 == rightBorder) {
            boolean result = (sum1 + nums[leftBorder] >= sum2 + nums[rightBorder]) || (sum1 + nums[rightBorder] >= sum2 + nums[leftBorder]);
            cache.put(currentChoice, result);
            return result;
        }

        if (leftBorder == rightBorder) {
            boolean result = sum1 + nums[leftBorder] >= sum2;
            cache.put(currentChoice, result);
            return result;
        }

        int remainScore = preSum[rightBorder] - preSum[leftBorder] + nums[leftBorder];
        if (sum1 + remainScore < sum2) {
            cache.put(currentChoice, false);
            return false;
        }

        if (sum2 + remainScore <= sum1) {
            return true;
        }

        StringBuilder stringBuilder = new StringBuilder(currentChoice);
        stringBuilder.setCharAt(leftBorder, '1');
        stringBuilder.setCharAt(leftBorder + 1, '2');
        boolean whenCatchLeft = PredictTheWinner(nums, preSum, leftBorder + 2, rightBorder, sum1 + nums[leftBorder], sum2 + nums[leftBorder + 1], stringBuilder.toString(), cache);

        stringBuilder = new StringBuilder(currentChoice);
        stringBuilder.setCharAt(leftBorder, '1');
        stringBuilder.setCharAt(rightBorder, '2');
        whenCatchLeft = whenCatchLeft && PredictTheWinner(nums, preSum, leftBorder + 1, rightBorder - 1, sum1 + nums[leftBorder], sum2 + nums[rightBorder], stringBuilder.toString(), cache);
        if (whenCatchLeft) {
            return true;
        }

        stringBuilder = new StringBuilder(currentChoice);
        stringBuilder.setCharAt(rightBorder, '1');
        stringBuilder.setCharAt(rightBorder - 1, '2');
        boolean whenCatchRight = PredictTheWinner(nums, preSum, leftBorder, rightBorder - 2, sum1 + nums[rightBorder], sum2 + nums[rightBorder - 1], stringBuilder.toString(), cache);

        stringBuilder = new StringBuilder(currentChoice);
        stringBuilder.setCharAt(rightBorder, '1');
        stringBuilder.setCharAt(leftBorder, '2');
        whenCatchRight = whenCatchRight && PredictTheWinner(nums, preSum, leftBorder + 1, rightBorder - 1, sum1 + nums[rightBorder], sum2 + nums[leftBorder], stringBuilder.toString(), cache);
        cache.put(currentChoice, whenCatchRight);
        return whenCatchRight;
    }

    private int[] getPreSum(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        return preSum;
    }

}

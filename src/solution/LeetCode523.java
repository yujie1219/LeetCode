package solution;

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }

        int[] preSum = new int[nums.length];
        if (getPreSum(nums, preSum)) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (preSum[j] - preSum[i] + nums[i] < k) {
                    break;
                }

                if ((preSum[j] - preSum[i] + nums[i]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean getPreSum(int[] nums, int[] preSum) {
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0) {
                return true;
            }
            preSum[i] = nums[i] + preSum[i - 1];
        }

        return false;
    }
}

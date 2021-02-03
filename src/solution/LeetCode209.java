package solution;

public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int currentMinLength = Integer.MAX_VALUE;
        int currentResult = 0;

        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (currentResult < s) {
                currentResult += nums[j++];
            } else {
                int currentLength = j - i;
                if (currentLength < currentMinLength) {
                    currentMinLength = currentLength;
                }
                currentResult -= nums[i++];
            }
        }

        if (currentResult >= s) {
            while (i < nums.length && currentResult >= s) {
                currentResult -= nums[i++];
            }

            int currentLength = j - i + 1;
            if (currentMinLength > currentLength) {
                currentMinLength = currentLength;
            }
        }

        return currentMinLength == Integer.MAX_VALUE ? 0 : currentMinLength;
    }

}

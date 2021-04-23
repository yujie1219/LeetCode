package solution;

public class LeetCode396 {
    public int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;

        int n = 0;
        int length = nums.length;
        while (n < length) {
            int temp = 0;
            for (int i = 0; i < length; i++) {
                temp += ((n + i) % length) * nums[i];
            }

            max = Math.max(temp, max);
            n++;
        }

        return max;
    }
}

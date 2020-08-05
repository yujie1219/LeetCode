package solution;

public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        int i = 1;
        int result = max[0];
        while (i < nums.length) {
            int current = nums[i];
            max[i] = Math.max(current, Math.max(current * max[i - 1], current * min[i - 1]));
            min[i] = Math.min(current, Math.min(current * max[i - 1], current * min[i - 1]));

            result = Math.max(max[i], result);

            i++;
        }

        return result;
    }
}

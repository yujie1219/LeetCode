package solution;

public class LeetCode307 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{7, 2, 7, 2, 0});
        numArray.update(4,6);
        numArray.update(0,2);
        numArray.update(0,9);
    }

    static class NumArray {
        int[] difference;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            if (nums.length != 0) {
                this.difference = new int[nums.length];
                this.difference[0] = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    this.difference[i] = nums[i] - nums[i - 1];
                }
            }
        }

        public void update(int index, int val) {
            int k = val - this.nums[index];
            this.nums[index] = val;
            this.difference[index] = this.difference[index] + k;
            if (index < difference.length - 1) {
                this.difference[index + 1] = this.difference[index + 1] - k;
            }
        }

        public int sumRange(int left, int right) {
            int result = 0;
            for (int i = 1; i < left; i++) {
                result += (right - left + 1) * this.difference[i];
            }

            for (int i = right; i >= left; i--) {
                result += (right + 1 - i) * this.difference[i];
            }
            return result;
        }
    }
}

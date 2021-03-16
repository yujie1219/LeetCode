package solution;

public class LeetCode303 {
    class NumArray {
        int[] nums;
        int[] preSum;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.initPreSum();
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return preSum[j];
            } else {
                return preSum[j] - preSum[i - 1];
            }
        }

        private void initPreSum() {
            this.preSum = new int[this.nums.length];
            if (this.nums.length >= 1) {
                this.preSum[0] = this.nums[0];
                for (int i = 1; i < this.preSum.length; i++) {
                    this.preSum[i] = this.preSum[i - 1] + this.nums[i];
                }
            }
        }
    }
}

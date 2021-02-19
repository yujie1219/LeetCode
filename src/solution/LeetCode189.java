package solution;

public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int mod = (k % length);
        rotate(nums, 0, length - 1);
        rotate(nums, 0, mod - 1);
        rotate(nums, mod, length - 1);
    }


    private void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}

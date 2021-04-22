package solution;

public class LeetCode27 {
    public static void main(String[] args) {
        new LeetCode27().removeElement(new int[]{3, 3}, 5);
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (i < nums.length && nums[i] != val) {
                i++;
            }

            if (i >= j) {
                break;
            }

            while (j >= 0 && nums[j] == val) {
                j--;
            }

            if (i >= j) {
                break;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return i;
    }
}

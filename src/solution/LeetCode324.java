package solution;

public class LeetCode324 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 2, 2, 3, 1};
        new LeetCode324().wiggleSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }

    public void wiggleSort(int[] nums) {
        fastSort(nums, 0, nums.length - 1);
        int[] result = new int[nums.length];

        int bigNum = nums.length / 2;

        int i = nums.length - 1 - bigNum;
        int j = nums.length - 1;

        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                result[k] = nums[i--];
            } else {
                result[k] = nums[j--];
            }
        }

        for (int k = 0; k < nums.length; k++) {
            nums[k] = result[k];
        }
    }

    private void fastSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int foundation = nums[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (nums[j] >= foundation && i < j) {
                j--;
            }

            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }

            while (nums[i] <= foundation && i < j) {
                i++;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        fastSort(nums, start, i - 1);
        fastSort(nums, i + 1, end);
    }
}

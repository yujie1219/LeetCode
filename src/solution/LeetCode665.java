package solution;

public class LeetCode665 {
    public boolean checkPossibility(int[] nums) {
        int needChange = 0;
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] > nums[index + 1]) {
                needChange++;

                if (!canChange(nums, index)) {
                    if (!canChange(nums, index + 1)) {
                        return false;
                    } else {
                        index++;
                    }
                }

                if (needChange == 2) {
                    return false;
                }
            }

            index++;
        }

        return true;
    }

    private boolean canChange(int[] nums, int index) {
        if (index == 0) {
            return true;
        }

        if (index == nums.length - 1) {
            return true;
        }

        if (nums[index - 1] > nums[index + 1]) {
            return false;
        }

        return true;
    }
}

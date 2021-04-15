package solution;

public class LeetCode80Re {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int extend = 0;
        int i = 1;
        int currentValue = nums[0];
        int currentNum = 1;
        int result = 0;
        while (i + extend < n) {
            nums[i] = nums[i + extend];
            if (nums[i] == currentValue) {
                currentNum++;
            } else {
                currentValue = nums[i];
                currentNum = 1;
            }

            if (currentNum >= 3) {
                while (i + extend < n && nums[i + extend] == currentValue) {
                    extend++;
                }

                if (i + extend == n) {
                    break;
                }
            } else {
                i++;
            }
        }

        return i;
    }
}

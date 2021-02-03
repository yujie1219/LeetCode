package solution;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                continue;
            }

            for (int j = 1; j <= zeroNum; j++) {
                nums[i - j] = nums[i];
            }
        }

        while (zeroNum != 0) {
            nums[nums.length - zeroNum] = 0;
            zeroNum--;
        }
    }
}

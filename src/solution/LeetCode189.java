package solution;

public class LeetCode189 {
    // 此解法错误，应该翻转两次数组
    public void rotate(int[] nums, int k) {
        int currentIndex = nums.length - k;
        int covered = 0;
        while (currentIndex < nums.length) {
            int needCovered = currentIndex - nums.length + k;
            covered = nums[needCovered];
            nums[needCovered] = nums[currentIndex];

            while (needCovered + k <= currentIndex) {
                needCovered += k;
                int temp = nums[needCovered];
                nums[needCovered] = covered;
                covered = temp;
            }

            currentIndex++;
        }
    }
}

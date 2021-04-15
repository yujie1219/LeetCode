package solution;

public class LeetCode334 {

    // 使用两个变量A、B, 当前数小于A时更新A， 如果大于A切小于B则更新B， 如果大于A且大于B 则返回true
    // 这代表A时最小值，B是次小值， 更新A不更新B代表着 B之前有比B更小的数，因此如果存在C 比B大也是可以的
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
            } else if (nums[i] <= b) {
                b = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}

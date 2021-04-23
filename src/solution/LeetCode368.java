package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode368 {
    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        new LeetCode368().largestDivisibleSubset(new int[]{1, 2, 3});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < result.size()) {
                break;
            }

            temp.add(nums[i]);
            largestDivisibleSubset(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }

        return result;
    }

    private void largestDivisibleSubset(int[] nums, int startIndex, List<Integer> temp) {
        if (startIndex >= nums.length) {
            if (temp.size() > result.size()) {
                result = new ArrayList<>(temp);
            }
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (nums.length - startIndex + temp.size() < result.size()) {
                break;
            }

            if (nums[i] % temp.get(temp.size() - 1) == 0) {
                temp.add(nums[i]);
                largestDivisibleSubset(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }

        if (temp.size() > result.size()) {
            result = new ArrayList<>(temp);
        }

    }
}

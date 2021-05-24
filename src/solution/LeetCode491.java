package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (repeat(nums, i, 0)) {
                continue;
            }

            temp.add(nums[i]);
            findSubsequences(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }

        return result;
    }

    public void findSubsequences(int[] nums, int start, List<List<Integer>> result, List<Integer> temp) {
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (temp.get(temp.size() - 1) > nums[i] || repeat(nums, i, start)) {
                continue;
            }

            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            findSubsequences(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean repeat(int[] nums, int current, int start) {
        for (int i = start; i < current; i++) {
            if (nums[current] == nums[i]) {
                return true;
            }
        }

        return false;
    }
}

package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode90 {

    public static void main(String[] args) {
        new LeetCode90().subsetsWithDup(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        new LeetCode90().subset(nums, new ArrayList<>(), results, 0);

        return results;
    }

    private void subset(int[] nums, List<Integer> result, List<List<Integer>> results, int startIndex) {

        for (int i = startIndex; i < nums.length; i++) {
            result.add(nums[i]);
            if (!isExist(results, result)) {
                List<Integer> tmpResult = new ArrayList<>(result);
                results.add(tmpResult);
            }

            subset(nums, result, results, i + 1);
            result.remove(result.size() - 1);
        }
    }


    private boolean isExist(List<List<Integer>> results, List<Integer> target) {
        boolean isExist = false;

        for (List<Integer> result : results) {
            if (result.size() != target.size()) {
                continue;
            }

            boolean isSame = true;
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) != target.get(i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                isExist = true;
                break;
            }
        }

        return isExist;
    }
}

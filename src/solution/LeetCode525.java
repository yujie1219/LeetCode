package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode525 {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }

        Map<Integer, List<Integer>> sum2IndexList = new HashMap<>();
        int max = 0;

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += getNum(nums[i]);

            if (!sum2IndexList.containsKey(sum)) {
                sum2IndexList.put(sum, new ArrayList<>());
            }

            sum2IndexList.get(sum).add(i);
        }

        for (int key : sum2IndexList.keySet()) {
            List<Integer> indexList = sum2IndexList.get(key);
            if (key == 0) {
                max = Math.max(max, indexList.get(indexList.size() - 1));
            } else {
                max = Math.max(max, indexList.get(indexList.size() - 1) - indexList.get(0));
            }
        }

        return max;
    }

    private int getNum(int num) {
        return num == 0 ? 1 : -1;
    }

}

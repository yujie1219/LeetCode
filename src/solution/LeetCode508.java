package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode508 {
    int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Map<Integer, Integer> sum2Num = new HashMap<>();
        findFrequentTreeSum(root, sum2Num);

        List<Integer> result = new ArrayList<>();
        for (Integer key : sum2Num.keySet()) {
            if (sum2Num.get(key) == max) {
                result.add(key);
            }
        }

        return result.stream().mapToInt(item -> item).toArray();
    }

    public int findFrequentTreeSum(TreeNode current, Map<Integer, Integer> sum2Num) {
        int sum = current.val;

        if (current.left != null) {
            sum += findFrequentTreeSum(current.left, sum2Num);
        }

        if (current.right != null) {
            sum += findFrequentTreeSum(current.right, sum2Num);
        }

        if (!sum2Num.containsKey(sum)) {
            sum2Num.put(sum, 0);
        }

        int num = sum2Num.get(sum) + 1;
        max = Math.max(max, num);
        sum2Num.put(sum, num);

        return sum;
    }
}

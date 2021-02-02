package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> results = new ArrayList<>();
        Integer height = getRank(root);
        Integer max = ((int) Math.pow(2, height)) - 1;

        for (int i = 0; i < height; i++) {
            List<String> result = new ArrayList<>();
            for (int j = 0; j < max; j++) {
                result.add("");
            }
            results.add(result);
        }

        fillResults(root, results, 0, max - 1, 0);
        return results;
    }

    private void fillResults(TreeNode current, List<List<String>> results, Integer start, Integer end, Integer level) {
        List<String> result = results.get(level);
        Integer middle = (start + end) / 2;
        result.set(middle, current.val + "");

        if (current.left != null) {
            fillResults(current.left, results, start, middle - 1, level + 1);
        }

        if (current.right != null) {
            fillResults(current.right, results, middle + 1, end, level + 1);
        }
    }

    private Integer getRank(TreeNode current) {
        if (current.right == null && current.left == null) {
            return 1;
        }

        Integer leftLevel = 0;
        if (current.left != null) {
            leftLevel = getRank(current.left);
        }

        Integer rightLevel = 0;
        if (current.right != null) {
            rightLevel = getRank(current.right);
        }

        return Math.max(rightLevel, leftLevel) + 1;
    }
}

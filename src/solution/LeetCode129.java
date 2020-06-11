package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode129 {

    public int sumNumbers(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        if (root != null) {
            getVals(root, "", results);
        }

        int result = 0;
        for (Integer val : results) {
            result += val;
        }

        return result;
    }

    private void getVals(TreeNode current, String val, List<Integer> results) {
        val += current.val;
        if (current.left == null && current.right == null) {
            results.add(Integer.valueOf(val));
            return;
        }

        if (current.left != null) {
            getVals(current.left, val, results);
        }

        if (current.right != null) {
            getVals(current.right, val, results);
        }
    }
}

package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxList = new ArrayList<>();

        if (root != null) {
            largestValues(root, maxList, 0);
        }

        return maxList;
    }

    private void largestValues(TreeNode current, List<Integer> maxList, int level) {
        if (maxList.size() == level) {
            maxList.add(Integer.MIN_VALUE);
        }

        maxList.set(level, Math.max(maxList.get(level), current.val));

        if (current.left != null) {
            largestValues(current.left, maxList, level + 1);
        }

        if (current.right != null) {
            largestValues(current.right, maxList, level + 1);
        }
    }
}

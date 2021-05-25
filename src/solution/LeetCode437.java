package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode437 {
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }

        TreeNode preSum = new TreeNode();
        getPreSum(root, preSum, 0);
        getRoad(preSum, new ArrayList<>(), targetSum);

        return result;
    }

    private void getRoad(TreeNode preSum, List<Integer> needRemove, int targetSum) {
        int val = preSum.val;
        if (val == targetSum) {
            result++;
        }

        for (int element : needRemove) {
            if (val - element == targetSum) {
                result++;
            }
        }

        if (preSum.left != null) {
            needRemove.add(val);
            getRoad(preSum.left, needRemove, targetSum);
            needRemove.remove(needRemove.size() - 1);
        }

        if (preSum.right != null) {
            needRemove.add(val);
            getRoad(preSum.right, needRemove, targetSum);
            needRemove.remove(needRemove.size() - 1);
        }
    }

    private void getPreSum(TreeNode root, TreeNode preSum, int parentSum) {
        preSum.val = root.val + parentSum;

        if (root.left != null) {
            preSum.left = new TreeNode();
            getPreSum(root.left, preSum.left, preSum.val);
        }

        if (root.right != null) {
            preSum.right = new TreeNode();
            getPreSum(root.right, preSum.right, preSum.val);
        }
    }
}

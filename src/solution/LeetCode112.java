package solution;

import model.TreeNode;

public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return findPathSum(root, sum);
    }

    public boolean findPathSum(TreeNode current, int currentSum) {
        if (current.left == null && current.right == null) {
            return currentSum - current.val == 0;
        }

        boolean left = false;
        if (current.left != null) {
            left = findPathSum(current.left, currentSum - current.val);
        }

        boolean right = false;
        if (current.right != null) {
            right = findPathSum(current.right, currentSum - current.val);
        }

        return right || left;
    }
}

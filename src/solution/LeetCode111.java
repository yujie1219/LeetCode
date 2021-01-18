package solution;

import model.TreeNode;

public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findMinDepth(root, 1);
    }

    public int findMinDepth(TreeNode current, int depth) {
        if (current.right == null && current.left == null) {
            return depth;
        }

        int tmpMinDepth = Integer.MAX_VALUE;
        if (current.right != null) {
            int result = findMinDepth(current.right, depth + 1);
            tmpMinDepth = tmpMinDepth > result ? result : tmpMinDepth;
        }

        if (current.left != null) {
            int result = findMinDepth(current.left, depth + 1);
            tmpMinDepth = tmpMinDepth > result ? result : tmpMinDepth;
        }

        return tmpMinDepth;
    }
}

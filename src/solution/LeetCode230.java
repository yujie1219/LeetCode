package solution;

import model.TreeNode;

public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        return findKth(root, new int[]{k});
    }


    private int findKth(TreeNode current, int[] k) {
        int leftVal = -1;
        if (current.left != null) {
            leftVal = findKth(current.left, k);
        }

        if (leftVal != -1) {
            return leftVal;
        }

        k[0] = k[0] - 1;
        if (k[0] == 0) {
            return current.val;
        }
        int rightVal = -1;
        if (current.right != null) {
            rightVal = findKth(current.right, k);
        }

        return rightVal;
    }
}

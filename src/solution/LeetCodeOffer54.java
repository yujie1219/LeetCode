package solution;

import model.TreeNode;

public class LeetCodeOffer54 {
    public int kthLargest(TreeNode root, int k) {
        return kthLargest(root, new int[]{k});
    }

    public int kthLargest(TreeNode current, int[] k) {
        int rightVal = -1;
        if (current.right != null) {
            rightVal = kthLargest(current.right, k);
        }

        if (rightVal != -1) {
            return rightVal;
        }

        k[0] = k[0] - 1;
        if (k[0] == 0) {
            return current.val;
        }

        int leftVal = -1;
        if (current.left != null) {
            rightVal = kthLargest(current.left, k);
        }

        return leftVal;
    }
}

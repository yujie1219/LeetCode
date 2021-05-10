package solution;

import model.TreeNode;

public class LeetCode897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode head = new TreeNode();
        TreeNode last = increasingBST(root, head);
        last.left = null;
        last.right = null;

        return head.right;
    }

    private TreeNode increasingBST(TreeNode current, TreeNode currentLast) {
        TreeNode last = null;

        if (current.left != null) {
            last = increasingBST(current.left, currentLast);
        }

        currentLast = last == null ? currentLast : last;
        currentLast.left = null;
        currentLast.right = null;
        currentLast.right = current;

        if (current.right != null) {
            last = increasingBST(current.right, currentLast.right);
        }

        return last == null ? current : last;
    }
}

package solution;

import model.TreeNode;

public class LeetCode538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        getSum(root);
        convert(root);

        return root;
    }

    private void convert(TreeNode current) {
        if (current == null) {
            return;
        }

        convert(current.left);
        int temp = current.val;
        current.val = this.sum;
        this.sum -= temp;
        convert(current.right);
    }

    private void getSum(TreeNode root) {
        if (root == null) {
            return;
        }

        this.sum += root.val;
        getSum(root.right);
        getSum(root.left);
    }
}

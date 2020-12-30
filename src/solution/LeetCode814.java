package solution;

import model.TreeNode;

public class LeetCode814 {
    public TreeNode pruneTree(TreeNode root) {
        boolean should = shouldCut(root);

        if(should){
            return null;
        }else{
            return root;
        }
    }

    private boolean shouldCut(TreeNode current) {
        boolean shouldCutLeft = true;
        boolean shouldCutRight = true;
        boolean shouldCutCurrent = current.val == 1 ? false : true;

        if (current.left != null) {
            shouldCutLeft = shouldCut(current.left);
        }

        if (current.right != null) {
            shouldCutRight = shouldCut(current.right);
        }

        if (shouldCutLeft) {
            current.left = null;
        }

        if (shouldCutRight) {
            current.right = null;
        }

        return shouldCutCurrent && shouldCutLeft && shouldCutRight;
    }
}

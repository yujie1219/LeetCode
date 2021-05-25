package solution;

import model.TreeNode;

public class LeetCode450 {
    TreeNode finalRoot;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        finalRoot = root;
        findKey(null, root, key);

        return finalRoot;
    }

    private void refactor(TreeNode parent, TreeNode root, int key) {
        TreeNode returnVal;
        if (root.left != null && root.right != null) {
            if (root.left.right == null) {
                root.left.right = root.right;
                returnVal = root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                returnVal = root.right;
            } else {
                TreeNode head = root;
                root = root.left;
                while (root.right != null) {
                    root = root.right;
                }
                root.right = head.right;
                returnVal = head.left;
            }
        } else if (root.left != null) {
            returnVal = root.left;
        } else if (root.right != null) {
            returnVal = root.right;
        } else {
            returnVal = null;
        }

        if (parent != null) {
            if (parent.left != null && parent.left.val == key) {
                parent.left = returnVal;
            } else {
                parent.right = returnVal;
            }
        } else {
            finalRoot = returnVal;
        }
    }

    public boolean findKey(TreeNode parent, TreeNode current, int key) {
        if (current == null) {
            return false;
        }

        if (current.val == key) {
            refactor(parent, current, key);
            return true;
        } else {
            if (findKey(current, current.left, key)) {
                return true;
            } else {
                return findKey(current, current.right, key);
            }
        }
    }
}

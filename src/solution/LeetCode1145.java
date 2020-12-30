package solution;

import model.TreeNode;

public class LeetCode1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findXNode(root, x);
        if (xNode != null) {
            int leftChildNumber = getTreeNodeNumber(xNode.left);
            int rightChildNumber = getTreeNodeNumber(xNode.right);

            int remainNumber = n - 1 - leftChildNumber - rightChildNumber;

            if (remainNumber > leftChildNumber + rightChildNumber || rightChildNumber > leftChildNumber + remainNumber || leftChildNumber > rightChildNumber + remainNumber) {
                return true;
            }

            return false;
        }

        return true;
    }

    private int getTreeNodeNumber(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        return getTreeNodeNumber(currentNode.left) + getTreeNodeNumber(currentNode.right) + 1;
    }

    private TreeNode findXNode(TreeNode currentNode, int x) {
        if (currentNode.val == x) {
            return currentNode;
        }

        TreeNode result = null;
        if (currentNode.left != null) {
            result = findXNode(currentNode.left, x);
        }

        return result == null ? (currentNode.right == null ? null : findXNode(currentNode.right, x)) : result;
    }
}

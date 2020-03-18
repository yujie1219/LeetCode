package solution;

import model.TreeNode;

public class LeetCode105 {

    public static void main(String[] args) {
        LeetCode105 leetCode105 = new LeetCode105();
        leetCode105.buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeNode(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (preIndex == preorder.length) {
            return null;
        }

        int currentVal = preorder[preIndex];
        TreeNode current = new TreeNode(currentVal);

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
                break;
            }
        }

        if (inIndex != -1) {
            ++preIndex;
            if (inIndex - inStart > 0) {
                current.left = buildTreeNode(preorder, inorder, preIndex, inStart, inIndex - 1);
            }

            if (inEnd - inIndex > 0) {
                current.right = buildTreeNode(preorder, inorder, preIndex + inIndex - inStart, inIndex + 1, inEnd);
            }
        }

        return current;
    }
}

package solution;

import model.TreeNode;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        invert(root);
        return root;
    }

    private void invert(TreeNode current){
        boolean hasLeft = current.left != null;
        boolean hasRight = current.right != null;

        if(hasLeft && hasRight){
            TreeNode left = current.left;
            current.left = current.right;
            current.right= left;

            invert(current.left);
            invert(current.right);
        }else if(hasLeft){
            current.right = current.left;
            current.left = null;
            invert(current.right);
        }else if(hasRight){
            current.left = current.right;
            current.right = null;
            invert(current.left);
        }
    }
}

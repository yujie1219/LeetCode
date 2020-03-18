package solution;

import model.TreeNode;

public class LeetCode114 {

    public void flatten(TreeNode root) {
        if(root != null){
            flattenTree(root);
        }
    }

    private void flattenTree(TreeNode current){
        boolean hasLeft = current.left != null;
        boolean hasRight = current.right != null;
        if(hasLeft && hasRight){
            flattenTree(current.left);
            flattenTree(current.right);

            TreeNode right = current.right;
            current.right = current.left;
            current.left = null;
            while(current.right != null){
                current = current.right;
            }
            current.right = right;
        }else if(hasLeft){
            flattenTree(current.left);

            current.right = current.left;
            current.left = null;
        }else if(hasRight){
            flattenTree(current.right);
        }
    }

//    private void flattenTree(TreeNode current){
//        boolean hasLeft = current.left != null;
//        boolean hasRight = current.right != null;
//        if(hasLeft && hasRight){
//            TreeNode right = current.right;
//            current.right = current.left;
//            TreeNode currentNode = current;
//            while(currentNode.right != null){
//                currentNode = currentNode.right;
//            }
//            currentNode.right = right;
//        }else if(hasLeft){
//            current.right = current.left;
//        }
//
//        current.left = null;
//        if(current.right != null) {
//            flattenTree(current.right);
//        }
//    }
}

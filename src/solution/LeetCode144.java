package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode current, List<Integer> result) {
        if (current != null) {
            result.add(current.val);

            preorder(current.left, result);
            preorder(current.right, result);
        }
    }
}

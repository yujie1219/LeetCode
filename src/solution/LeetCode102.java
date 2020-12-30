package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode102 {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            bFS(root,0);
        }

        return results;
    }

    private void bFS(TreeNode current, int level) {
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }

        results.get(level).add(current.val);

        if (current.left != null) {
            bFS(current.left, level + 1);
        }

        if (current.right != null) {
            bFS(current.right, level + 1);
        }
    }
}

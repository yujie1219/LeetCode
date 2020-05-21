package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getPathSum(root, sum, new ArrayList<>());

        return result;
    }

    private void getPathSum(TreeNode current, int target, List<Integer> path) {
        if (current == null) {
            return;
        }

        int val = current.val;
        target = target - val;
        path.add(val);
        if (current.left == null && current.right == null && target == 0) {
            this.result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        getPathSum(current.left, target, path);
        getPathSum(current.right, target, path);
        path.remove(path.size() - 1);
    }
}

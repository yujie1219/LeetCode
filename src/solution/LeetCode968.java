package solution;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode968 {
    public int minCameraCover(TreeNode root) {
        return camerNum(root, new HashMap<>());
    }

    private int camerNum(TreeNode current, Map<TreeNode, Integer> cache) {
        if (current == null) {
            return 0;
        }

        if (cache.containsKey(current.val)) {
            return cache.get(current.val);
        }

        int option1Val = 1;
        if (current.left != null) {
            option1Val += camerNum(current.left.left, cache) + camerNum(current.left.right, cache);
        }

        if (current.right != null) {
            option1Val += camerNum(current.right.left, cache) + camerNum(current.right.right, cache);
        }

        int option2Val = Integer.MAX_VALUE;
        if (current.left != null || current.right != null) {
            int firstOptinal2Val = camerNum(current.right, cache);
            if (current.left != null) {
                firstOptinal2Val += Math.min(camerNum(current.left, cache), camerNum(current.left.left, cache) + camerNum(current.left.right, cache)) + 1;
            }

            int secondOptinal2Val = camerNum(current.left, cache);
            if (current.right != null) {
                secondOptinal2Val += Math.min(camerNum(current.right, cache), camerNum(current.right.left, cache) + camerNum(current.right.right, cache))+ 1;
            }

            option2Val = Math.min(firstOptinal2Val, secondOptinal2Val);
        }

        cache.put(current, Math.min(option1Val, option2Val));

        return cache.get(current);
    }
}

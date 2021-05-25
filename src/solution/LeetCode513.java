package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode513 {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        BFS(root, nodes, 1);

        return nodes.get(nodes.keySet().size()).get(0);
    }

    public void BFS(TreeNode current, Map<Integer, List<Integer>> nodes, int level) {
        if (!nodes.containsKey(level)) {
            nodes.put(level, new ArrayList<>());
        }

        nodes.get(level).add(current.val);
        if (current.left != null) {
            BFS(current.left, nodes, level + 1);
        }

        if (current.right != null) {
            BFS(current.right, nodes, level + 1);
        }
    }
}

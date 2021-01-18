package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<TreeNode>> levelTraversalResults = new HashMap<>();
        levelTraversal(root, 0, levelTraversalResults);

        List<Integer> result = new ArrayList<>();
        for (Integer key : levelTraversalResults.keySet()) {
            List<TreeNode> levelTraversalResult = levelTraversalResults.get(key);
            result.add(levelTraversalResult.get(levelTraversalResult.size() - 1).val);
        }

        return result;
    }

    private void levelTraversal(TreeNode current, int level, Map<Integer, List<TreeNode>> levelTraversalResult) {
        if (current != null) {
            if (levelTraversalResult.containsKey(level)) {
                levelTraversalResult.get(level).add(current);
            } else {
                List<TreeNode> result = new ArrayList<>();
                result.add(current);
                levelTraversalResult.put(level, result);
            }

            levelTraversal(current.left, level + 1, levelTraversalResult);
            levelTraversal(current.right, level + 1, levelTraversalResult);
        }
    }


}

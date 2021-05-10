package solution;

import model.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root != null) {
            levelOrder(root, 0, results);
        }

        return results;
    }

    private void levelOrder(Node current, int level, List<List<Integer>> results) {
        if (results.size() <= level) {
            results.add(new ArrayList<>());
        }

        List<Integer> currentLevel = results.get(level);
        currentLevel.add(current.val);

        for (Node neighbor : current.neighbors) {
            levelOrder(neighbor, level + 1, results);
        }
    }
}

package solution;

import model.TreeNode;

import java.util.*;

public class LeetCode1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, Queue<Integer>> level2Value = new HashMap<>();
        this.initMap(root, 0, level2Value);

        return verify(level2Value, 0);
    }

    private void initMap(TreeNode current, int level, Map<Integer, Queue<Integer>> level2Value) {
        if (!level2Value.containsKey(level)) {
            level2Value.put(level, new LinkedList<>());
        }

        level2Value.get(level).offer(current.val);

        if (current.left != null) {
            initMap(current.left, level + 1, level2Value);
        }

        if (current.right != null) {
            initMap(current.right, level + 1, level2Value);
        }
    }

    private boolean verify(Map<Integer, Queue<Integer>> level2Value, int level) {
        if (level == level2Value.size()) {
            return true;
        }

        boolean isOdd = level % 2 == 1;

        Queue<Integer> values = level2Value.get(level);
        if (isOdd) {
            Integer parent = values.poll();
            if (parent % 2 == 1) {
                return false;
            }

            while (!values.isEmpty()) {
                Integer current = values.peek();
                if (parent <= current || current % 2 == 1) {
                    return false;
                }
                parent = values.poll();
            }

            return verify(level2Value, level + 1);
        } else {
            Integer parent = values.poll();
            if (parent % 2 == 0) {
                return false;
            }

            while (!values.isEmpty()) {
                Integer current = values.peek();
                if (parent >= current || current % 2 == 0) {
                    return false;
                }
                parent = values.poll();
            }

            return verify(level2Value, level + 1);

        }
    }
}

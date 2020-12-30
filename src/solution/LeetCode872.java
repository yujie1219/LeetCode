package solution;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> result1 = new LinkedList<>();
        if (root1 != null) {
            getLeafList(root1, result1);
        }

        Queue<Integer> result2 = new LinkedList<>();
        if (root2 != null) {
            getLeafList(root2, result2);
        }

        if (result1.size() != result2.size()) {
            return false;
        }

        while (!result1.isEmpty()) {
            if (!result1.poll().equals(result2.poll())) {
                return false;
            }
        }

        return true;
    }

    private void getLeafList(TreeNode currentNode, Queue<Integer> result) {
        if (currentNode.left != null || currentNode.right != null) {
            if (currentNode.left != null) {
                getLeafList(currentNode.left, result);
            }

            if (currentNode.right != null) {
                getLeafList(currentNode.right, result);
            }
        } else {
            result.add(currentNode.val);
        }
    }
}

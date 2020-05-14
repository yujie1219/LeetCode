package solution;

import model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {

    public static void main(String[] args) {
        new LeetCode95().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        allNodes(n, new int[n + 1], new ArrayList<>(), results);

        return results;
    }

    private void allNodes(int n, int[] used, List<Integer> node, List<TreeNode> results) {
        if (node.size() == n) {
            TreeNode root = new TreeNode(node.get(0));
            generateTreeNode(root, node, 1);
            if (!isExist(results, root)) {
                results.add(root);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == 1) {
                continue;
            }

            node.add(i);
            used[i] = 1;
            allNodes(n, used, node, results);
            used[i] = 0;
            node.remove(node.size() - 1);
        }
    }

    private void generateTreeNode(TreeNode root, List<Integer> node, int index) {
        if (index == node.size()) {
            return;
        }

        TreeNode current = new TreeNode(node.get(index));

        addNode(root, current);
        generateTreeNode(root, node, index + 1);
    }

    private void addNode(TreeNode parent, TreeNode current) {
        if (parent.val > current.val) {
            if (parent.left == null) {
                parent.left = current;
            } else {
                addNode(parent.left, current);
            }
        } else {
            if (parent.right == null) {
                parent.right = current;
            } else {
                addNode(parent.right, current);
            }
        }
    }

    private boolean isExist(List<TreeNode> results, TreeNode target) {
        for (TreeNode result : results) {
            if (isSameTree(result, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode result, TreeNode target) {
        if (result.val == target.val) {
            boolean leftSame = true;
            if (result.left != null && target.left != null) {
                leftSame = isSameTree(result.left, target.left);
            } else if (result.left == null && target.left == null) {
                leftSame = true;
            } else {
                leftSame = false;
            }

            boolean rightSame = true;
            if (result.right != null && target.right != null) {
                rightSame = isSameTree(result.right, target.right);
            } else if (result.right == null && target.right == null) {
                rightSame = true;
            } else {
                rightSame = false;
            }

            return leftSame && rightSame;
        }

        return false;
    }
}

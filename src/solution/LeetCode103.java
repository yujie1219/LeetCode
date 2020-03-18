package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode103 {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root != null){
            List<TreeNode> rootWrapper = new ArrayList<>();
            rootWrapper.add(root);
            zigzagBFS(rootWrapper, false);
        }

        return results;
    }

    private void zigzagBFS(List<TreeNode> currents, boolean leftFirst) {
        results.add(currents.stream().map(item -> item.val).collect(Collectors.toList()));
        List<TreeNode> children = new ArrayList<>();
        for (int i = currents.size() - 1; i >= 0; i--) {
            TreeNode left = currents.get(i).left;
            TreeNode right = currents.get(i).right;
            if (leftFirst) {
                if (left != null) {
                    children.add(left);
                }

                if (right != null) {
                    children.add(right);
                }
            } else {

                if (right != null) {
                    children.add(right);
                }
                if (left != null) {
                    children.add(left);
                }
            }
        }

        if (children.size() != 0) {
            zigzagBFS(children, !leftFirst);
        }
    }
}

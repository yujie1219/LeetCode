package solution;

import model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> currents = new ArrayList<>();
        currents.add(root);
        return breadthTraversal(currents);
    }

    private boolean breadthTraversal(List<TreeNode> currents) {
        int i = 0;
        int j = currents.size() - 1;
        boolean allNull = true;
        while (i <= j) {
            TreeNode font = currents.get(i);
            TreeNode behind = currents.get(j);
            if (font == null && behind == null) {
                i++;
                j--;
            } else if (font != null && behind != null) {
                allNull = false;
                if (font.val == behind.val) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (allNull) {
            return true;
        } else {
            List<TreeNode> childs = new ArrayList<>();
            for (TreeNode current : currents) {
                childs.add(current == null ? null : current.left);
                childs.add(current == null ? null : current.right);
            }
            return breadthTraversal(childs);
        }
    }
}

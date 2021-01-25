package solution;

import model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode919 {
    class CBTInserter {

        private TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int v) {
            Queue<TreeNode> currents = new LinkedList<>();
            currents.offer(this.root);
            TreeNode last = findLastPreInOrder(currents);
            if (last.left == null) {
                last.left = new TreeNode(v);
            } else if (last.right == null) {
                last.right = new TreeNode(v);
            }

            return last.val;
        }

        private TreeNode findLastPreInOrder(Queue<TreeNode> currents) {
            Queue<TreeNode> children = new LinkedList<>();
            for (TreeNode current : currents) {
                if (current.left == null || current.right == null) {
                    return current;
                }

                children.offer(current.left);
                children.offer(current.right);
            }

            return findLastPreInOrder(children);
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}

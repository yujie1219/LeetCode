package solution;

import model.TreeNode;

import java.util.Stack;

public class LeetCode173 {

    class BSTIterator {

        private Stack<Integer> next;

        public BSTIterator(TreeNode root) {
            next = new Stack<>();
            init(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return next.pop();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !next.empty();
        }

        private void init(TreeNode current) {
            if(current == null){
                return;
            }

            if (current.right == null && current.left == null) {
                next.push(current.val);
                return;
            }

            if (current.right != null) {
                init(current.right);
            }

            next.push(current.val);

            if (current.left != null) {
                init(current.left);
            }
        }
    }
}

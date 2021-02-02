package solution;

import model.ListNode;
import model.TreeNode;

public class LeetCode1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return findTreeStart(head, root);
    }

    private boolean findTreeStart(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.val == head.val) {
            if (startJudge(head, root)) {
                return true;
            }
        }


        boolean leftResult = false;
        if (root.left != null) {
            leftResult = findTreeStart(head, root.left);
        }


        boolean rightResult = false;
        if (root.right != null) {
            rightResult = findTreeStart(head, root.right);
        }

        return leftResult || rightResult;
    }

    private boolean startJudge(ListNode head, TreeNode root) {
        if (head.next == null) {
            return true;
        }

        if (root.right == null && root.left == null) {
            return false;
        }

        boolean leftResult = false;
        if (root.left != null) {
            if (root.left.val == head.next.val) {
                leftResult = startJudge(head.next, root.left);
            }
        }

        boolean rightResult = false;
        if (root.right != null) {
            if (root.right.val == head.next.val) {
                rightResult = startJudge(head.next, root.right);
            }
        }

        return leftResult || rightResult;
    }
}

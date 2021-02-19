package solution;

import model.TreeNode;

import java.util.Stack;

public class LeetCode236 {

    // 自底向上的递归遍历二叉树，定义 fx 表示 x节点的子树是否包含p或者q，如果包含则为true，否则为false
    // 那么最近公共祖先 x 一定满足   (flson && frson) || ((x = p || x = q) && (flson || frson))
    // lson和rson分别代表x的左右子树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Integer> root2P = new Stack<>();
        Stack<Integer> root2q = new Stack<>();

        findRoute(root, p.val, q.val, root2P, root2q);

        Integer result = null;
        while (!root2P.isEmpty()) {
            Integer current = root2P.pop();
            if (root2q.contains(current)) {
                result = current;
                break;
            }
        }

        return new TreeNode(result);
    }

    private void findRoute(TreeNode current, Integer p, Integer q, Stack<Integer> root2P, Stack<Integer> root2q) {
        if (current == null || (!root2P.isEmpty() && !root2q.isEmpty() && root2P.peek().equals(p) && root2q.peek().equals(q))) {
            return;
        }

        if (root2P.isEmpty() || !root2P.peek().equals(p)) {
            root2P.add(current.val);
        }

        if (root2q.isEmpty() || !root2q.peek().equals(q)) {
            root2q.add(current.val);
        }

        findRoute(current.left, p, q, root2P, root2q);
        findRoute(current.right, p, q, root2P, root2q);

        if (!root2P.peek().equals(p)) {
            root2P.pop();
        }

        if (!root2q.peek().equals(q)) {
            root2q.pop();
        }
    }
}

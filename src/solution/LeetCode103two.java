package solution;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode103two {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> current = new Stack<>();
            current.push(root);
            doAl(current,result,true);
        }

        return result;
    }

    private void doAl(Stack<TreeNode> current, List<List<Integer>> result, boolean isLeft) {
        List<Integer> currentResult = new ArrayList<>();
        Stack<TreeNode> next = new Stack<>();
        while (!current.isEmpty()) {
            TreeNode currentNode = current.pop();
            if(currentNode != null) {
                currentResult.add(currentNode.val);
                if (isLeft) {
                    next.push(currentNode.left);
                    next.push(currentNode.right);
                } else {
                    next.push(currentNode.right);
                    next.push(currentNode.left);
                }
            }
        }

        if(currentResult.size() != 0) {
            result.add(currentResult);
            doAl(next, result, !isLeft);
        }
    }
}

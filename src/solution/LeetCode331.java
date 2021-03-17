package solution;

import java.util.Stack;

public class LeetCode331 {
    public boolean isValidSerialization(String preorder) {
        String[] preorders = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        for (String node : preorders) {
            if (stack.isEmpty()) {
                return false;
            }

            int top = stack.pop() - 1;
            if (top > 0) {
                stack.push(top);
            }
            if (!node.equals("#")) {
                stack.push(2);
            }
        }

        return stack.isEmpty();
    }
}

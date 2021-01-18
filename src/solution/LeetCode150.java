package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        List<String> expression = new ArrayList<>();
        expression.add("+");
        expression.add("-");
        expression.add("*");
        expression.add("/");

        Stack<Integer> tokenStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (expression.contains(token)) {
                tokenStack.push(doExpress(tokenStack.pop(), tokenStack.pop(), token));
            } else {
                tokenStack.push(Integer.parseInt(token));
            }
        }

        return tokenStack.pop();
    }

    private int doExpress(int val2, int val1, String express) {
        switch (express) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                return 0;
        }
    }
}

package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode241 {
    public static void main(String[] args) {
        new LeetCode241().diffWaysToCompute("2-1-1");
    }

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0) {
            return new ArrayList<>();
        }

        int length = expression.length();
        return diffWaysToCompute(expression, 0, length - 1, new List[length][length]);
    }

    private List<Integer> diffWaysToCompute(String expression, int start, int end, List<Integer>[][] cache) {
        List<Integer> result = new ArrayList<>();

        if (end == start) {
            result.add(Integer.parseInt(expression.substring(start, end + 1)));
            cache[start][end] = result;
            return result;
        }

        if (end - start == 2) {
            int left = Integer.parseInt(expression.substring(start, start + 1));
            int right = Integer.parseInt(expression.substring(end, end + 1));
            result.add(getResult(left, right, expression.substring(start + 1, end)));
            cache[start][end] = result;
            return result;
        }

        if (cache[start][end] != null) {
            return cache[start][end];
        }

        for (int i = start; i <= end; i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                List<Integer> lefts = diffWaysToCompute(expression, start, i - 1, cache);
                List<Integer> rights = diffWaysToCompute(expression, i + 1, end, cache);
                String exp = expression.substring(i, i + 1);

                for (int left : lefts) {
                    for (int right : rights) {
                        result.add(getResult(left, right, exp));
                    }
                }
            }
        }

        if (result.isEmpty() && start != end) {
            result.add(Integer.parseInt(expression.substring(start, end + 1)));
        }

        cache[start][end] = result;
        return result;
    }

    private int getResult(int left, int right, String expression) {
        switch (expression) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            default:
                return 0;
        }
    }
}

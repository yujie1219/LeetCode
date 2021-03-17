package solution;

import java.util.Stack;
import java.util.regex.Pattern;

public class LeetCode227 {
    public static void main(String[] args) {
        new LeetCode227().calculate("3 +2*2");
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            Character current = s.charAt(i);

            StringBuilder stringBuilder = new StringBuilder();
            while (Character.isDigit(current) && i < s.length() - 1) {
                stringBuilder.append(current);
                current = s.charAt(++i);
            }
            if (i == s.length() - 1 && Character.isDigit(current)) {
                stringBuilder.append(current);
                i++;
            }

            if (stringBuilder.length() > 0) {
                nums.push(Integer.parseInt(stringBuilder.toString()));
            }

            if (current == ' ') {
                i++;
                continue;
            }

            if (i < s.length()) {
                if (ops.isEmpty() || current == '(') {
                    ops.push(current);
                } else {
                    if (current == ')') {
                        while (ops.peek() != '(') {
                            int a = nums.pop();
                            int b = nums.pop();
                            Character currentOp = ops.pop();
                            nums.push(doCalculate(a, b, currentOp));
                        }
                        ops.pop();
                    } else {
                        if (current == '+' || current == '-') {
                            while (!ops.isEmpty() && ops.peek() != '(') {
                                int a = nums.pop();
                                int b = nums.pop();
                                Character currentOp = ops.pop();
                                nums.push(doCalculate(a, b, currentOp));
                            }
                            ops.push(current);
                        } else if (current == '*' || current == '/') {
                            while (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                                int a = nums.pop();
                                int b = nums.pop();
                                Character currentOp = ops.pop();
                                nums.push(doCalculate(a, b, currentOp));
                            }
                            ops.push(current);
                        }
                    }
                }
            }
            i++;
        }

        while (!ops.isEmpty()) {
            int a = nums.pop();
            int b = nums.pop();
            Character currentOp = ops.pop();
            nums.push(doCalculate(a, b, currentOp));
        }

        return nums.pop();
    }

    private Integer doCalculate(Integer a, Integer b, Character ops) {
        switch (ops) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
            default:
                return 0;
        }
    }
}
